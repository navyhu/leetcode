package com.leetcode.hahu;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MajorityElement {
	public int majorityElement(int[] num) {
		int result = 0;
		int length = num.length;
		
		//check the array
		if (length == 0) {
			System.out.println("Empty Array");
			return -1;
		}
		
		//Use a map to record each number count
		Map<Integer, Integer> numMap = new HashMap<Integer, Integer>();
		for (int i = 0;i < length;i++) {
			int key = num[i];
			Integer count = numMap.get(key);
			if (count != null) {
				count += 1;
			} else {
				count = 1;
			}
			numMap.put(key, count);
		}
		
		//get the number whose count is more than [n/2]
		int count = (int)Math.ceil(length/2);
		Set<Integer> keySet = numMap.keySet();
		Iterator<Integer> keyIt = keySet.iterator();
		while(keyIt.hasNext()) {
			Integer key = keyIt.next();
			int numCount = numMap.get(key);
			if (numCount > count) {
				System.out.println("The element is: " + key);
				return key.intValue();
			}
		}
		
		System.out.println("No such element");
		
        return result;
    }
	
	public static void main(String[] args) {
		int[] num = {2, 3, 5, 2, 1, 2, 5, 2, 2, 2, 2, 2, 2};
		MajorityElement majorityElement = new MajorityElement();
		majorityElement.majorityElement(num);
	}
}