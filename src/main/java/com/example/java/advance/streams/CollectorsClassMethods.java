package com.example.java.advance.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import java.util.Map;

public class CollectorsClassMethods {

	public static void main(String[] args) {

		// averagingDouble: This methods takes lambda function as input producing the
		// average of double values

		List<Double> doubleList = Arrays.asList(22.33, 33.44, 67.77, 98.87);
		Double avg = doubleList.stream().collect(Collectors.averagingDouble(num -> num));
		System.out.println("averagingDouble demo ex1: " + avg);
		Double avg1 = Stream.of(3, 5, 6, 7, 9)
				.collect(Collectors.averagingDouble(num -> Double.parseDouble(String.valueOf(num))));
		System.out.println("averagingDouble demo ex2: " + avg1);

		// collectingAndThen this function is used when we need to collect all the
		// elements first in any collections and further need to
		// perform any operation on the collection

		List<List<String>> nameList = Arrays.asList(Arrays.asList("Rahul", "Pritam", "Rocky", "Niki"),
				Arrays.asList("Pavan", "Rocky", "Aemi", "Rameshwar"),
				Arrays.asList("Kirtana", "Rocky", "Lavanya", "Om"),
				Arrays.asList("Prajakta", "Rocky", "Reshma", "Deva"));
		
		Map<Integer, List<String>> newList1 = nameList.stream().flatMap(list -> list.stream()).distinct()
				.collect(Collectors.collectingAndThen(Collectors.toList(),
						list -> list.stream().collect(Collectors.groupingBy(String::length, Collectors.toList()))));
		System.out.println(newList1);

		// Collectors.counting() this function is used for counting the elements.
		// Ex- find the repeating characters in a String
		String str = "Pavan";
		str.chars().mapToObj(a -> (char) a).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.forEach((a, b) -> System.out.println(a + ":" + b));

			// Collectors.filtering methods allows us to filter the collection based on the
			// predicate and downstream the same
		//filtering() and flatMapping() added in java 9
		System.out.println("Collectors.filtering demo");
		List<String> filteredList = nameList.stream().flatMap(list -> list.stream())
				.collect(Collectors.filtering(ele -> ele.length() < 5, Collectors.toList()));

		filteredList.forEach(System.out::println);

		/*
		 * Collectors.groupingBy methods is used to group the elements based on the
		 * function provided. It takes function and downstream as parameter 1. Let’s
		 * start with the simplest groupingBy method, which only takes a classification
		 * function as its parameter. A classification function is applied to each
		 * element of the stream.
		 */ System.out.println("Collectors.groupingBy demo with only function");
		Map<Integer, List<String>> groupedMap = nameList.stream().flatMap(list -> list.stream())
				.collect(Collectors.groupingBy(String::length));
		System.out.println(groupedMap);

		// 2.
		System.out.println("Collectors.groupingBy demo with function and downstream collector");
		Map<Integer, List<String>> groupedMap1 = nameList.stream().flatMap(list -> list.stream())
				.collect(Collectors.groupingBy(String::length, Collectors.toList()));
		System.out.println(groupedMap1);

		// complex groupingBy functions are covered on separate class GroupingByEx

		// Collectors.joining() this method is used to concate the elements in a string
		String name = "Pavan";
		String result = IntStream.range(0, name.length())
				.filter(i -> !name.substring(i + 1).contains(String.valueOf(name.charAt(i))))
				.mapToObj(j -> String.valueOf(name.charAt(j))).collect(Collectors.joining());
		System.out.println("Colloctors.joining ex: unique chars in a name are:-" + result);

		// Collectors.partitioningBy is use to do partition of collection in two parts
		List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		Map<Boolean, List<Integer>> intMap = intList.stream().collect(Collectors.partitioningBy(val -> val > 3));
		System.out.println("Collectors.partitioningBy demo:" + intMap);

		// same can be done using groupingBy
		Map<Boolean, List<Integer>> intMapGroupBy = intList.stream().collect(Collectors.groupingBy(val -> val > 3));
		System.out.println("intMapGroupBy demo:" + intMapGroupBy);

		// we can also provide the downstream collector along with the function as below

		Map<Boolean, Long> intMapCount = intList.stream()
				.collect(Collectors.partitioningBy(val -> val > 3, Collectors.counting()));
		System.out.println("Collectors.partitioningBy demo with downstream collector:" + intMapCount);

		// Collectors.reducing function is similar reduce method. This can be used with
		// different ways
		// 1. Using reducing() with Binary Operato Ex. sum

		int sum = intList.stream().collect(Collectors.reducing(Integer::sum)).get();
		System.out.println("1. Collectors.reducing with only binary function: sum is:->" + sum);

		// 2. with binary operator
		int multiplication = intList.stream().collect(Collectors.reducing(1, (a, b) -> a * b));
		System.out.println(
				"2. Using reducing() with Binary Operator and Identity Value: multiplication is:->" + multiplication);

		// 3. Using reducing() with a Binary Operator, Identity Value, and Mapper
		// Function
		int sumOfSquare = intList.stream().collect(Collectors.reducing(0, n -> n * n, (a, b) -> a + b));
		System.out.println(
				"3. Using reducing() with Binary Operator and Identity Value: sumOfSquare is:->" + sumOfSquare);

		// Collectors.summarizing is very usefull function as provides all the statitics
		// for provide int, double or long
		// elements of stream
		//
		IntSummaryStatistics intSummery = intList.stream().collect(Collectors.summarizingInt(val -> val));
		System.out.println("Collectors.summarizing demo: " + intSummery);

		// applying it to custom values
		IntSummaryStatistics intSummeryForObj = nameList.stream().flatMap(list -> list.stream())
				.collect(Collectors.summarizingInt(val -> val.length()));

		System.out.println("Collectors.summarizing demo with custom object list: " + intSummeryForObj);

		/*
		 * The Collectors.teeing() method is useful when we want to simultaneously
		 * process a stream in two different ways and then combine their results public
		 * static Collector teeing​ (Collector downstream1, Collector downstream2,
		 * BiFunction merger);
		 * 
		 * public static Collector teeing​ (Collector downstream1, Collector
		 * downstream2, BiFunction merger);
		 */
		// ex find the max length and min length of names
		Map<String, String> strMapNew = nameList.stream().flatMap(list -> list.stream())
				.collect(Collectors.teeing(
						Collectors.maxBy(Comparator.comparing(String::length)),
						Collectors.minBy(Comparator.comparing(String::length)),
						(s1, s2) -> {
							Map<String, String> strMap = new HashMap<String, String>();
							strMap.put("MAX" , s1.get());
							//strMap.put("MIN", s2.get());
							return strMap;
						}));
		
		System.out.println(strMapNew);
		
	}

}
