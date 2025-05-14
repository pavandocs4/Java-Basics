package com.example.java.basics.recursion.advance;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/*
 Find the permutations of array. Ex- {1,2} -> {1,2} , {2,1}
*/
public class ArrayElementsPermutation {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of elements of array");
		int n = sc.nextInt();
		LinkedList<Integer> intList = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			intList.add(i + 1);
		}
		LinkedList<List<Integer>> ans = new LinkedList<>();
		LinkedList<Integer> arr = new LinkedList<>();
		printPermutations(intList, 0, ans, arr);
		System.out.println(ans);

	}

	private static void printPermutations(LinkedList<Integer> intList, int idx, LinkedList<List<Integer>> ans,
			LinkedList<Integer> arr) {
		// TODO Auto-generated method stub
		if (idx == intList.size()) {
			LinkedList<Integer> temp = new LinkedList<Integer>();
			temp.addAll(arr);
			ans.add(temp);
			// System.out.println(arr);
			return;
		}
		
		for(int i=idx; i< intList.size(); i++) {	
			swap(intList.get(idx), intList.get(i), arr);
			printPermutations(intList, i+1, ans, arr);
		}
		/*
		 * arr.add(i + 1); printPermutations(intList, i + 1, ans, arr);
		 * arr.removeLast(); printPermutations(intList, i + 1, ans, arr);
		 */
	}

	private static void swap(Integer integer, Integer integer2, LinkedList<Integer> arr) {
		// TODO Auto-generated method stub
		
	}



}
