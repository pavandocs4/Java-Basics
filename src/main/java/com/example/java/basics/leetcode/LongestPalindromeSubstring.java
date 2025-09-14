package com.example.java.basics.leetcode;

import org.springframework.util.StringUtils;

public class LongestPalindromeSubstring {
	public static void main(String args[]) {
		String str = "abadccda";
		String pal = palindromeSubStringNew(str);
		System.out.println(pal);

	}

	private static String palindromeSubStringNew(String s) {
		// TODO Auto-generated method stub
		if (s == null || s.length() < 1)
			return "";

		int start = 0, end = 0;


		for (int i = 0; i < s.length(); i++) {
			int len1 = expandFromCenter(s, i, i); // Odd length palindrome
			int len2 = expandFromCenter(s, i, i + 1); // Even length palindrome
			int len = Math.max(len1, len2);

			if (len > end - start) {
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
		}

		return s.substring(start, end + 1);
	}

	private static int expandFromCenter(String s, int left, int right) {
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--; 
			right++; 
		}
		return right - left - 1;
	}

	@SuppressWarnings("deprecation")
	private static String palindromeSubString(String str) {
		// TODO Auto-generated method stub
		if (StringUtils.isEmpty(str))
			return "";

		String pal = "";
		String longPal = String.valueOf(str.charAt(0));
		for (int i = 0; i < str.length(); i++) {
			// s = s.concat(String.valueOf(str.charAt(i)));
			pal = getPal(str,i + 1);
			// longPal = pal.length()>longPal.length() ? pal : longPal;
			if (pal.length() > longPal.length()) {
				longPal = pal;
				// s="";
			}

		}

		return longPal;
	}

	private static String getPal(String s, int i) { // ccc
		// TODO Auto-generated method stub
		if (s.length() == 1)
			return s;
		int start = (i / 2) - 1; // 0 1
		int end = 0;
		int flag = i % 2 == 0 ? 1 : 2;
		end = i % 2 == 0 ? i / 2 : i / 2 + 1;
		while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
			start--;
			end++;
		}
		return end - start == flag ? "" : s.substring(start + 1, end); // 0 1
	}

}
