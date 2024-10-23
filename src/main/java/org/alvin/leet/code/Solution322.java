package org.alvin.leet.code;

import java.util.Arrays;

public class Solution322 {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // 数组填充
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                int index = i - coin;
                // 上一个值必须有解， 并且获取最小值
                if (index >= 0 && dp[index] != Integer.MAX_VALUE) {
                    min = Math.min(dp[index] + 1, min);
                }
            }
            dp[i] = min;
        }

        return dp[amount] == Integer.MAX_VALUE ? 0 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};

        System.out.println(new Solution322().coinChange(coins, 11));
    }
}
