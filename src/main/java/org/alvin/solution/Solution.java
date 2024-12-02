package org.alvin.solution;

import java.util.*;


public class Solution {


    public String longestPalindrome(String s) {
        int length = s.length();
        //在[i,j]的字符串是不是回文
        boolean[][] dp = new boolean[length + 1][length + 1];
        if (s.length() < 2) {
            return s;
        }
        int begin = 0;
        int maxLen = 1;

        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }
        char[] sCharArray = s.toCharArray();
        for (int len = 2; len <= s.length(); len++) {
            for (int start = 0; start < s.length(); start++) {
                // 这里的-1 需要注意一下
                int end = start + len - 1;
                if (end >= s.length()) {
                    break;
                }
                if (sCharArray[start] != sCharArray[end]) {
                    dp[start][end] = false;
                } else {
                    if (len <= 3) {
                        dp[start][end] = true;
                    } else {
                        dp[start][end] = dp[start + 1][end - 1];
                    }
                }

                if (dp[start][end] && maxLen < len) {
                    begin = start;
                    maxLen = len;
                }
            }
        }

        return s.substring(begin, begin + maxLen);
    }


    public static void main(String[] args) {
        int[] nums = {6, 5, 5};
        System.out.println(new Solution().longestPalindrome("babad"));
        ;
    }
}
