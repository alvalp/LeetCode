package org.alvin.leet.code;

public class Solution80 {
    public int removeDuplicates(int[] nums) {
        if(nums.length < 2){
            return nums.length;
        }

        int left = 2;
        for (int i = 2; i< nums.length; i++){
            if(nums[left-2] != nums[i]){
                nums[left++] = nums[i];
            }
        }
        return left;
    }
}
