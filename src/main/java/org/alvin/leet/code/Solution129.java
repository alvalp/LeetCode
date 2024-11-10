package org.alvin.leet.code;

import java.util.ArrayList;
import java.util.List;

public class Solution129 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int sumNumbers(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        dfs(root, nums, 0);
        int total = 0;
        for (int value : nums) {
            total += value;
        }
        return total;
    }

    public void dfs(TreeNode node, List<Integer> nums, int num) {
        if (node == null) {
            return;
        }

        int value = num * 10 + node.val;
        if (node.left == null && node.right == null) {
            nums.add(value);
        }
        dfs(node.left, nums, value);
        dfs(node.right, nums, value);
    }
}
