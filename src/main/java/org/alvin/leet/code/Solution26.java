package org.alvin.leet.code;

public class Solution26 {
    public int removeDuplicates(int[] nums) {
        if(nums.length < 1){
            return nums.length;
        }
        int left = 1;
        for (int i = 1; i< nums.length ; i++){
            if(nums[left-1] != nums[i]){
                nums[left++] = nums[i];
            }
        }
        return left;
    }

}
