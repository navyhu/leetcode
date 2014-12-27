package com.leetcode.hahu;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author navyhu
 * @description Given an array of integers, find two numbers such that they add
 *              up to a specific target number.
 * 
 *              The function twoSum should return indices of the two numbers
 *              such that they add up to the target, where index1 must be less
 *              than index2. Please note that your returned answers (both index1
 *              and index2) are not zero-based.
 * 
 *              You may assume that each input would have exactly one solution.
 * 
 *              Input: numbers={2, 7, 11, 15}, target=9 Output: index1=1,
 *              index2=2
 */
public class TwoSum {
	public int[] twoSum(int[] numbers, int target) {
		int[] result = {-1, -1};
		int length = numbers.length;
        Map<Integer, Integer> numberMap = new HashMap<Integer, Integer>();
        
        //check the array
        if (length < 2) {
        	System.out.println("The array contains less than 2 elements");
        	return result;
        }
        
        for (int i = 0;i < length;i++) {
        	int subtractResult = target - numbers[i];
        	if (numberMap.containsKey(subtractResult)) {
        		result[0] = numberMap.get(subtractResult);
        		result[1] = i + 1;
        		System.out.println("result1 = " + result[0] + ", result2 = " + result[1]);
        		return result;
        	} else {
        		numberMap.put(numbers[i], i + 1);
        	}
        }
        
		System.out.println("no such numbers");
        
        return result;
    }
	
	public static void main(String[] args) {
		int[] numbers = {2, 7, 11, 15};
		int target = 9;
		
		TwoSum twoSum = new TwoSum();
		twoSum.twoSum(numbers, target);
	}
}
