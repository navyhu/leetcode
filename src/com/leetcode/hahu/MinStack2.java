package com.leetcode.hahu;

import java.util.EmptyStackException;
import java.util.Stack;

public class MinStack2 {
	
	Stack<Integer> elements = new Stack<Integer>();
	Stack<Integer> minStack = new Stack<Integer>();
	
	public void push(int x) {
        elements.push(x);
        if (minStack.size() != 0) {
        	int min = minStack.peek();
        	if (x <= min) {
        		minStack.push(x);
        	}
        } else {
        	minStack.push(x);
        }
    }

    public void pop() {
    	try {
    		Integer pop = elements.pop();
    		if (pop.equals((minStack.peek()))) {
    			minStack.pop();
    		}
    	} catch (EmptyStackException e) {
    		System.out.println("Empty stack, no pop");
    	}
    }

    public int top() {
    	try {
    		//int top = elements.lastElement();
    		int top = elements.peek();
    		return top;
    	} catch (EmptyStackException e) {
    		System.out.println("Empty stack, no top");
    	}
    	return 0;
    }

    public int getMin() {
    	try {
    		//int min = minStack.lastElement();
    		int min = minStack.peek();
    		return min;
    	} catch (EmptyStackException e) {
    		System.out.println("Empty stack, no min");
    	}
    	return 0;
    }
    
    public static void main(String[] args) {
    	MinStack2 stack = new MinStack2();
    	
    	stack.push(0);
    	stack.push(1);
    	stack.push(0);
    	stack.getMin();
    	stack.pop();
    	stack.getMin();
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
