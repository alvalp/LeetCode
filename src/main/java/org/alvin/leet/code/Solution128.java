package org.alvin.leet.code;

import java.util.*;

public class Solution128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set  = new HashSet<>();
        for (int num :nums){
            set.add(num);
        }
        int ans = 0;
        for (int num :nums){
            // 优化为O(n), 这里就要求了必须是连续数据的最小值才能进入循环。
            // 如果条件成立，说明这个值是最小的连续值
            if(!set.contains(num-1)){
                int currentNum  = num;
                int currentStreak = 1;
                // 一直往后找
                while(set.contains(currentNum+1)){
                    currentNum++;
                    currentStreak++;
                }
                ans = Math.max(ans, currentStreak);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        System.out.println(new Solution128().longestConsecutive(nums));
    }
}
