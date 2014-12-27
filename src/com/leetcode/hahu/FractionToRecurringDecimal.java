package com.leetcode.hahu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class FractionToRecurringDecimal {
	//corresponding result for a specific remainder
	class RemainderResult {
		long remainder;
		long result;
		public RemainderResult(long rem, long res) {
			remainder = rem;
			result = res;
		}
		public long getRemainder() {
			return remainder;
		}
		public long getResult() {
			return result;
		}
		public void setRemainder(long rem) {
			remainder = rem;
		}
		public void setResult(long res) {
			result = res;
		}
	}
	
    public String fractionToDecimal(int numeratorInt, int denominatorInt) {
        StringBuilder decimalString = new StringBuilder();
        long numerator = numeratorInt;
        long denominator = denominatorInt;

    	//make sure the denominator is not 0
    	if (denominator == 0) {
    		decimalString.append("Denominator is 0");
    		System.out.println(decimalString);
    		return decimalString.toString();
    	}
    	
    	//get the sign symbol: positive or negative
    	if (numerator*denominator < 0) {
    		decimalString.append('-');
    	}
    	
    	//get both absolute value
        System.out.println("numerator = " + numerator + " denominator = " + denominator);
    	numerator = Math.abs(numerator);
    	denominator = Math.abs(denominator);
        System.out.println("numerator = " + numerator + " denominator = " + denominator);

    	//divide the first time 
        long divisor = numerator/denominator;
        long remainder = numerator%denominator;
        System.out.println("divisor = " + divisor + " remainder = " + remainder);
        decimalString.append(divisor);
        
        //no fractional part
        if (remainder == 0) {
        	System.out.println("The result is: " + decimalString);
        	return decimalString.toString();
        }
        
        //ArrayList used to store the remainder and corresponding divisor result
        ArrayList<RemainderResult> remainderResults = new ArrayList<RemainderResult>();
        //Set used to store remainders already appeared
        Set<Long> remainderSet = new HashSet<Long>();
        
        while(remainder != 0) {
        	long numeratorNew = remainder*10;
        	long result = numeratorNew/denominator;
        	
        	//record the remainder and result pair
        	RemainderResult remainderResult = new RemainderResult(remainder, result);
        	remainderResults.add(remainderResult);
        	
        	//record the remainder in a Set
        	remainderSet.add(remainder);
        	
        	//get new remainder
        	remainder = numeratorNew%denominator;
        	
        	//check if the remainder has already appeared, if yes, then the result is repeated
        	if (remainderSet.contains(remainder)) {
        		decimalString.append(getRepeatResult(remainderResults, remainder));
                System.out.println("Result is: " + decimalString.toString());
        		return decimalString.toString();
        	}
        }
        
        //get the final result
        decimalString.append('.');
        //System.out.print("Result: " + divisor + ".");
        for (int i = 0;i < remainderResults.size();i++) {
        	decimalString.append(remainderResults.get(i).getResult());
        	//System.out.print(remainderResults.get(i).getResult());
        }
        System.out.println("Result is: " + decimalString.toString());
        
        return decimalString.toString();
    }
    
    private String getRepeatResult(ArrayList<RemainderResult> remainderResults, long repeatedRemainder) {
    	StringBuilder fractionalString = new StringBuilder();
    	boolean repeatFound = false;
    	
    	//get decimal point
    	fractionalString.append('.');
    	
    	//traverse the ArrayList to find out the position of the repeated remainder
    	for (int i = 0;i < remainderResults.size();i++) {
    		long result = remainderResults.get(i).getResult();
    		
    		//if the repeat position has been found
    		if (repeatFound) {
    			fractionalString.append(result);
    		} else {
	    		long remainder = remainderResults.get(i).getRemainder();
	    		if (remainder == repeatedRemainder) {
	    			//the result is repeated from here
	    			fractionalString.append('(');
	    			repeatFound = true;
	    		}
	    		fractionalString.append(result);
    		}
    	}
    	
    	fractionalString.append(')');
    	
    	return fractionalString.toString();
    }
    
    public static void main(String[] args) {
    	FractionToRecurringDecimal frac = new FractionToRecurringDecimal();
    	/*frac.fractionToDecimal(-2, 3);
    	frac.fractionToDecimal(0, 0);
    	frac.fractionToDecimal(3, 0);
    	frac.fractionToDecimal(-7, 12);*/
    	frac.fractionToDecimal(-1, -2147483648);
    }
}
