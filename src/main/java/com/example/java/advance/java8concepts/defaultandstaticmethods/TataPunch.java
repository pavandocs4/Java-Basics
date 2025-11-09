package com.example.java.advance.java8concepts.defaultandstaticmethods;

public class TataPunch implements Car, FourWheeler {

	void description() {
		System.out.println("This is not overriden method from interface");
	}

	@Override
	public void specifications() {
		// TODO Auto-generated method stub
		Car.super.specifications();
	}

}
