package com.example.java.basics.strings.level2;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AnagramStrings {
	public static void main(String[] args) {
		String str = "aba";
		String str1 = "abaa";
		boolean isAnagram = checkAnagramString(str, str1);
		System.out.println(isAnagram);

	}

	private static boolean checkAnagramStringNew(String str, String str1) {
		// abbc bcba
		Map<Character, Long> map1 = str.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		Map<Character, Long> map2 = str1.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		
		List<Character> list1= str.chars().mapToObj(c ->(char) c).sorted().toList();
		List<Character> list2 = str1.chars().mapToObj(d -> (char) d).sorted().toList();
		return list1.equals(list2);
		
		
	}

	private static boolean checkAnagramString(String str, String str1) {
		char[] str2= str.toCharArray(); 
		Map<Character, Long> map1 = str.chars().mapToObj(i -> (char) i).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	
		Map<Character, Long> map2 = str1.chars().mapToObj(i -> (char) i).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		return map1.entrySet().containsAll(map2.entrySet()) && map1.keySet().containsAll(map2.keySet());
		
	}

}
