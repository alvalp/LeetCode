package org.alvin.leet.code;

public class Solution169 {


    public int majorityElement(int[] nums) {
        int count = 0;
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                ans = nums[i];
            }
            int value = (nums[i] == ans ? 1 : -1);
            count += value;
        }
        return ans;
    }
}
