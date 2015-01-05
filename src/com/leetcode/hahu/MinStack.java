package com.leetcode.hahu;

public class MinStack {
	
	class HahuList {
		public int value;
		public HahuList next;
		public HahuList(int x) {
			value = x;
		}
		public int getValue() {
			return value;
		}
	}
	
	HahuList elements;
	HahuList minStack;
	int size = 0;
	int minSize = 0;
	
	public void push(int x) {
		HahuList element = new HahuList(x);
        if (elements != null) {
        	element.next = elements;
        }
        elements = element;
        size++;
        if (minStack != null) {
        	int currentMin = minStack.getValue();
        	if (x <= currentMin) {
        		HahuList min = new HahuList(x);
        		min.next = minStack;
        		minStack = min;
        		minSize++;
        	}
        } else {
        	HahuList min = new HahuList(x);
    		minStack = min;
    		minSize++;
        }
    }

    public void pop() {
    	if (size > 0) {
    		int removed = elements.getValue();
    		int currentMin = minStack.getValue();
    		if ((removed == currentMin) && (minStack != null)) {
    			minStack = minStack.next;
    			minSize--;
    		}
			elements = elements.next;
			size--;
    	}
    }

    public int top() {
    	int top = 0;
    	if (size > 0) {
    		top = elements.getValue();
    		System.out.println("Top: " + top);
    	}
    	return top;
    }

    public int getMin() {
    	int min = 0;
    	if (minStack != null) {
    		min = minStack.getValue();
    		System.out.println("Min: " + min);
    	}
        return min;
    }
    
    public static void main(String[] args) {
    	MinStack stack = new MinStack();
    	
    	stack.push(2);
    	stack.push(5);
    	stack.push(2);
    	stack.push(2);
    	stack.getMin();
    	stack.push(5);
    	stack.push(5);
    	stack.push(2);
    	stack.push(5);
    	stack.push(2);
    	stack.push(5);
    	stack.push(2);
    	stack.push(5);
    	stack.top();
    	stack.push(2);
    	stack.push(5);
    	stack.push(2);
    	stack.push(5);
    	stack.push(2);
    	stack.push(5);
    	stack.pop();
    }
}
