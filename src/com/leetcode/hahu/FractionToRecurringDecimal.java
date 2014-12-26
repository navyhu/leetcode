package com.leetcode.hahu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class FractionToRecurringDecimal {
	//corresponding result for a specific remainder
	class RemainderResult {
		int remainder;
		int result;
		public RemainderResult(int rem, int res) {
			remainder = rem;
			result = res;
		}
		public int getRemainder() {
			return remainder;
		}
		public int getResult() {
			return result;
		}
		public void setRemainder(int rem) {
			remainder = rem;
		}
		public void setResult(int res) {
			result = res;
		}
	}
	
    public String fractionToDecimal(int numerator, int denominator) {
        String decimalString = null;

        int divisor = numerator/denominator;
        int remainder = numerator%denominator;
        System.out.println("divisor = " + divisor + " remainder = " + remainder);
        
        //ArrayList used to store the remainder and corresponding result
        ArrayList<RemainderResult> remainderResults = new ArrayList<RemainderResult>();
        Set<Integer> remainderSet = new HashSet<Integer>();
        
        while(remainder != 0) {
        	int numeratorNew = remainder*10;
        	int result = numeratorNew/denominator;
        	
        	//record the remainder and result pair
        	RemainderResult remainderResult = new RemainderResult(remainder, result);
        	remainderResults.add(remainderResult);
        	
        	//record the remainder in a Set
        	remainderSet.add(remainder);
        	
        	//get new remainder
        	remainder = numeratorNew%denominator;
        	
        	//check if the remainder has already appeared, if yes, then the result is repeated
        	if (remainderSet.contains(remainder)) {
        		
        	}
        }
        
        //get the final result
        System.out.print("Result: " + divisor + ".");
        for (int i = 0;i < remainderResults.size();i++) {
        	System.out.print(remainderResults.get(i).getResult());
        }
        
        return decimalString;
    }
    
    public static void main(String[] args) {
    	FractionToRecurringDecimal frac = new FractionToRecurringDecimal();
    	frac.fractionToDecimal(35, 8);
    }
}
