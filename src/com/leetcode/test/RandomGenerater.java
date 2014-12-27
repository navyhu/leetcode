package com.leetcode.test;

import java.util.ArrayList;
import java.util.Random;

public class RandomGenerater {
	public static Integer[] generateRaondomIntArray(int n, int upper) {
		//ArrayList<Integer> intArray = new ArrayList<Integer>();
		Integer[] intArray = new Integer[n];
		Random random = new Random();
		
		for (int i = 0;i < n;i++) {
			Integer randInt = random.nextInt(upper);
			intArray[i] = randInt;
			System.out.print(randInt + " ");
		}
		System.out.println("");

		return intArray;
	}
}
