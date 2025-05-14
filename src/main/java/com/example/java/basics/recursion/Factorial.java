package com.example.java.basics.recursion;

import java.util.Scanner;

public class Factorial {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number:");
		int num = sc.nextInt();
		int output = fact(num);
		System.out.println("factorial of " + num + " is:" + output);
	}

	private static int fact(int n) {
		// TODO Auto-generated method stub
		if (n <= 1) {
			return 1;
		}
		return n * fact(n - 1);
	}
}
