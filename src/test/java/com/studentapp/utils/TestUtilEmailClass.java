package com.studentapp.utils;

import java.util.Random;

public class TestUtilEmailClass {
	
	public static String getRandomValue(){
		Random random = new Random();
		int randomInt = random.nextInt(10000);
		return Integer.toString(randomInt);
	}

}
