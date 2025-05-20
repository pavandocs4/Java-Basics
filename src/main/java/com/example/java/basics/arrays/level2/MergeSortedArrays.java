package com.example.java.basics.arrays.level2;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MergeSortedArrays {
	public static void main(String[] args) {
		int[] arr = { 1, 5, 3, 4, 2 };
		int[] arr1 = { 2, 8, 5, 6, 7, 3 };
		int[] merged = mergeArrays(arr, arr1);
		Arrays.stream(merged).distinct().forEach(System.out::println);
	}

	private static int[] mergeArrays(int[] arr, int[] arr1) {
		// TODO Auto-generated method stub
		int[] op = new int[arr.length + arr1.length];
		int[] val1 = IntStream.range(0, arr.length).map(i -> arr[i]).sorted().toArray();
		//Arrays.stream(val1).forEach(System.out::print);
		int[] val2 = IntStream.range(0, arr1.length).map(i -> arr1[i]).sorted().toArray();
		//Arrays.stream(val2).forEach(System.out::print);
		for (int i = 0; i < (val1.length + val2.length); i++) {
			op[i] = i < val1.length ? val1[i] : val2[i - val1.length];
		}
		return op;

	}

}
