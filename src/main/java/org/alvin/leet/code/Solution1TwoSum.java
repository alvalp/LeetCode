package org.alvin.leet.code;

import java.util.HashMap;
import java.util.Map;

public class Solution1TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int value = target - nums[i];
            if (hashMap.containsKey(value)) {
                return new int[]{i, hashMap.get(value)};
            }
            hashMap.put(nums[i], i);
        }

        throw new RuntimeException();
    }
}
