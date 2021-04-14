package com.tianwen.leetcode;

import lombok.Data;

import java.util.Objects;

/**
 * @Author: wangjq
 * @Date: 2021年04月14日 10:08
 */
public class LeetCode_117 {

    @Data
    static class Node {
        int val;
        Node left;
        Node right;
        Node next;

    }

    private Node first;
    private Node pre;

    public Node connect(Node root) {
        first = root;
        while (Objects.nonNull(first)) {
            Node next = first;
            first = null;
            pre = null;
            while (Objects.nonNull(next)) {
                if (Objects.nonNull(next.left)) {
                    if (Objects.isNull(first)) {
                        first = next.left;
                    }
                    if (Objects.isNull(pre)) {
                        pre = next.left;
                    } else {
                        pre.next = next.left;
                        pre = pre.next;
                    }
                }
                if (Objects.nonNull(next.right)) {
                    if (Objects.isNull(first)) {
                        first = next.right;
                    }
                    if (Objects.isNull(pre)) {
                        pre = next.right;
                    } else {
                        pre.next = next.right;
                        pre = pre.next;
                    }
                }
                next = next.next;
            }
        }
        return root;
    }
}
