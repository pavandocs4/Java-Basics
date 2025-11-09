package com.example.java.advance.java8concepts.defaultandstaticmethods;

public interface Car {
	
	public static void description() {
		System.out.println("This is a car interface");
	}

	default void specifications() {
		System.out.println("default method from interface");
	}
}
