package com.example.java.basics.arrays.level1;

import java.util.stream.IntStream;

public class ValueFinder {
	public static void main(String[] args) {
		int[] arr= {1,2,3,4,5, 6,6};
		int value= 6;
		int isValue= findValue(arr, value);
		System.out.println("The occurences of the value are:"+isValue);
	}

	private static int findValue(int[] arr, int value) {
		// TODO Auto-generated method stub
		return (int) IntStream.range(0, arr.length).filter(val -> arr[val] == value).count();
	}

}
