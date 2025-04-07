package com.example.java.basics.recursion;

import java.util.Scanner;

public class SumUsingRecursion {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the nth term for which sum needs to calculated:");
		int n = sc.nextInt();
		int sum = sum(n);
		System.out.println("Sum till nth term is: " + sum);

	}

	private static int sum(int n) {
		// TODO Auto-generated method stub
		if (n <= 0) {
			return 0;
		}
		return n + sum(n - 1);
	}

}
