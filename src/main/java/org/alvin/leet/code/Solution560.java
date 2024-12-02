package org.alvin.leet.code;

public class Solution560 {
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        for (int i =0; i < nums.length ;i++){
            int value = 0;
            for (int j = i; j >=0; j--){
                value+=nums[j];
                if(value == k){
                    ans++;
                }
            }
        }
        return ans;
    }
    }
