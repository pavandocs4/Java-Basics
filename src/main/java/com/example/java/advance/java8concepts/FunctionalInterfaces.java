package com.example.java.advance.java8concepts;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaces {
	public static void main(String[] args) {
		// Consumer
		Consumer<Integer> con = (a) -> System.out.println("Square: " + (a * a));
		Consumer<Integer> add = (a) -> System.out.println("add: " + (a + a));
		con.andThen(add).accept(2);
		
		
		//Supplier
		Supplier<Double> randomNo = () -> Math.random();
		Supplier<Double> randomNoOp = () -> Math.random()*2;
		System.out.println("Random no: "+randomNo.get());
		
		
		//Predicate
		Predicate<Integer> isOdd = (a) -> a%2 != 0;
		Predicate<Integer> isEven = (a) -> a%2 == 0;
		System.out.println(isOdd.and(isEven).test(5));
		
		//Function
		Function<Integer, Integer> sqaureFun= (a) -> a*a;
		Function<Integer, Integer> divFun= (a) -> a/a;
		System.out.println("Square of the no: "+sqaureFun.apply(5) );
		System.out.println("Combined Fun: "+sqaureFun.andThen(divFun).apply(5) );
		
		BiFunction<Integer, Integer, Integer> multiplication = (a,b) -> a*b;
		System.out.println("Bifunction operation: "+multiplication.apply(5,3) );
		
	
	}
}
