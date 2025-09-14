package com.example.java.advance.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.Stream.Builder;

public class AllIntermediateOperations {
	public static void main(String[] args) {
		List<List<String>> items = Arrays.asList(Arrays.asList("Rahul", "Pritam", "Rocky", "Niki"),
				Arrays.asList("Pavan", "Rocky", "Aemi", "Rameshwar"),
				Arrays.asList("Kirtana", "Rocky", "Lavanya", "Om"),
				Arrays.asList("Prajakta", "Rocky", "Reshma", "Deva"));

		Stream.iterate(2, (n)-> { return n*n;}).limit(5).forEach(System.out::println);

		List<String> finalList = items.stream().flatMap(list -> list.stream()).map(str -> str.toLowerCase())
				.filter(st -> st.length() > 3).distinct().sorted().peek(System.out::println)
				.collect(Collectors.toList());
		// .collect(Collectors.groupingBy(String::length, Collectors.toList()));

		System.out.println("Final Result" + finalList);
	}
}
