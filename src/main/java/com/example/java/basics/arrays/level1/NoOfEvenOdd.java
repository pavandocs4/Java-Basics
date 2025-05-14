package com.example.java.basics.arrays.level1;

import java.util.stream.IntStream;

public class NoOfEvenOdd {
public static void main(String[] args) {
	int[] arr= {1,2,3,4,5,6,7};
	int even= findEvenNo(arr);
	int odd= findOddNo(arr);
	System.out.println("Total no of even no's:"+even+" and odd's are:"+odd);
}

private static int findOddNo(int[] arr) {
	int oddNo=(int) IntStream.range(0, arr.length).filter(i-> arr[i]%2 !=0).count();
	return oddNo;
}

private static int findEvenNo(int[] arr) {
	// TODO Auto-generated method stub
	int evenNo=(int) IntStream.range(0, arr.length).filter(i-> arr[i]%2 ==0).count();
	return evenNo;
}
}
