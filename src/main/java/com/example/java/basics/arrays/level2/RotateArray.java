package com.example.java.basics.arrays.level2;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RotateArray {
	public static void main(String[] args) {
		int[] arr= {1,2,3,4,5,6};
		int n=2;
		List<Integer> rotated= rotateLeftToRight(arr, n);
		System.out.println("Left to right rotation by "+n+" position\n"+rotated);
		
		List<Integer> rotatedOp= rotateRightToLeft(arr, n);
		System.out.println("Right to left rotation by "+n+" position\n"+rotatedOp);
	}

	private static List<Integer> rotateLeftToRight(int[] arr, int n) {
		// TODO Auto-generated method stub
		return IntStream.range(0, arr.length).mapToObj(i -> i < n ? arr[arr.length - n +i] : arr[i-n] ).collect(Collectors.toList());
		 
	}

	private static List<Integer> rotateRightToLeft(int[] arr, int n) {
		// TODO Auto-generated method stub
		return IntStream.range(0, arr.length).mapToObj(i -> i < arr.length-n ? arr[n+i] : arr[i-arr.length+n] ).collect(Collectors.toList());
		 //123456 -> 345612  = 6-4-n   0, 1 i == 4, iof0, i===5 iof1 i -()
	}
}
