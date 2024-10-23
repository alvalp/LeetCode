package org.alvin.leet.code;

import java.util.Arrays;

public class Solution300 {
    public int lengthOfLIS(int[] nums) {
        int ans = 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        for (int i = 1; i < nums.length; i++) {
            for (int k = 0; k < i; k++) {
                if (nums[k] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[k] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {0};
        System.out.println(new Solution300().lengthOfLIS(nums));
    }
}
