package com.leetcode.hahu;

import java.util.HashMap;
import java.util.Map;

import com.leetcode.datastruct.sort.InsertionSort;

/**
 * 
 * @author Administrator
 * @description Given an unsorted array, find the maximum difference between the
 *              successive elements in its sorted form.
 * 
 *              Try to solve it in linear time/space.
 * 
 *              Return 0 if the array contains less than 2 elements.
 * 
 *              You may assume all elements in the array are non-negative
 *              integers and fit in the 32-bit signed integer range.
 */

public class MaximumGap {
	public int maximumGap(int[] num) {
		int result = 0;
		int length = num.length;
		
		if (length < 2) {
			System.out.println("Contains less than 2 elements");
			return result;
		}
		
		//get max and min num
		int max = num[0], min = num[0];
		for (int i = 0;i < length;i++) {
			int cur = num[i];
			if (cur > max) {
				max = cur;
			}
			if (cur < min) {
				min = cur;
			}
		}
		
		//get average gap
		int avgGap = Math.max(1, (int)Math.ceil(((max - min) / (length - 1))));
		if (avgGap == 0) {
			return result;
		}
		
		//use bucket sort to solve
		int bucketLen = (max - min) / avgGap + 1;
		System.out.println("len: " + length + " max: " + max + " min: " + min + " avg: " + avgGap + " blen: " + bucketLen);
		HashMap<String, Integer>[] buckets = new HashMap[bucketLen];
		//put nums into the corresponding bucket
		for (int i = 0;i < length;i++) {
			int current = num[i];
			int location = (current - min) / avgGap;
			if (buckets[location] == null) {
				HashMap<String, Integer> bucket = new HashMap<String, Integer>();
				buckets[location] = bucket;
				bucket.put("max", current);
				bucket.put("min", current);
			} else {
				Map<String, Integer> bucket = buckets[location];
				bucket.put("max", Math.max(bucket.get("max"), current));
				bucket.put("min", Math.min(bucket.get("min"), current));
			}
		}
		
		//get the maximum gap
		int maxGap = 0;
		int index = 0;
		int bucketLength = buckets.length;
		while (index < bucketLength) {
			Map<String, Integer> current = buckets[index];
			if (current != null) {
				int index2 = index + 1;
				while (index2 < bucketLength) {
					Map<String, Integer> next = buckets[index2];
					if (next != null) {
						int gap = next.get("min") - current.get("max");
						maxGap = Math.max(maxGap, gap);
						break;
					}
					index2++;
				}
				index = index2 - 1;
			}
			index++;
		}
		
		System.out.println("Result is: " + maxGap);
		result = maxGap;
		
		return result;
	}
	
	public static void main(String[] args) {
		//int[] num = RandomGenerater.generateRandomIntArray(10, 50);
		//int[] num = {1,1,1,1,1,5,5,5,5,5};
		int [] num = {23909,19622,13107,10834,11667,28450,30959,7877,6015,4816,17362,3482,2247,230,16899,3818,4461,16494,31033,290,1918,15188,10109,30387,3570,14782,8496,11275,724,10139,20559,6597,6307,22655,14582,30492,7927,15790,10019,16550,15975,17015,27069,5951,11179,17091,16085,2882,5630,20461,21803,10240,21702,14292,1780,21354,6263,559,12762,22033,8885,22561,20549,8017,18873,2574,14297,6600,19189,10156,8512,9229,12539,24157,23849,415,20635,4540,23184,22556,8523};		
		
		MaximumGap gap = new MaximumGap();
		gap.maximumGap(num);
	}
}
