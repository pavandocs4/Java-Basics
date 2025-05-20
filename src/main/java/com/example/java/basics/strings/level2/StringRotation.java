package com.example.java.basics.strings.level2;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringRotation {
	public static void main(String[] args) {
		String str= "abcd";
		String str1 = "cadb";
		boolean flag =isRotation(str, str1);
		System.out.println(flag);
	}

	private static boolean isRotation(String str, String str1) {
		// TODO Auto-generated method stub
		boolean f= false;
		if(str.length()!= str1.length())
			return false;
		int n = str.chars().mapToObj(a -> (char) a).map(x -> str1.contains(x.toString()) ? str1.indexOf(x) : 0 ).findFirst().get();
		//int n = str.length()-val;
		//System.out.println(n);
		String str2 =IntStream.range(0, str.length())
				.mapToObj(i -> str.length()-n+i < str.length() ? str.charAt(str.length()-n+i) : str.charAt(i-n))
				.map( j-> j.toString())
				.collect(Collectors.joining());
				//.reduce("", (a,b) -> );
		
		return str1.equals(str2);
		// cdefgab   abcdefg
		// 0123456   5601234  n=2 len=7 i= 0
		//           7-n+i                 0  
		//            6= 7-2+i             1
		//            0 =i-n               2
		//            1 =i-n                  3 
	}
}
