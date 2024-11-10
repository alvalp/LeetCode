package org.alvin.leet.code;

public class Solution5 {

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;

        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            // 一个字符的时候肯定是回文
            dp[i][i] = true;
        }
        char[] sCharArray = s.toCharArray();
        // 一个字符肯定是回文， 所以从2 开始
        for (int l = 2; l <= len; l++) {
            for (int i = 0; i < len; i++) {
                // 其实位置为i， 长度为l 介绍位置为j
                int j = i + l - 1;
                if (j >= len) {
                    break;
                }

                if (sCharArray[i] != sCharArray[j]) {
                    dp[i][j] = false;
                } else {
                    // 相等， 长度小于3 肯定都是回文
                    if (l <= 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j] && l > maxLen) {
                    maxLen = l;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }


}
