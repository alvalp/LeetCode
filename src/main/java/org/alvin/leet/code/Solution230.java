package org.alvin.leet.code;


import java.util.ArrayList;
import java.util.List;

public class Solution230 {
    class TreeNode {
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

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> value = new ArrayList<>();
        scan(root, value);
        return value.get(k-1);
    }

    private void scan(TreeNode node, List<Integer> values) {
        if (node == null) {
            return;
        }
        scan(node.left, values);
        values.add(node.val);
        scan(node.right, values);
    }

}
