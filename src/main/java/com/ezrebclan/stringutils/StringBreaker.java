package com.ezrebclan.stringutils;

public class StringBreaker {

	public static String[] breakWithSeperator(String original, String seperator) {
		char[] chars = original.toCharArray();
		char[] seperater = seperator.toCharArray();
		String[] retVal = new String[0];
		for (int i = 0; i < chars.length; i++) {
			
		}
	}
	private static boolean startsWith(char[] text, char[] pattern) {
		if(text.length < pattern.length) {
			return false;
		}
		int numberCorrect = 0;
		for(int i = 0; i < pattern.length; i++) {
			if(text[i] == pattern[i]) {
				numberCorrect++;
			} else {
				return false;
			}
		}
		if(numberCorrect == pattern.length) {
			return true;
		}
		return false;
	}
}
