package org.alvin.leet.code;

import java.util.HashMap;
import java.util.Map;

public class Solution105 {
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


    int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int count = inorder.length;
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < count; i++) {
            inorderMap.put(inorder[i], i);
        }

        return build(inorderMap, preorder, 0, count - 1);
    }

    public TreeNode build(Map<Integer, Integer> inorderMap, int[] preorder, int left, int right) {
        if (left > right) {
            return null;
        }

        int value = preorder[preIndex++];
        int index = inorderMap.get(value);
        TreeNode node = new TreeNode(value);
        node.left = build(inorderMap, preorder, left, index - 1);
        node.right = build(inorderMap, preorder, index + 1, right);
        return node;
    }
}
