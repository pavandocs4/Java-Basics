package com.example.java.advance.java8concepts;

import java.util.Scanner;

public class LambdaWithFunctionalInt {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("*******************Wecome to Calculator*********************"
				+ "\n\n Enter the number for below operation choice \n 1. Addition \n 2. Substraction"
				+ "\n 3. Multiplication \n 4. Division");
		int choice = sc.nextInt();
		System.out.println("\n Enter the values of a and b: \n");
		int a = sc.nextInt();
		int b = sc.nextInt();
		int ans = 0;

		// Implementation of the abstract method in Functional interface using lambda
		// expression

		Operation add = (x, y) -> x + y;
		Operation sub = (x, y) -> x - y;
		Operation mul = (x, y) -> x * y;
		Operation div = (x, y) -> x / y;

		switch (choice) {
		case 1:
			System.out.println(add.calculate(a, b)); 
			break;
		case 2:
			System.out.println(sub.calculate(a, b));
			break;
		case 3:
			System.out.println(mul.calculate(a, b));
			break;
		case 4:
			System.out.println(div.calculate(a, b));
			break;
		default:
			System.out.println("Enter the correct choice");

		}
	}
}

interface Operation {
	int calculate(int a, int b);
}
