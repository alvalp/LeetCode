package org.alvin.leet.code;

import java.util.ArrayList;
import java.util.List;

public class Solution530 {

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

    class Solution {
        public int getMinimumDifference(TreeNode root) {
            List<Integer> value = new ArrayList<>();
            scan(root, value);

            Integer min = Integer.MAX_VALUE;
            for (int i = 0; i < value.size() - 1; i++) {
                int temp = value.get(i + 1) - value.get(i);
                min = Math.min(min, temp);
            }

            return min;
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


}
