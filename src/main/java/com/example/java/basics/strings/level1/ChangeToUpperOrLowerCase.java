package com.example.java.basics.strings.level1;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ChangeToUpperOrLowerCase {
	public static void main(String[] args) {
		String str= "Hello";
		String upper= toUpper(str);
		String lower=
				toLower(str);
		System.out.println("Uppr Case:"+upper);
		System.out.println("To Lower:"+lower);
	}

	private static String toLower(String str) {
		//97  65 = 32
		String low= IntStream.range(0, str.toCharArray().length).mapToObj(i -> str.charAt(i))
				.map(ch -> (ch >= 'a' && ch<='z') ? Character.toString(ch) : Character.toString(ch+32)).collect(Collectors.joining());
				
		str.chars().mapToObj(a-> a).forEach(System.out::println);
		str.chars().map(a-> a).forEach(System.out::println);
		IntStream.range(0, str.toCharArray().length).map(c -> str.charAt(c)).forEach(System.out::println);
		IntStream.range(0, str.toCharArray().length).mapToObj(c -> str.charAt(c)).forEach(System.out::println);/*
				str.chars().mapToObj(c -> (c >= 'a' && c <= 'z') ? c : c+32).map(val -> Character.toString(val))
		.collect(Collectors.joining());*/
		return low;
	}

	private static String toUpper(String str) {
		// TODO Auto-generated method stub
		return str.chars().mapToObj(c -> (c >= 'A' && c <= 'Z') ? c : c-32).map(val -> Character.toString(val))
				.collect(Collectors.joining());
	}
	
	

}
