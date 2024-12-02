package org.alvin.leet.code;

public class Solution152 {

    public int maxProduct(int[] nums) {
        // 以i结尾的连续字符串的最大最小值。
        int[] maxDp = new int[nums.length];
        int[] minDp = new int[nums.length];
        for (int i =0; i < nums.length; i++){
            maxDp[i] = nums[i];
            minDp[i] = nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            maxDp[i] = max(maxDp[i] , maxDp[i-1] * nums[i], minDp[i-1]* nums[i]);
            minDp[i] = min(minDp[i], maxDp[i-1] * nums[i], minDp[i-1]* nums[i]);
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < maxDp.length; i++){
            ans  = Math.max(ans, maxDp[i]);
        }
        return ans;
    }

    private int max(int a, int b ,int c){
        return Math.max(a, Math.max(b,c));
    }
    private int min(int a, int b, int c){
        return Math.min(a, Math.min(b,c));
    }
}
