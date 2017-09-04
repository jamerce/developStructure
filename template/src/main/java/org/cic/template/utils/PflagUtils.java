package org.cic.template.utils;

import java.security.SecureRandom;

import org.apache.commons.lang.StringUtils;

public class PflagUtils {
	

	
	public static int getRandom(int max){
        return (int) (Math.random()*max);
    }
   
	/**
	 * 
	 * @param num
	 * @return
	 */
	public static String getRandomNumber(int num){
		
		long begNum = Long.parseLong(StringUtils.rightPad(String.valueOf(1), num, "0"));
		long endNum = Long.parseLong(StringUtils.rightPad(String.valueOf(9), num, "9"));
		return String.valueOf(getRandomLong(begNum, endNum));
	}
   
    /*
     * returns random integer between minimum and maximum range
     */
    public static int getRandomInteger(int maximum, int minimum){
    	SecureRandom secureRandom = new SecureRandom(); 
        return ((int) (secureRandom.nextDouble()*(maximum - minimum))) + minimum;
    }
	
    /**
     * 
     * @param maximum
     * @param minimum
     * @return
     */
    public static long getRandomLong(long maximum, long minimum){
    	SecureRandom secureRandom = new SecureRandom(); 
    	
        return ((long) (secureRandom.nextDouble()*(maximum - minimum))) + minimum;
    }
}
