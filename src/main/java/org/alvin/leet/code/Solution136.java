package org.alvin.leet.code;

public class Solution136 {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int v: nums){
            ans = ans ^ v;
        }
        return ans;
    }
}
