package com.example.java.basics.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class LongestNonRepeatableString {
	public static void main(String[] args) {
		String s = "pwwkewpcdfd";
		int l = lengthOfLongestSubstringNew(s);
		//int l1= lengthOfLongestSubstringByStreams(s);
		System.out.println(l);
	}

	private static int lengthOfLongestSubstringNew(String s) {
		// TODO Auto-generated method stub  //9:03
		String str="";
		int len=0;
		int newLen=0;
		String newStr="";
		for(int i=0; i<s.length(); i++) {
			if(!str.contains(String.valueOf(s.charAt(i)))) {
				str= str.concat(String.valueOf(s.charAt(i)));
				newLen= str.length();
			} else {
				newStr = str.length()>newStr.length() ? str : newStr;
				str = "";
				len = newLen>len ? newLen : len;
				str= str.concat(String.valueOf(s.charAt(i)));
			}
		}
		
		System.out.println(newStr);
		return len;
	}

	/*
	 * private static int lengthOfLongestSubstringByStreams(String s) { List<String>
	 * strList = new ArrayList<>(); s.chars().mapToObj(a-> (char) a).forEach(ch ->{
	 * String str= new String(); IntStream.range(s.indexOf(ch),
	 * s.length()).mapToObj(x -> s.charAt(x)).forEach(y-> {
	 * if(str.contains(y.toString())) { strList.add(str); //break; } else
	 * str=str.concat(String.valueOf(y)); }); }); return 0; }
	 */

	private static int lengthOfLongestSubstring(String s) {
		// TODO Auto-generated method stub
		List<String> strList = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) {
			String str = "";
			for (int j = i; j < s.length(); j++) {
				if (str.contains(String.valueOf(s.charAt(j)))) {
					strList.add(str);
					break;
				} else {
					str = str.concat(String.valueOf(s.charAt(j)));
					str = str.substring(i);
				}
			}
			
		}
		System.out.println(strList);
		Set<Integer> set = new HashSet<>();
		set.removeAll(set);
	
		return strList.stream().map(st -> st.length()).max((a, b) -> a-b).get(); 
	}
}