package com.example.java.basics.recursion.advance;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/*
Que:- Arrange the elements of array such that all the possible combinations of the elements got covered
Ex- if arr[2]={1,2} ->  {},{1},{2},{1,2} Sp total 2 power n combinations must printed
*/
public class ArrayElementsPattern {
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
		printCombinations(intList, 0, ans, arr);
		System.out.println(ans);

	}

	private static void printCombinations(LinkedList<Integer> intList, int i, LinkedList<List<Integer>> ans,
			LinkedList<Integer> arr) {
		// TODO Auto-generated method stub
		if (i == intList.size()) {
			LinkedList<Integer> temp = new LinkedList<Integer>();
			temp.addAll(arr);
			ans.add(temp);
			// System.out.println(arr);
			return;
		}
		arr.add(i + 1);
		printCombinations(intList, i + 1, ans, arr);
		arr.removeLast();
		printCombinations(intList, i + 1, ans, arr);
	}

}
