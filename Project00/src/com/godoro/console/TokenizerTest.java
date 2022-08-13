package com.godoro.console;

import java.util.StringTokenizer;

public class TokenizerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = 
				"*Java, *JDBC, JSP, JSON-P";
		for(String token : string.split(", ")) {
			System.out.println("*" + token);
			
		}
		StringTokenizer tokenizer = new StringTokenizer(string, " ,;*");
		while(tokenizer.hasMoreTokens()) {
			String token = tokenizer.nextToken();
			System.out.println("# " + token);
		}
	}

}
