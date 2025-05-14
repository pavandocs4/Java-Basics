package com.example.java.basics.strings.level1;

import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class StringReversal {
	public static void main(String[] args) {
		String str1= "Hi this is Java";
		char[] str2= reverseString(str1);
		
		String str3= new String(str2);
		System.out.println(str3);
		
		String str4= reverseStringByStreams(str1);
		System.out.println("*******************************************\n"+str4);
		
		String str5= reverseUsingBuilder(str1);
		
		System.out.println("*******************************************\n"+str5);
		
		
		
	}

	private static String reverseStringByStreams(String str1) {
		char[] arr= str1.toCharArray();
		String rev= IntStream.range(0, arr.length).mapToObj(i -> str1.charAt(arr.length-1-i)).map(ch-> String.valueOf(ch))
				.collect(Collectors.joining());
		return rev;
	}

	private static char[] reverseString(String str1) {
		char[] arr= str1.toCharArray();
		char[] rev= new char[arr.length];
		int count=0;
		for(int i=arr.length-1; i>=0; i--) {
			rev[count]= arr[i]; 
			count++;
		}
		return rev;
	}
	
	private static String reverseUsingBuilder(String str) {
		return new StringBuilder(str).reverse().toString();
	}

}
