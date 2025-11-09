package com.example.java.advance.java8concepts.newdatetimeapi;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class StaticMethodsInNewApi {
	public static void main(String[] args) {
		LocalDate date = LocalDate.now();
		System.out.println(date);

		ZoneId id = ZoneId.systemDefault();
		System.out.println("SystemZoneId:" + id);

		LocalDateTime datebyzonedefault = LocalDateTime.now(id);
		System.out.println("deffault system zone date time:" + datebyzonedefault);

		LocalDateTime datebyzone = LocalDateTime.now(ZoneId.of("Europe/Paris"));
		System.out.println("Europe/Paris zone date time:" + datebyzone);
		DateTimeFormatter format = DateTimeFormatter.ofPattern("E M yy");
		String newFormat = datebyzone.format(format);
		System.out.println("datebyzone after formatting: " + newFormat);

		LocalDateTime byClock = LocalDateTime.now(Clock.systemUTC());
		System.out.println(byClock);
		
		LocalDateTime ofMethod = LocalDateTime.of(LocalDate.now().getYear(), LocalDate.now().getMonth(),
				LocalDate.now().getDayOfMonth(), LocalTime.now().getHour(), LocalTime.now().getMinute(), LocalTime.now().getSecond());
	
		System.out.println("by of method: "+ofMethod);
		
		LocalDate parseMethod =LocalDate.parse("2025-10-11");
		System.out.println("by parse method:"+parseMethod);
		
		
	}
}
