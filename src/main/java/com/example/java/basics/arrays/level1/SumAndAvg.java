package com.example.java.basics.arrays.level1;

import java.util.Arrays;

public class SumAndAvg {
	public static void main(String[] args) {
		int[] arr= {1,2,3,4,5};
		int sum= findSum(arr);
		double avg = findAvg(arr);
		System.out.println("Sum is:"+sum+" and average is:"+avg);
	}

	private static double findAvg(int[] arr) {
		// TODO Auto-generated method stub
		return Arrays.stream(arr).average().getAsDouble();
	}

	private static int findSum(int[] arr) {
		return Arrays.stream(arr).sum();
	}

}
