package com.example.java.basics.strings.level1;

import java.util.stream.IntStream;

public class PalindromeString {
	public static void main(String[] args) {
		String str= "maadaam";
		boolean flag= checkPalindrome(str);
		System.out.println(!flag);
	}

	private static boolean checkPalindrome(String str) {
		char[] arr= str.toCharArray();
		//String str1= 
		return IntStream.range(0, arr.length)
				.anyMatch(i -> str.charAt(i)!=str.charAt(arr.length-1-i));
		//return false;
	}

}
