package com.example.java.advance.java8concepts;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class NewLocalDateTimeAPITest {
	public static void main(String[] args) {
		//print 5th day of every month from 24 to 25
		//List<String> dayList = Arrays.asList();
		LocalDate date = LocalDate.of(2024, 01, 05);
		while(date.getYear() == 2024) {
			System.out.println(date.getDayOfWeek());
			date=date.plusMonths(1);
			//dayList.add(date.getDayOfMonth());
		}
				
	// using a Local time or date to print the current time
		
	
	}
}
