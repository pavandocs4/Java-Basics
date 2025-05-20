package com.example.java.basics.strings.level2;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharCountInString {
	public static void main(String[] args) {
		String str= "I am an Indian";
		String str1 = Arrays.stream(str.split(" ")).map(a-> (String) a).reduce("", (a,b) -> a.concat(b)).toLowerCase();
		System.out.println(str1);
		str1.chars().mapToObj(a -> (char) a).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
		.forEach((k, v) -> System.out.println(k+"-"+v));
		
	}

}
