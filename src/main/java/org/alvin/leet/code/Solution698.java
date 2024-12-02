package org.alvin.leet.code;

public class Solution698 {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int total = 0;
        for (int v : nums){
            total+=v;
        }
        if(total % k != 0){
            return false;
        }

        boolean[] used = new boolean[nums.length];
        return backTrack(used, nums, k, total/k, 0);
    }

    private boolean backTrack(boolean[] used, int [] nums, int k , int target , int currentValue){
        if(k ==1){
            return true;
        }

        if(currentValue == target){
            return backTrack(used, nums, k-1, target, 0);
        }

        for (int i =0 ; i < nums.length; i++){
            if(!used[i]){
                used[i] = true;
                boolean result = backTrack(used, nums, k, target, currentValue + nums[i]);
                if(result){
                    return true;
                }
                used[i] =false;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[] nums = {4,3,2,3,5,2,1};
        System.out.println(new Solution698().canPartitionKSubsets(nums, 4));
    }

}
