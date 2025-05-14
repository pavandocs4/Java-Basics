package com.example.java.basics.arrays.level1;

import java.util.Arrays;
import java.util.stream.IntStream;

public class CopyElements {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6};
		int[] arrNew= new int[arr.length];
		
		arrNew= IntStream.range(0, arr.length).map(i-> arr[i]).toArray();
		Arrays.stream(arrNew).forEach(System.out::println);
	}

}
