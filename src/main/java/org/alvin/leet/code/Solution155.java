package org.alvin.leet.code;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class Solution155 {
    class MinStack {

        Deque<Integer> stack ;
        Deque<Integer> minStack;

        public MinStack() {
            stack = new LinkedList<>();
            minStack = new LinkedList<>();
        }

        public void push(int val) {
           stack.push(val);
           minStack.push(Math.min(minStack.peekFirst(), val));
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
           return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
