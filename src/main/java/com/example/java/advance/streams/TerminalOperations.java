package com.example.java.advance.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TerminalOperations {
	public static void main(String[] args) {

		List<String> cities = Arrays.asList("Nagpur", "Pune", "Raypur", "Banglore", "Patna", "Indore", "Amravati");

		// for Each
		System.out.println("For each demo:");
		cities.stream().forEach(city -> System.out.print(city + " "));
		System.out.println();

		// collect
		System.out.println("\ncollect demo:");
		List<String> cityList = cities.stream().filter(city -> !city.startsWith("A")).collect(Collectors.toList());
		System.out.println(cityList);

		// reduce
		System.out.println("\nreduce demo:");
		List<Integer> intList = Arrays.asList(4, 3, 5, 6, 7, 8, 9);
		int evenNoSum = intList.stream().filter(num -> num % 2 == 0).reduce(0, (a, b) -> a + b);
		System.out.println(evenNoSum);

		// count
		System.out.println("\ncount demo:");
		int evenNoCount = (int) intList.stream().filter(num -> num % 2 == 0).count();
		System.out.println(evenNoCount);

		// findFirst
		System.out.println("\nfindfirst demo:");
		int firstEvenNo = (int) intList.stream().filter(num -> num % 2 == 0).findFirst().get();
		System.out.println(firstEvenNo);

		// allMatch
		System.out.println("\nallMatch demo:");
		boolean allMatchFlag = intList.stream().allMatch(a -> a % 2 == 0);
		System.out.println(allMatchFlag);

		// anyMatch
		System.out.println("\nanyMatch demo:");
		boolean anyMatchFlag = intList.stream().anyMatch(a -> a % 2 == 0);
		System.out.println(anyMatchFlag);

	}
}
