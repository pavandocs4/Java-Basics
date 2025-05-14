package com.example.java.basics.recursion;

import java.util.Scanner;

public class Fibonacci {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number to calculate nth term in fibonacci:");
		int n= sc.nextInt();
		int ans= fibonacci(n);
		System.out.println("nth term is:"+ ans);   //3
	}

	private static int fibonacci(int n) {
		// TODO Auto-generated method stub
		//0 1 1 2 3 5 8  f(n)+f(n-1)     
		if(n<=1) {
			return n;
		}
		return fibonacci(n-2)+fibonacci(n-1); // f(3)+f(2)  -> 
	}

}
