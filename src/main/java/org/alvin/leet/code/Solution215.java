package org.alvin.leet.code;

public class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int v : nums) {
            max = Math.max(max, v);
            min = Math.min(min, v);
        }
        int length = max - min + 1;
        int[] count = new int[length];
        for (int v : nums) {
            count[v - min]++;
        }

        int total = 0;
        for (int i = length - 1; i >= 0; i--) {
            total += count[i];
            if (total >= k) {
                return i + min;
            }
        }

        return -1;
    }
}
