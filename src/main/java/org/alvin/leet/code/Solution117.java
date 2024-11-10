package org.alvin.leet.code;

import java.util.ArrayList;
import java.util.List;

public class Solution117 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;


    public Node connect(Node root) {
        List<Node> firstLevel = new ArrayList<>();
        List<Node> secondLevel = new ArrayList<>();
        if(root != null){
            firstLevel.add(root);
        }
        connectNode(firstLevel, secondLevel);
        return root;
    }

    private void connectNode(List<Node> firstLevel, List<Node> secondLevel) {
        if (firstLevel.isEmpty()) {
            return;
        }
        for (int i = 1; i < firstLevel.size(); i++) {
            firstLevel.get(i - 1).next = firstLevel.get(i);
        }

        for (Node node : firstLevel) {
            if (node.left != null) {
                secondLevel.add(node.left);
            }
            if (node.right != null) {
                secondLevel.add(node.right);
            }
        }

        firstLevel.clear();
        firstLevel.addAll(secondLevel);
        secondLevel.clear();
        connectNode(firstLevel, secondLevel);
    }


}
