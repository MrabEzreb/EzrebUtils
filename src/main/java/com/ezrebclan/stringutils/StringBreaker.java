package com.ezrebclan.stringutils;

public class StringBreaker {

	public static String[] breakWithSeperator(String original, String seperator) {
		char[] chars = original.toCharArray();
		char[] currentChars = chars;
		char[] seperater = seperator.toCharArray();
		String[] retVal = new String[0];
		int lastSection = 0;
		int sepSkip = -1;
		for (int i = 0; i < chars.length; i++) {
			if(sepSkip == -1) {
				System.out.print("currentChars: \t ");
				for (char charac : currentChars) {
					System.out.print(charac);
				}
				System.out.println();
				if(startsWith(currentChars, seperater)) {
					String word = "";
					for(int i2 = lastSection; i2 < i-1; i2++) {
						word += chars[i2];
					}
					String[] retVal2 = new String[retVal.length + 1];
					System.arraycopy(retVal, 0, retVal2, 0, retVal.length);
					retVal2[retVal.length] = word;
					retVal = retVal2;
					sepSkip = seperater.length-1;
					System.out.println("sepSkip: \t "+sepSkip);
				} else if(i == (chars.length-1)) {
					String word = "";
					for(int i2 = lastSection; i2 <= i; i2++) {
						word += chars[i2];
					}
					String[] retVal2 = new String[retVal.length + 1];
					System.arraycopy(retVal, 0, retVal2, 0, retVal.length);
					retVal2[retVal.length] = word;
					retVal = retVal2;
				} else {
					currentChars = subchararray(chars, i, chars.length);
				}
			} else if(sepSkip == 0) {
				sepSkip--;
				lastSection = i-1;
				System.out.println("lastSection: \t "+lastSection);
				currentChars = subchararray(chars, lastSection, chars.length);
			} else {
				sepSkip--;
			}
		}
		return retVal;
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
		System.out.println("numberCorrect: \t "+numberCorrect);
		System.out.println("pattern.length: \t "+pattern.length);
		if(numberCorrect == pattern.length) {
			return true;
		}
		return false;
	}
	public static char[] subchararray(char[] charArray, int start, int end) {
		if(start > end) {
			int start2 = start;
			start = end;
			end = start2;
		}
		char[] retVal = new char[(end-start)];
		System.out.println("retVal.length: \t "+retVal.length);
		int progress = 0;
		for(int i = start; i < end; i++) {
			retVal[progress] = charArray[i];
			progress++;
		}
		return retVal;
	}
}
