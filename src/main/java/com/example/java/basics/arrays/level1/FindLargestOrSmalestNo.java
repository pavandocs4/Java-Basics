package com.example.java.basics.arrays.level1;

import java.util.Arrays;

/*Find the largest/smallest element in an array*/

public class FindLargestOrSmalestNo {
	public static void main(String[] args) {
		int[] arr = {6,1,2,3,4,5,35,9, 0};
		int num= findLargest(arr);
		int numByStream= findLargestByStreams(arr);
		System.out.println("Largest no="+num);
		System.out.println("Largest no by streams API="+numByStream);
		int small= findSmallest(arr);
		System.out.println("small no="+small);
		int smallByStream= findSmallestByStreams(arr);
		System.out.println("Smallest no by streams API="+smallByStream);
	}

	private static int findSmallestByStreams(int[] arr) {
		// TODO Auto-generated method stub
		return Arrays.stream(arr).min().getAsInt();
	}

	private static int findLargestByStreams(int[] arr) {
		// TODO Auto-generated method stub
		return Arrays.stream(arr).max().getAsInt();
	}

	private static int findSmallest(int[] arr) {
		// TODO Auto-generated method stub
		int num=0;
		int temp=arr[0];
		for(int i=0; i< arr.length; i++) {
			num=arr[i];
			if(temp>num) {
				temp=num;
			}
		}
		return temp;
	}

	private static int findLargest(int[] arr) {
		// TODO Auto-generated method stub
		int num=0;
		int temp=0;
		for(int i=0; i< arr.length; i++) {
			num=arr[i];
			if(temp<num) {
				temp=num;
			}
		}
		return temp;
	}

}
