package org.alvin.leet.code;

public class Solution279 {
    public int numSquares(int n) {
        // 表示n的最小个数
        int[] dp = new int[n + 1];
        // 数字从1开始，到等于n
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, dp[i - j * j]);
            }
            dp[i] = min + 1;
        }

        return dp[n];
    }
}
