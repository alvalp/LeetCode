package org.alvin.leet.code;

import java.util.HashMap;
import java.util.Map;

public class Solution167 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int value = numbers[left] + numbers[right];
            if (value == target) {
                // 注意数组的返回写法
                return new int[]{left + 1, right + 1};
            }
            if (value > target) {
                right--;
            } else {
                left++;
            }
        }

        return new int[]{-1, -1};
    }
}
