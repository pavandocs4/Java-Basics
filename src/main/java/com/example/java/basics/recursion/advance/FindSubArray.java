package com.example.java.basics.recursion.advance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FindSubArray {
	public static void main(String[] args) {
		int[] arr= {1, 2, 3, 4};
		LinkedList<Integer> op = new LinkedList<>();
		int idx =0;
		LinkedList<List<Integer>> subArr = new LinkedList<>();
		subArr = getSubArr(arr,op, idx, subArr); 
		System.out.println(subArr);
	}

	private static LinkedList<List<Integer>> getSubArr(int[] arr, LinkedList<Integer> op, int idx, LinkedList<List<Integer>> subArr) {
		// TODO Auto-generated method stub
		
		

		if(arr.length == idx) {
			return subArr;
		}
		
		op.add(arr[idx]);  //{1}
		LinkedList<Integer> newArr= new LinkedList<>();
		newArr.addAll(op); 
		subArr.add(newArr);
		getSubArr(arr, op, idx+1, subArr);   //
		op.removeLast();
		getSubArr(arr, op, idx+1, subArr);
		return subArr;
	}

}
