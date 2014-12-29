package com.leetcode.datastruct.sort;

import com.leetcode.test.RandomGenerater;

public class InsertionSort<E extends Comparable<E>> {

	public E[] sort(E[] elements) {
		int length = elements.length;
		
		if (length < 2) {
			System.out.println("The array is already sorted");
			return elements;
		}
		
		for (int j = 1;j < length;j++) {
			E current = elements[j];
			int i = j - 1;
			while ((i >= 0) && (elements[i].compareTo(current) > 0)) {
				elements[i + 1] = elements[i];
				i--;
			}
			
			elements[i + 1] = current;
		}
		
		return elements;
	}
	
	public static void main(String[] args) {
		//Integer[] elements = {2, 5, 1, 67, 2, 9, 34, 20};
		Integer[] elements = RandomGenerater.generateRandomIntegerArray(20, 1000);
		
		InsertionSort<Integer> insertionSort = new InsertionSort<Integer>();
		elements = insertionSort.sort(elements);
		
		for (int i = 0;i < elements.length;i++) {
			System.out.print(elements[i] + " ");
		}
	}
}
