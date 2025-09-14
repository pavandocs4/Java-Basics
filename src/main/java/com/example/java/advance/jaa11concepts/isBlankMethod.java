package com.example.java.advance.jaa11concepts;


// This method is introduced to check the blank string or white spaces in string

public class isBlankMethod {
	public static void main(String[] args) {
		String str1 = null;
		String str2 ="";
		String str3 = "    ";
		//System.out.println("str1->"+str1.isBlank()); null pointer exception
		System.out.println("str2->"+str2.isBlank());
		System.out.println("str3->"+str3.isBlank());
	}
}
