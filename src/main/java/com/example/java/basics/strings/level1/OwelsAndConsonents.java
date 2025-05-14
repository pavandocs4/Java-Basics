package com.example.java.basics.strings.level1;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OwelsAndConsonents {
	
	public static void main(String[] args) {
		String str= "Hi, My Name is Pavan";
		PrintOwelsAndConsonents(str);
	}

	private static void PrintOwelsAndConsonents(String str) {
		char[] arr= str.toCharArray();
		String owels= "aeiou";
		String ow=IntStream.range(0, arr.length).mapToObj(i -> str.charAt(i)).map(String::valueOf)
				.filter(ch-> owels.contains(ch)).collect(Collectors.joining());
		System.out.println(ow);
		String consonents = IntStream.range(0, arr.length).mapToObj(i -> str.charAt(i)).map(String::valueOf)
				.filter(ch-> !owels.contains(ch)).collect(Collectors.joining());
		System.out.println("*******************************************\n"+consonents);
	}

}
