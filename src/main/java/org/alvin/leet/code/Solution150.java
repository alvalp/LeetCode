package org.alvin.leet.code;

import java.util.Deque;
import java.util.LinkedList;

public class Solution150 {
    public int evalRPN(String[] tokens) {
        Deque<Integer> deque = new LinkedList<>();
        for (String s : tokens) {
            if ("+".equals(s)) {
                deque.push(deque.pop() + deque.pop());
            } else if ("-".equals(s)) {
                deque.push(-deque.pop() + deque.pop());
            } else if ("*".equals(s)) {
                deque.push(deque.pop() * deque.pop());
            } else if ("/".equals(s)) {
                int value1 = deque.pop();
                int value2 = deque.pop();
                deque.push(value2 / value1);
            } else {
                deque.push(Integer.valueOf(s));
            }
        }

        return deque.peek();
    }

    public static void main(String[] args) {
        String[] tokens = {"4", "13", "5", "/", "+"};
        System.out.println(new Solution150().evalRPN(tokens));
    }
}
