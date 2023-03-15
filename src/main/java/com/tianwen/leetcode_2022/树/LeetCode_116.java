package com.tianwen.leetcode_2022.树;


import java.util.Objects;

/**
 * wangjq
 * 2021年04月13日  20:39
 */
public class LeetCode_116 {

    static class Node {
        int val;
        Node left;
        Node right;
        Node next;
    }

    public Node connect(Node root) {
        Node first = root;
        while (Objects.nonNull(first)) {
            Node nextLevFirst = first.left;
            Node next = first;
            if (Objects.nonNull(next.left)) {
                next.left.next = next.right;
            }
            while (Objects.nonNull(next.next)) {
                if (Objects.nonNull(next.next.left)) {
                    next.right.next = next.next.left;
                    next.next.left.next = next.next.right;
                }
                next = next.next;
            }
            first = nextLevFirst;
        }
        return root;
    }
}
