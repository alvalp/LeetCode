package org.alvin.leet.code;

public class Solution55 {
    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max < i) {
                return false;
            }
            max = Math.max(max, nums[i] + i);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {0, 2, 3};
        System.out.println(new Solution55().canJump(nums));
    }
}
