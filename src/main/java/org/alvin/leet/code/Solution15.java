package org.alvin.leet.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        //确定一个数之后， 就降级成为two sum 的题目
        for (int i = 0; i < nums.length; i++) {
            // 跳过重复的值， 会导致出现重复的答案
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = -nums[i];
            int right = nums.length-1;
            for (int left = i +1; left < nums.length; left++){
                // 过滤掉重复元素
                if(left > i +1 && nums[left]== nums[left-1]){
                    continue;
                }

                while(left < right && nums[left] + nums[right] > target){
                    right--;
                }
                // 重合， 不能是答案
                if(left == right){
                    break;
                }

                if (nums[left] + nums[right] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}
