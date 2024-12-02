package org.alvin.leet.code;

public class Solution118 {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        boolean pre = dp[1] == nums[1];

        for (int i = 2; i < nums.length - 1; i++) {
            if (pre) {
                int target = dp[i - 2] + nums[i];
                dp[i] = Math.max(target, dp[i - 1]);
                pre = target > dp[i - 1];
            } else {
                dp[i] = dp[i - 1] + nums[i];
                pre = true;
            }
        }
        return dp[nums.length-1];
    }

    public static void main(String[] args) {
//        System.out.println(new Solution118().generate(1));
    }

}
