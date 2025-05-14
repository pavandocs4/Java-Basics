package com.example.java.basics.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class FindSubArrays {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		List<List<Integer>> subArr= findSubArrays(arr); 
		System.out.println(subArr);
		
	}

	public static List<List<Integer>> findSubArrays(int[] arr) {
		// TODO Auto-generated method stub
		
		List<List<Integer>> op = new ArrayList<>(); 
		for(int i=0; i< arr.length-1;i++) {
			List<Integer> nums =new ArrayList<>();
			for(int j=i; j< arr.length; j++) {
				 nums.add(arr[j]);
				 List<Integer> numsToAdd = new ArrayList<>(); 
				 numsToAdd.addAll(nums);
				 op.add(numsToAdd);
			}
		}
		return op;
	}
}
