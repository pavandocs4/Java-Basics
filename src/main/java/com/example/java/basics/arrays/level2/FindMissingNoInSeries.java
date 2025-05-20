package com.example.java.basics.arrays.level2;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindMissingNoInSeries {
	public static void main(String[] args) {
		int n = 10;
		int randomKey = n/4;
		int[] arr = IntStream.range(0, n).filter(i -> i!=randomKey).map(i -> i).toArray();
		//Arrays.stream(arr).forEach(System.out::println);
		//System.out.println(randomKey);
		OptionalInt num = missingNo(arr);
		System.out.println(num.getAsInt());
		
		
	}

	private static OptionalInt missingNo(int[] arr) {
		// TODO Auto-generated method stub
		return IntStream.range(0, arr.length).filter(i -> i!=arr[i]).findFirst();
	}

}
