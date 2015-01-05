package com.leetcode.hahu;

import java.util.HashMap;
import java.util.Map;

public class LongestNoRepeatSubStr {
	public int lengthOfLongestSubstring(String s) {
        int result = 0;
        
        if (s == null || s.length() == 0) {
        	return 0;
        }
        
        int length = s.length();
        int tempLen = 0;
        //map used to stored each character and it's corresponding length(non-repeated)
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0;i < length;i++) {
        	char curChar = s.charAt(i);
        	if (map.containsKey(curChar)) {
				int lastIndex = map.get(curChar);
				if (lastIndex >= i - tempLen) {
					if (tempLen > result) {
						result = tempLen;
					}
					tempLen = i - lastIndex;
	        		//System.out.println(curChar + ", The last index: " + lastIndex + " current: " + i);
        		} else {
        			tempLen++;
        		}
        	} else {
        		//System.out.println(curChar + ", current: " + i);
				tempLen++;
			}
        	map.put(curChar, i);
        }
        
        if (tempLen > result) {
        	System.out.println("Templen: " + tempLen);
        	result = tempLen;
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		String s = "wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco";
		LongestNoRepeatSubStr test = new LongestNoRepeatSubStr();
		int result = test.lengthOfLongestSubstring(s);
		System.out.println("The result is: " + result);
		
		s = "abcadesskeskjf";
		result = test.lengthOfLongestSubstring(s);
		System.out.println("The result is: " + result);//

	}
}
