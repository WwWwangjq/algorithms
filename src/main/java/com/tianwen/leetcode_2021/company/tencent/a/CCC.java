package com.tianwen.leetcode_2021.company.tencent.a;

import lombok.Data;

import java.util.Objects;

/**
 * wangjq
 * 2021年05月18日  20:28
 */
public class CCC {

    public Node delete(Node head, int val) {
        Node node = head;
        Node pre = null;
        Node h = null;
        while (Objects.nonNull(node)) {
            if (Objects.isNull(pre)) {
                if (node.val == val) {
                    node = node.next;
                } else {
                    h = node;
                    pre = node;
                    node = node.next;
                }
            } else {
                if (node.val == val) {
                    pre.next = node.next;
                    node = pre.next;
                } else {
                    pre = node;
                    node = node.next;
                }
            }

        }
        return h;
    }

    public void add(Node head, int val) {
        Node node = head;
        while (Objects.nonNull(node)) {
            if (Objects.isNull(node.next)) {
                node.next = new Node(val);
                break;
            }
            node = node.next;
        }
    }

    @Data
    static class Node {
        private int val;
        private Node next;
        Node (int val) {
            this.val = val;
        }
    }
}
