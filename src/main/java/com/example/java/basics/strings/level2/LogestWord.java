package com.example.java.basics.strings.level2;

import java.util.Arrays;

//Find the longest word in a sentence

public class LogestWord {
	public static void main(String[] args) {
		String str= "I am an Indian";
		String longest= longestWord(str);
		System.out.println(longest);
	}

	private static String longestWord(String str) {
		// TODO Auto-generated method stub
		return Arrays.stream(str.split(" ")).reduce("", (a, b) -> isGreater(a,b) ? b: a);
	}

	private static boolean isGreater(String a, String b) {
		// TODO Auto-generated method stub
		System.out.println("This is method called from streams");
		return b.length()>a.length();
	}
}
