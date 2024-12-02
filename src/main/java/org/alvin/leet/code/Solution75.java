package org.alvin.leet.code;

import java.util.Collections;

public class Solution75 {

    public void sortColors(int[] nums) {

        int left = 0;
        for (int i =0; i < nums.length ; i++){
            if(nums[i]==0){
                swap(nums, i, left);
                left++;
            }
        }

        for (int i =left; i < nums.length ; i++){
            if(nums[i]== 1){
                swap(nums, i, left);
                left++;
            }
        }
    }

    private void swap(int[] nums, int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j]= temp;
    }
}
