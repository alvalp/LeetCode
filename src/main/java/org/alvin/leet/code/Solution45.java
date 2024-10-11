package org.alvin.leet.code;

public class Solution45 {

    public int jump(int[] nums) {
        int ans = 0;
        // 记录当前的位置
        int curIndex = 0;
        // 记录最远的可达位置
        int maxReach = 0;

        //不需要访问最后一个位置，，这是因为在访问最后一个元素之前，我们的边界一定大于等于最后一个位置，
        // 否则就无法跳到最后一个位置了。如果访问最后一个元素，在边界正好为最后一个位置的情况下，
        // 我们会增加一次「不必要的跳跃次数」
        for (int i = 0; i < nums.length - 1; i++) {
            // 每次都计算可达的最远位置
            maxReach = Math.max(maxReach, nums[i] + i);
            // 已经是本次跳跃最远的位置了， 需要更新记录了。 但是本质上是在当前maxReach值得到的地方进行跳跃的
            if (i == curIndex) {
                curIndex = maxReach;
                ans++;
            }
        }
        return ans;
    }
}
