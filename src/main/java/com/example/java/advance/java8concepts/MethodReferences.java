package com.example.java.advance.java8concepts;

import java.util.Arrays;
import java.util.List;

public class MethodReferences {
	public static void main(String[] args) {
		// 1. calling a static method
		System.out.println("calling a static method with method ref");
		List<String> stdNames= Arrays.asList("Rahul", "Fatima", "Ravi", "Suresh");
		stdNames.stream().forEach(Student::printName);
		
		//Instance method of an object
		System.out.println("Instance method of an object with method ref");
		Student std= new Student();
		stdNames.stream().forEach(std::printNameToLowerCase);
	}

}

class Student {
	
	public void printNameToLowerCase(String name) {
		System.out.println(name.toLowerCase());
	}
	
	public static void printName(String name) {
		System.out.println(name);
	}
	
}
