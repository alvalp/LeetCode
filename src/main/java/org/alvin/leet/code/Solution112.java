package org.alvin.leet.code;

public class Solution112 {

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

    // 这道题一定要注意细节
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // null 的情况肯定不存在
        if (root == null) {
            return false;
        } else
            // 叶子节点，必须是左右子树都是null
            if (root.left == null && root.right == null) {
                return targetSum == root.val;
            }
            // 如果有left树为空， 需要返回false。 否则会认为当前节点是叶子节点
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}
