package org.alvin.leet.code;

public class Solution53 {
    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        if (nums == null || nums.length == 0) {
            return -0;
        }
        int value = -1;
        for (int num : nums) {
            // 要最大值， 之前的值小于0，就需要果断抛弃
            value = value <= 0 ? num : value + num;
            ans = Math.max(ans, value);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new Solution53().maxSubArray(nums));
    }
}
