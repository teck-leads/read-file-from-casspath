package com.ct.app;

import java.util.Arrays;
import java.util.List;

public class Test2 {

	public static void main(String[] args) {
		int s=3, e=9;
		for(int i=3; i<=9; i++) {
			if(i%2!=0) {
				System.out.println(i);
			}
		}
		
	}

	
	public static void containsElement() {
		List<Integer> asList = Arrays.asList(1,2,3,4,5);
		int key = 1;
		
		boolean anyMatch = asList.stream()
		.anyMatch(list -> list==key);
		
		if(anyMatch) {
			System.out.println("Present");
		}else {
			System.out.println("Not Present");
		}
	}
}
