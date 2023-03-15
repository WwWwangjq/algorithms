package com.tianwen.leetcode_2022.链表;

import com.tianwen.data.structure.ListNode;

import java.util.Objects;

/**
 * wangjq
 * 2021年05月17日  22:37
 */
public class LeetCode_206 {

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        ListNode head = node1;

        LeetCode_206 leetCode_206 = new LeetCode_206();
        ListNode node = leetCode_206.reverseList(head);
        System.out.println(node);
    }

    public ListNode reverseList(ListNode head) {
        if (Objects.isNull(head)) {
            return null;
        }
        ListNode pre = null;
        ListNode node = head;
        while (Objects.nonNull(node)) {
            ListNode next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }

/*    public ListNode reverseList(ListNode head) {
        if (Objects.isNull(head)) {
            return null;
        }
        ListNode newHead = new ListNode();
        reverse(head, newHead);
        head.next = null;
        return newHead.next;
    }

    private ListNode reverse(ListNode node, ListNode newNode) {
        if (Objects.isNull(node.next)) {
            newNode.next = node;
            return node;
        }
        ListNode next = reverse(node.next, newNode);
        next.next = node;
        return node;
    }*/
}
