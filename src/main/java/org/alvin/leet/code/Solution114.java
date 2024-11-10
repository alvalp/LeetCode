package org.alvin.leet.code;

public class Solution114 {

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

    /**
     * 每次都把节点的右子树，放到节点左子树最右的叶子节点上。
     *
     * @param root
     */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode current = root;
        while (current != null) {
            if(current.left != null){
                // 寻找左子树中的最右叶子节点
                TreeNode pre = current.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = current.right;
                current.right = current.left;
                current.left = null;
            }

            //移动到下一个节点
            current = current.right;
        }

    }
}
