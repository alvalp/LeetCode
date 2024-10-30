package org.alvin.leet.code;

import java.util.*;

public class Solution133 {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        Map<Integer, Node> nodeMap = new HashMap<>();
        return clone(node, nodeMap);
    }

    public Node clone(Node node, Map<Integer, Node> nodeMap) {
        if (node == null) {
            return node;
        }
        if (nodeMap.containsKey(node.val)) {
            return nodeMap.get(node.val);
        }
        Node newNode = new Node(node.val);
        nodeMap.put(node.val, newNode);

        for (Node childNode : node.neighbors) {
            newNode.neighbors.add(clone(childNode, nodeMap));
        }

        return node;
    }
}
