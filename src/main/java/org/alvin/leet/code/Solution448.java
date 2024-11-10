package org.alvin.leet.code;

import java.util.ArrayList;
import java.util.List;

public class Solution448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int length = nums.length;
        for (int i = 0;i<length; i++){
            int index  = (nums[i] -1 ) %length;
            nums[index] += length;
        }

        List<Integer> ans = new ArrayList<>();
        for (int i= 0; i < length; i++){
            // 如果出现了，肯定大于length
            if(nums[i] <= length){
                ans.add(i+1);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(new Solution448().findDisappearedNumbers(nums));
    }
}
