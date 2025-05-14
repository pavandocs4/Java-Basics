package com.example.java.basics.arrays.level1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArraySort {
	public static void main(String[] args) {
		int[] arr= {4,5,6,3,21,1,3};
		int[] arrSorted= sort(arr);
		Arrays.stream(arrSorted).forEach(System.out::println);
		int[] arrAscending= sortAscending(arrSorted);
		System.out.println("**********************************\n");
		Arrays.stream(arrAscending).forEach(System.out::println);
		
	}

	private static int[] sortAscending(int[] arr) {
		// TODO Auto-generated method stub
		return IntStream.range(0, arr.length).map(i -> arr[arr.length-1-i]).toArray();
	}

	private static int[] sort(int[] arr) {
		int[] list=  IntStream.range(0, arr.length).map(i-> arr[i]).sorted().toArray();
		return list;
	}

}
