package com.example.java.basics.arrays.level2;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CommonElementInTwoArrays {
	public static void main(String[] args) {
	int[] arr = {1,2,3,4,5};
	int[] arr1= {1,3,6,7,8,9};
	int[] common = findCommon(arr, arr1);
	
	Arrays.stream(common).forEach(System.out::println);
	
	int[] common1 = findCommonUsingStreams(arr, arr1);
	
	Arrays.stream(common).forEach(System.out::println);
	}

	private static int[] findCommon(int[] arr, int[] arr1) {
		// TODO Auto-generated method stub
		int count=0;
		for(int i=0; i < arr.length; i++ ) {
			for(int j=0; j< arr1.length; j++) {
				if(arr1[j] == arr[i]) {
					count++;
				}
			}
		}
		int[] arr2= new int[count];
		count=0;
		for(int i=0; i < arr.length; i++ ) {
			for(int j=0; j< arr1.length; j++) {
				if(arr1[j] == arr[i]) {
					arr2[count] = arr1[j];
					count++;
				}
			}
		}
		return arr2;
	}
	
	private static int[] findCommonUsingStreams(int[] arr, int[] arr1) {
		return Arrays.stream(arr).filter(a -> Arrays.asList(arr1).contains(a)).toArray();
	}
}
