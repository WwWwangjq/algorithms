package com.tianwen.leetcode.树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * wangjq
 * 2022年04月29日  21:38
 */
public class LeetCode_559 {
    public int maxDepth(Node root) {
        int height = 0;
        if (Objects.isNull(root)) {
            return height;
        }
        LinkedList<Node> nodeList = new LinkedList<>();
        nodeList.add(root);
        while (!nodeList.isEmpty()) {
            height ++;
            int size = nodeList.size();
            for (int i = 0; i < size; i ++) {
                Node node = nodeList.removeFirst();
                if (Objects.nonNull(node.children) && !node.children.isEmpty()) {
                    for (Node nd : node.children) {
                        nodeList.addLast(nd);
                    }
                }
            }
        }
        return height;
    }


    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
