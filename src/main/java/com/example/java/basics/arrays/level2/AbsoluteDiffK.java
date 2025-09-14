package com.example.java.basics.arrays.level2;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.IntStream;

public class AbsoluteDiffK {
	public static void main(String[] args) {
		int[] arr = {1, 3, 2, 5, 4, 7};
		int k=2;
		//int diff= findAbsDiff(arr, k);
		
		long diff= findAbsDiffByStreams(arr, k);
		System.out.println(diff);
	}

	private static long findAbsDiffByStreams(int[] arr, int k) {
		// TODO Auto-generated method stub
		Optional<Long> val = IntStream.range(0, arr.length-1).mapToObj(key -> 
					 IntStream.range(key+1 , arr.length).map(j-> arr[j])
					 .filter(a-> a-arr[key] == k || arr[key]-a == k).count()
				).reduce((a,b)-> a+b);
		return val.get();
	}

	private static int findAbsDiff(int[] arr, int k) {
		int count =0;
		for(int i=0; i< arr.length-1; i++) {
			for(int j=i+1; j<arr.length;j++) {
				if(arr[i]-arr[j] == k || arr[j] - arr[i] == k) {
					count++;
				}
			}
		}
		return count;
	}
}
