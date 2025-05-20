package com.example.java.basics.strings.level2;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatingChar {
	public static void main(String[] args) {
		String str="aabcdkabc";
		char val = nonReapeatingChar(str);
		System.out.println(val);
	}

	private static char nonReapeatingChar(String str) {
		// TODO Auto-generated method stub
		Map<Character, Long> map= str.chars().mapToObj(i -> (char) i).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		return str.chars().mapToObj(a-> (char) a).filter(b -> map.get(b)==1).findFirst().get();
	}

}
