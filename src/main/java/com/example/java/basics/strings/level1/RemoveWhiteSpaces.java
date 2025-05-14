package com.example.java.basics.strings.level1;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RemoveWhiteSpaces {
	public static void main(String[] args) {
		String str = "I love you India so much";
		String noWhiteSpace = removeWhiteSpaces(str);
		System.out.println(noWhiteSpace);
	}

	private static String removeWhiteSpaces(String str) {
		String str1=IntStream.range(0, str.toCharArray().length).mapToObj(i -> str.charAt(i))
		.map(String::valueOf).filter(val -> !val.contains(" ")).collect(Collectors.joining());
		return str1;
	}

}
