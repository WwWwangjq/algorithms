package com.tianwen.leetcode.链表;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * wangjq
 * 2022年03月25日  11:23
 */
public class LeetCode_138 {

    /**
     * //输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
     * //输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //
     * //
     * //输入：head = [[1,1],[2,1]]
     * //输出：[[1,1],[2,1]]
     */
    public static void main(String[] args) {
        LeetCode_138 leetCode_138 = new LeetCode_138();
    }

    Map<Node, Node> randomMap = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (Objects.isNull(head)) {
            return null;
        }
        Node newHead = recur(head);
        Node node = head;
        Node newNode = newHead;
        while (Objects.nonNull(node)) {
            Node nodeRandom = node.random;
            newNode.random = randomMap.get(nodeRandom);
            node = node.next;
            newNode = newNode.next;
        }
        return newHead;
    }

    private Node recur(Node node) {
        if (Objects.isNull(node)) {
            return null;
        }
        Node newNode = new Node(node.val);
        newNode.next = recur(node.next);
        randomMap.put(node, newNode);
        return newNode;
    }


    @NoArgsConstructor
    @AllArgsConstructor
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
