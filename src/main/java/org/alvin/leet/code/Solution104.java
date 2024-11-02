package org.alvin.leet.code;

public class Solution104 {

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

    public int maxDepth(TreeNode root) {
        return depth(root, 0);
    }

    public Integer depth(TreeNode node,  int level ){
        if(node == null){
            return 0;
        }

        int leftLevel = depth(node.left, level+1);
        int rightLevel = depth(node.right, level +1);
        return Math.max(leftLevel, rightLevel);
    }

}
