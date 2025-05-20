package com.example.java.basics.strings.level2;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AnagramStrings {
	public static void main(String[] args) {
		String str = "aba";
		String str1 = "ba";
		boolean isAnagram = checkAnagramString(str, str1);
		System.out.println(isAnagram);

	}

	private static boolean checkAnagramString(String str, String str1) {
		char[] str2= str.toCharArray(); 
		Map<Character, Long> map1 = str.chars().mapToObj(i -> (char) i).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	
		Map<Character, Long> map2 = str1.chars().mapToObj(i -> (char) i).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		return map1.entrySet().containsAll(map2.entrySet()) && map1.keySet().equals(map2.keySet());
		
	}

}
