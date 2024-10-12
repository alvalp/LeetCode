package org.alvin.leet.code;

import java.util.Deque;
import java.util.LinkedList;

public class Solution239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        // 用于存放下标, 构建单调队列
        int n = nums.length;
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            // 如果当前值 大于队尾的值， 就删除队尾的值。 因为要取最大值
            // 由于当前值更大， 之前的值就不可能是这个区间内的最大值。 所以移除
            while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.offerLast(i);
        }

        int[] ans = new int[n -k + 1];
        ans[0] = nums[queue.peekFirst()];

        for (int i = k; i < n; i++) {
            while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.offerLast(i);

            // 最大值可能已经离开区间了
            while (queue.peekFirst() <= i - k) {
                queue.pollFirst();
            }
            ans[i - k + 1] = nums[queue.peekFirst()];
        }

        return ans;
    }

}
