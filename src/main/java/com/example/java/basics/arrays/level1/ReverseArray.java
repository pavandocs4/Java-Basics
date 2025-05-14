package com.example.java.basics.arrays.level1;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ReverseArray {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		int[] rev = reverseArray(arr);
		Arrays.stream(rev).forEach(System.out::println);

		int[] revByStreams = reverseArrayByStreams(arr);
		System.out.println("By Using Streams*********************\n");
		Arrays.stream(revByStreams).forEach(System.out::println);
		IntStream.range(0, arr.length).forEach(System.out::print);

	}

	private static int[] reverseArray(int[] arr) {
		// TODO Auto-generated method stub
		int[] op = new int[arr.length];
		int count = 0;
		for (int i = arr.length - 1; i >= 0; i--) {
			op[count] = arr[i];
			count++;
		}
		return op;
	}

	private static int[] reverseArrayByStreams(int[] arr) {
		int[] rev = IntStream.range(0, arr.length).map(i -> arr[arr.length - 1 - i]).toArray();
		return rev;
	}

}
