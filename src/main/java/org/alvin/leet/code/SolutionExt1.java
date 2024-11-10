package org.alvin.leet.code;

import java.util.Arrays;

public class SolutionExt1 {


    /**
     * 将数组分成m组， 每组的和相同
     *
     * @param nums
     * @return
     */
    private int maxM(int[] nums) {

        int total = 0;
        for (int num : nums) {
            total = total + num;
        }

        // 从大到校遍历， 因为要返回直达值
        for (int m = nums.length; m > 0; m--) {
            // 可以平均分为m组
            if (total % m == 0) {
                // 记录每个值是否被使用
                boolean[] used = new boolean[nums.length];
                int target = total / m;
                if (canPartition(nums, used, 0, target, m)) {
                    return m;
                }
            }
        }

        return 0;
    }

    //是否可以平均分成m组数字, 存暴力解法
    public boolean canPartition(int[] nums, boolean[] used, int groupValue, int target, int m) {
        // 只有一组了, 判断所有没使用的总和是不是
        if (m == 1) {
            int total = 0;
            for (int i = 0; i < nums.length; i++) {
                if (!used[i]) {
                    total = total + nums[i];
                }
            }
            return total == target;
        }

        // 已经找到了一组
        if (groupValue == target) {
            return canPartition(nums, used, 0, target, m - 1);
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                boolean b = canPartition(nums, used, groupValue + nums[i], target, m);
                if (b) {
                    return true;
                }
                used[i] = false;
            }
        }
        return false;
    }

    public static int maximumGroups(int[] nums) {
        int n = nums.length;
        int totalSum = Arrays.stream(nums).sum();

        for (int m = n; m > 0; m--) {
            if (totalSum % m == 0) {
                int targetSum = totalSum / m;
                boolean[] used = new boolean[n];
                if (dfs(nums, used, 0, 0, m, targetSum)) {
                    return m;
                }
            }
        }

        return 0;
    }

    private static boolean dfs(int[] nums, boolean[] used, int start, int groupSum, int m, int targetSum) {
        if (m == 1) {
            return true;
        }
        if (groupSum == targetSum) {
            return dfs(nums, used, 0, 0, m - 1, targetSum);
        }
        for (int i = start; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                if (dfs(nums, used, i + 1, groupSum + nums[i], m, targetSum)) {
                    return true;
                }
                used[i] = false;
            }
        }

        return false;
    }

//    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 4, 5, 6};
//        int maxGroups = maximumGroups(nums);
//        System.out.println("最大的分组数m为: " + maxGroups);
//    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6,7,8};
        System.out.println(new SolutionExt1().maxM(nums));
    }
}
