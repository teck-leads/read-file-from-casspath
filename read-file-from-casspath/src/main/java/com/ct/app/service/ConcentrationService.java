package com.ct.app.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ct.app.model.DataTable;

public class ConcentrationService {

	public List<DataTable> readExcelSheetAndReturnList() throws FileNotFoundException, IOException {

		File fileFromResources = getFileFromResources("DataFile.xlsx");
		List<DataTable> dataTableList = new ArrayList<>();
		try (FileInputStream fileInputStream = new FileInputStream(fileFromResources)) {
			// open the file from a given location:
			Workbook workbook = new XSSFWorkbook(fileInputStream);
			// Retrieve the first sheet of the file and iterate through each row:
			Sheet sheetOne = workbook.getSheetAt(0);

			// Iterate through each rows one by one
			Iterator<Row> iterator = sheetOne.iterator();
			boolean flag = false;
			while (iterator.hasNext()) {
				DataTable dataTable = new DataTable();
				Row row = (Row) iterator.next();

				// For each row, iterate through all the columns
				Iterator<Cell> cellIterator = row.cellIterator();

				if (flag) {// Skip the first heading row

					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						// Check the cell type and format accordingly
						switch (cell.getCellType()) {
						case NUMERIC:
							int columnIndex = cell.getColumnIndex();
							if (columnIndex == 0) {
								dataTable.setSubject((int) cell.getNumericCellValue());
							} else if (columnIndex == 1) {
								dataTable.setTime(cell.getNumericCellValue());
							} else if (columnIndex == 2) {
								dataTable.setCp(cell.getNumericCellValue());
							}
							break;
						default:
							break;
						}
					}
					dataTableList.add(dataTable);
				}
				flag = true;
			}
			return dataTableList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataTableList;
	}

	// get file from classpath, resources folder
	private File getFileFromResources(String fileName) {

		ClassLoader classLoader = getClass().getClassLoader();

		URL resource = classLoader.getResource(fileName);
		if (resource == null) {
			throw new IllegalArgumentException("file is not found!");
		} else {
			return new File(resource.getFile());
		}

	}

}
