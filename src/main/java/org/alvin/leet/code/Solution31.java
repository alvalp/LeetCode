package org.alvin.leet.code;

public class Solution31 {

    /**
     * 需要理解这个题目的解题思路
     */
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        for (int i = len-2; i >=0; i--){
            //找到的左边的目标值
            if(nums[i] < nums[i+1]){
                for (int j = len -1; j > i; j--) {
                    // 知道第一个比目标值大的值
                    if(nums[j] > nums[i]){
                        swap(nums,i,j);
                        reverse(nums, i+1, len-1);
                        return;
                    }
                }
            }
        }

        // 没有退出， 说明已经是最大值
         reverse(nums,0,len-1);
    }

    private void  swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i]= nums[j];
        nums[j]=  temp;
    }

    private void reverse(int[] nums, int start, int end){
        while(start < end){
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}
