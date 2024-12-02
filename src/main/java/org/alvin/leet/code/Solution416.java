package org.alvin.leet.code;


public class Solution416 {

    /**
     * dp[i][j] 是在[0,i]范围内，正好有值总和等于j
     */
    public boolean canPartition(int[] nums) {
        int len = nums.length;

        //优化结果
        int total = 0;
        int max = Integer.MIN_VALUE;
        for (int v : nums) {
            total += v;
            max = Math.max(max, v);
        }
        if (total % 2 == 1 || max > total / 2) {
            return false;
        }

        // dp[i][j] 是在[0,i]范围内，正好有值总和等于j
        // 在0.len的数字中，能否得到total/2
        int target = total / 2;
        boolean[][] dp = new boolean[len][target + 1];
        // 初始化过程
        for (int i = 0; i < len; i++) {
            dp[i][0] = true;
            if (i <= target) {
                dp[i][i] = true;
            }
        }

        //需要递归， 所以从1开始
        for (int i = 1; i < len; i++) {
            int num = nums[i];
            // 计算每一行的情况
            for (int j = 1; j <= target; j++) {
                // 如果num 已经大于计算的值， 说明这个值不能使用
                if (j >= num) {
                    dp[i][j] = dp[i - 1][j - num] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[len - 1][target];
    }
}
