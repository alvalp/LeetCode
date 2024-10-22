package org.alvin.leet.code;

public class Solution198 {

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        ;
        // 表示但前位置最多可拿的钱
        int[] values = new int[nums.length];
        values[0] = nums[0];
        values[1] = Math.max(nums[0], nums[1]);
        // 表示有没有拿到当前位置的钱
        boolean flag = values[1] != values[0];

        for (int i = 2; i < nums.length; i++) {

            if (flag) {
                //上一个数被选中， 这个位置不能拿。
                values[i] = values[i - 2] + nums[i] > values[i - 1] ? values[i - 2] + nums[i] : values[i - 1];
                // 要重新判断一下新的位置有没有拿
                flag = values[i - 2] + nums[i] > values[i - 1];
            } else {
                //上一个数没有拿， 这个位置肯定可以拿
                values[i] = values[i - 1] + nums[i];
                flag = true;
            }
        }

        return values[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 1, 2};
        System.out.println(new Solution198().rob(nums));
    }
}
