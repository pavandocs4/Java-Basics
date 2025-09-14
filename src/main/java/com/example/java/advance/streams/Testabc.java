package com.example.java.advance.streams;

public class Testabc {
	public static void main(String[] args) {
		B b =new B();
		b.printName();
		b.printName();

	}
}
interface A{
	default void printName() {
		System.out.println("Hi");
	}
	
	static void printAge() {
		System.out.println("20");
	}
}

class B implements A{
	
}
