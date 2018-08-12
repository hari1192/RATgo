package com.ot.tgo.base;

import java.util.Random;

public class generateRandom {
	
	public generateRandom() {
		
	}
	public static final String CHAR_LIST = 
	        "1234567890";
	public static final int RANDOM_STRING_LENGTH =5;
	public static void main(String[] args) {
		String randString=generateRandomString();
		System.out.println("random generated string is"+randString);
	}

	
	public static String generateRandomString(){
        
        StringBuffer randStr = new StringBuffer("HCTEST");
        for(int i=0; i<RANDOM_STRING_LENGTH; i++){
            int number = getRandomNumber();
            char ch = CHAR_LIST.charAt(number);
            randStr.append(ch);
        }
        return randStr.toString();
    }
	 public static int getRandomNumber() {
	        int randomInt = 0;
	        Random randomGenerator = new Random();
	        randomInt = randomGenerator.nextInt(CHAR_LIST.length());
	        if (randomInt - 1 == -1) {
	            return randomInt;
	        } else {
	            return randomInt - 1;
	        }
	    }
}
