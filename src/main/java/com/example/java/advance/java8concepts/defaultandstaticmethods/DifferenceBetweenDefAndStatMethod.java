package com.example.java.advance.java8concepts.defaultandstaticmethods;

public class DifferenceBetweenDefAndStatMethod {
	public static void main(String[] args) {
		TataPunch punch =new TataPunch();
		// Static Method in Interface: -> It is a method associated with class and not instance.
		//We cannot override the static method in classes implementing the interface. Still we can have same method signature in class without overriding
		Car.description();
		//default method: 
		punch.specifications();
	}
}
