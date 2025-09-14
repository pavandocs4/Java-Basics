package com.example.java.advance.java8concepts;

import java.util.Arrays;
import java.util.List;

public class ParallerStreams {
	
	public static void main(String[] args) {
		List<Integer> intList = Arrays.asList(1,2,3,4,5);
		System.out.println("Sequential stream operation:");
		intList.stream().map(val-> val*val).forEach(System.out::println);
		System.out.println("Parallel stream operation:");
		intList.parallelStream().map(val-> val*val).forEach(System.out::println);
	}

}
