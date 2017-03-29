package com.scinter.www.util;

import java.util.UUID;

public class StringUtil {

	public static final String getRandomString(int length) {
		if (length < 1) {
			return null;
		}
		char[] numbersAndLetters = ("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
		java.util.Random randGen = new java.util.Random();
		char[] randBuffer = new char[length];
		for (int i = 0; i < randBuffer.length; i++) {
			randBuffer[i] = numbersAndLetters[randGen.nextInt(61)];
		}
		return new String(randBuffer);
	}
	
	public static final String getUUIDStr() {		
		UUID uuid = UUID.randomUUID();
		String str = uuid.toString().replaceAll("-", "");
		return str;
	}
	
	public static void main(String[] args) {
		System.out.println( getUUIDStr() );
		System.out.println( getRandomString(10) );
	}
	
}
