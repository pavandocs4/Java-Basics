package com.example.java.basics.strings.level1;

import java.util.stream.IntStream;

/*
  *
 ***
*****
 ***
  **/

public class PrintStarPattern {
	public static void main(String[] args) {
		int n = 9;
		printStarPattern(n);
	}

	private static void printStarPattern(int n) {
		int count = 0;
		int count1 = n / 2 + 1;
		int prevCount = 0;
		for (int i = 0; i < n; i++) {
			if (i <= n / 2) {
				count++;
				count1--;
				for (int j = count1; j > 0; j--) {
					System.out.print(" ");
				}
				for (int k = i + count; k > 0; k--) {
					System.out.print("*");
				}
				prevCount = i + count;
			} else {
				// System.out.println("count:"+count+" count1:"+count1);
				count1++;
				prevCount = prevCount - 2;
				for (int j = 1; j <= count1; j++) {
					System.out.print(" ");
				}
				for (int k = prevCount; k > 0; k--) {
					System.out.print("*");
				}

			}
			System.out.println();
		}

	}

}
