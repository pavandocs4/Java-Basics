package com.example.java.basics.arrays.level2;

import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SecondLargestNo {
	
	public static void main(String[] args) {
		int[] arr = {2,5,6,9,0,1};
		int[] sortedArr =
				sortArray(arr);
	int val=IntStream.range(0, sortedArr.length).filter(i -> i==(sortedArr.length-1)).map(j-> arr[j]).reduce(0, (a, b)-> b);
	int val1 = findSecondLargest(arr);
	System.out.println(val1);
	}

	private static int[] sortArray(int[] arr) {
		// TODO Auto-generated method stub
		return IntStream.range(0, arr.length).map(i -> arr[i]).boxed().collect(Collectors.toCollection(TreeSet::new))
		.stream().mapToInt(val -> val).toArray();
		
	}
	
	private static int findSecondLargest(int[] arr) {
		// TODO Auto-generated method stub
		return IntStream.range(0, arr.length).map(i -> arr[i]).distinct().boxed().sorted((a, b) -> b-a).skip(1).findFirst().orElse(null);
		
	}

}
