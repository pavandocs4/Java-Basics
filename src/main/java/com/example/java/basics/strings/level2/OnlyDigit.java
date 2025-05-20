package com.example.java.basics.strings.level2;

public class OnlyDigit {

	public static void main(String[] args) {
		String str = "12345";
		boolean flag = isOnlyDigit(str);
		System.out.println(flag);
	}

	private static boolean isOnlyDigit(String str) {
		// TODO Auto-generated method stub
		return str.chars().map(a -> (char) a).allMatch(a -> a>='0' && a<='9');
	}
}
