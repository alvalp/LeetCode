package org.alvin.leet.code;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution20 {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        char[] sCharArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : sCharArray) {
            if (map.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != map.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {

        System.out.println(new Solution20().isValid("()s)[]{}"));
    }
}
