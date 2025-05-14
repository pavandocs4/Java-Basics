package com.example.java.basics.arrays.level2;

import java.util.Arrays;
import java.util.stream.IntStream;

public class RotateArray {
	public static void main(String[] args) {
		int[] arr= {1,2,3,4,5,6};
		int[] rotated= rotate(arr);
	}

	private static int[] rotate(int[] arr) {
		// TODO Auto-generated method stub
		return IntStream.range(0, arr.length).map(i -> arr[i+1]).toArray();
		
	}

}
