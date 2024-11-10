package org.alvin.leet.code;

import java.util.HashMap;
import java.util.Map;

public class Solution106 {

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

    int postIndex = 0;

    /**
     * 中序遍历， 后续遍历  . 后续遍历的最后一个节点，都是根节点。
     * 根节点可以将中序遍历，分为前后两段，前半段为左子树， 后半段为右子树
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // 用索引保存下标，方便查找
        Map<Integer, Integer> indexMap = new HashMap<>();
        postIndex = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }

        return build(indexMap, inorder, postorder, 0, inorder.length - 1);
    }

    private TreeNode build(Map<Integer, Integer> indexMap, int[] inorder, int[] postorder, int left, int right) {
        if (left > right) {
            return null;
        }

        //找到中序的位置
        int value = postorder[postIndex--];
        TreeNode node = new TreeNode(value);
        int index = indexMap.get(value);

        // 递归前后两段, 但是必须先调用右子树
        node.right = build(indexMap, inorder, postorder, index + 1, right);
        node.left = build(indexMap, inorder, postorder, left, index - 1);
        return node;
    }
}
