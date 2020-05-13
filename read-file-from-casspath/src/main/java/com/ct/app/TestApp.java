package com.ct.app;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.ct.app.model.DataTable;
import com.ct.app.service.ConcentrationService;

public class TestApp {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		ConcentrationService ConcentrationService = new ConcentrationService();

		List<DataTable> readExcelSheetAndReturnList = ConcentrationService.readExcelSheetAndReturnList();

		List<DataTable> dataTableListWithSubValOne = readExcelSheetAndReturnList.stream()
				.filter(data -> data.getSubject() == 1).collect(Collectors.toList());
		

		List<DataTable> dataTableListWithSubValTwo = readExcelSheetAndReturnList.stream()
				.filter(data -> data.getSubject() == 2).collect(Collectors.toList());

		//Write your calculation logic from here Start
		
		   DataTable maxCpWithSubjectGroupOne = dataTableListWithSubValOne.stream()
		  .max(Comparator.comparing(DataTable::getCp)).get();
		  
		  System.out.println("max CP  object one "+maxCpWithSubjectGroupOne);
		  
		  DataTable maxCpWithSubjectGroupTwo = dataTableListWithSubValTwo.stream()
				  .max(Comparator.comparing(DataTable::getCp)).get();
		  
		  System.out.println("max CP  object one "+maxCpWithSubjectGroupTwo);
		  
		//Write your calculation logic from here End
		
		
		
		//Test subject group one and two
		System.out.println("subject value one");

		dataTableListWithSubValOne.stream().forEach(System.out::println);

		System.out.println("subject value two");

		dataTableListWithSubValTwo.stream().forEach(System.out::println);
	}
}
