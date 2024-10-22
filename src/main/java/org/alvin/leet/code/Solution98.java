package org.alvin.leet.code;


import java.util.ArrayList;
import java.util.List;

public class Solution98 {
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

    public boolean isValidBST(TreeNode root) {
        List<Integer> value = new ArrayList<>();
        scan(root, value);

        for (int i =0;i < value.size(); i++){
            if(value.get(i+1) < value.get(i)){
                return false;
            }
        }
        return true;
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
