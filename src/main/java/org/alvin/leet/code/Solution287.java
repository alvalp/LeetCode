package org.alvin.leet.code;

public class Solution287 {

    public int findDuplicate(int[] nums) {
        int total = 0;

        for (int i = 0; i < nums.length; i++) {
            // 有一个数出现了2次，其余只出现了一次。 数字是1-n;
            total = total + nums[i];
        }

        for (int i = 0; i < nums.length - 1; i++) {
            // 有一个数出现了2次，其余只出现了一次。 数字是1-n;
            total = total - (i + 1);
        }

        return total;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};
        System.out.println(new Solution287().findDuplicate(nums));
    }
}
