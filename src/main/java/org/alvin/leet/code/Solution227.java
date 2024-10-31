package org.alvin.leet.code;

import java.util.Deque;
import java.util.LinkedList;

public class Solution227 {
    public int calculate(String s) {

        Deque<Integer> stack = new LinkedList<>();

        int ans = 0;
        int i = 0;
        s = s.replace(" ", "");
        char[] sCharArray = s.toCharArray();
        int n = sCharArray.length;
        char opt = '+';
        while (i < n) {
           if(!Character.isDigit(sCharArray[i])){
              opt =  sCharArray[i];
              i++;
           }

            // 获取到num
            int num = 0;
            while (i < n && Character.isDigit(sCharArray[i])) {
                num = num * 10 + sCharArray[i] - '0';
                i++;
            }

            if (opt == '+') {
                stack.push(num);
            } else if (opt == '-') {
                stack.push(-num);
            } else if (opt == '*') {
                stack.push(stack.pop() * num);
            } else if (opt == '/') {
                stack.push(stack.pop() / num);
            }
        }

        while (!stack.isEmpty()) {
            ans = ans + stack.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution227().calculate("3+5 / 2"));
    }
}
