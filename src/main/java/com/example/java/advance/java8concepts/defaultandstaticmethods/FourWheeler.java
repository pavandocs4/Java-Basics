package com.example.java.advance.java8concepts.defaultandstaticmethods;

public interface FourWheeler {
	default void specifications() {
		System.out.println("This is another interface FourWheeler");
	}

	public static void description() {
		System.out.println("This is a FourWheeler interface");
	}

}
