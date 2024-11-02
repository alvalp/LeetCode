package org.alvin.leet.code;

public class Solution101 {
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

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSame(root.left, root.right);
    }

    public boolean isSame(TreeNode left, TreeNode right) {
        if (left == null && right != null || left != null && right == null) {
            return false;
        } else if (left == null && right == null) {
            return true;
        }

        return left.val == right.val && isSame(left.left, right.right) && isSame(left.right, right.left);
    }

}
