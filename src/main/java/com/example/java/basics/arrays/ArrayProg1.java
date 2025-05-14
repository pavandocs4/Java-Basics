package com.example.java.basics.arrays;

/*You are given an array nums consisting of positive integers.

We call a subarray of an array complete if the following condition is satisfied:

The number of distinct elements in the subarray is equal to the number of distinct elements in the whole array.
Return the number of complete subarrays.

A subarray is a contiguous non-empty part of an array.

 

Example 1:

Input: nums = [1,3,1,2,2]
Output: 4
Explanation: The complete subarrays are the following: [1,3,1,2], [1,3,1,2,2], [3,1,2] and [3,1,2,2].*/

/*For nums = [1, 3, 1, 2, 2] and k = 3:
Initialize left = 0, res = 0, mpp = {}
Iterate i from 0 to 4:
i = 0: add 1 → mpp = {1:1} (size 1) → no full window
i = 1: add 3 → mpp = {1:1, 3:1} (size 2) → no full window
i = 2: add 1 → mpp = {1:2, 3:1} (size 2) → no full window
i = 3: add 2 → mpp = {1:2, 3:1, 2:1} (size 3 == k)
while size == k:
res += 5 - 3 = 2 → res = 2
remove nums[left] = 1 → mpp = {1:1, 3:1, 2:1}, left = 1
still full →
res += 2 → res = 4
remove nums[left]=3 → mpp = {1:1, 2:1}, left = 2
i = 4: add 2 → mpp = {1:1, 2:2} (size 2) → no full window
Return res = 4*/

import java.util.*;

public class ArrayProg1 {

	public static void main(String args[]) {
		int[] arr = { 5, 5, 5, 5, 2, 1, 1, 1 };
		int val = countSubArrays(arr);
		System.out.println(val);

		FindSubArrays subArrayFinder = new FindSubArrays();

		long val1 = anotherApproach(subArrayFinder, arr);
		System.out.println("*************************************\n" + val);
	}

	private static long anotherApproach(FindSubArrays subArrayFinder, int[] arr) {

		long k = Arrays.stream(arr).distinct().count();
		System.out.println("distinct elements:" + k);
		List<List<Integer>> subArr = subArrayFinder.findSubArrays(arr); // FindSubArrays is a class which find out the subarrays
		long count= subArr.stream().flatMap(val -> val.stream().distinct()).filter(dist -> dist == k).count();
		return count;
	}

	private static int countSubArrays(int[] nums) {
		// TODO Auto-generated method stub
		long k = Arrays.stream(nums).distinct().count();
		System.out.println("distinct elements:" + k);
		List<Map> op = Arrays.asList();
		Map<Integer, Integer> mpp = new HashMap<>();

		int left = 0, res = 0;

		for (int i = 0; i < nums.length; i++) {
			mpp.put(nums[i], mpp.getOrDefault(nums[i], 0) + 1);
			while (mpp.size() == k) {
				res += nums.length - i;
				mpp.put(nums[left], mpp.get(nums[left]) - 1);
				if (mpp.get(nums[left]) == 0)
					mpp.remove(nums[left]);
				left++;
			}
		}
		return res;
	}

}
