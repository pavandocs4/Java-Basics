package com.example.java.basics.arrays.level2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicates {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,3,4,5,4,3,6,7};
		List<Integer> unique= removeDup(arr);
		System.out.println(unique);
	}

	private static List<Integer> removeDup(int[] arr) {
		return Arrays.stream(arr).boxed().collect(Collectors.toCollection(HashSet::new)).stream().collect(Collectors.toList());	
	}

}
