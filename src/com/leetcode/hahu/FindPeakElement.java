package com.leetcode.hahu;

import com.leetcode.test.RandomGenerater;

public class FindPeakElement {
	public int findPeakElement(int[] num) {
        int result = -1;
        int length = num.length;
        
        if (length < 2) {
        	System.out.println("The array contains less than 2 elements");
        	if (length == 1) {
        		result = 0;
        	}
        	return result;
        }
        
        //check the first and last
        if (num[0] > num[1]) {
        	result = 0;
        } else if (num[length - 1] > num[length - 2]) {
        	result = length - 1;
        } else if ((length == 2) && (num[0] == num[1])) {
        	result = -1;
        } else {
        	//common cases
        	int current = num[0];
        	for (int i = 1;i < length - 1;i++) {
        		if ( (num[i - 1] < num[i]) && (num[i] > num[i + 1]) ) {
        			result = i;
        			break;
        		}
        	}
        }
        
        if (result == -1) {
        	System.out.println("No peak element");
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		int[] numbers = RandomGenerater.generateRandomIntArray(10, 100);
		
		FindPeakElement findPeakElement = new FindPeakElement();
		int result = findPeakElement.findPeakElement(numbers);
		System.out.println("Peak element's indes is: " + result);
	}
}
