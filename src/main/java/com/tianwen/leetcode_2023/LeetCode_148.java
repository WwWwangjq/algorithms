package com.tianwen.leetcode_2023;

import com.tianwen.data.structure.ListNode;

import java.util.Objects;

/**
 * @Author: wangjq
 * @Date: 2023年03月26日 13:25
 */
public class LeetCode_148 {

    public static void main(String[] args) {
        ListNode head = new ListNode(4, new ListNode(5, new ListNode(2, new ListNode(1, new ListNode(3)))));
        LeetCode_148 leetCode148 = new LeetCode_148();
        ListNode result = leetCode148.sortList(head);
        System.out.println(result);
    }


    public ListNode sortList(ListNode head) {
        return recur(head, null);
    }

    private ListNode recur(ListNode head, ListNode tail) {
        if (Objects.isNull(head)) {
            return tail;
        } else if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        return mergeTwoLists(recur(head, mid), recur(mid, tail));
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode pre = vHead;
        ListNode node1 = list1;
        ListNode node2 = list2;
        while (true) {
            if (Objects.isNull(node1)) {
                pre.next = node2;
                break;
            } else if (Objects.isNull(node2)) {
                pre.next = node1;
                break;
            } else if (node1.val <= node2.val) {
                pre.next = node1;
                pre = pre.next;
                node1 = node1.next;
            } else {
                pre.next = node2;
                pre = pre.next;
                node2 = node2.next;
            }
        }
        return vHead.next;
    }

    private final ListNode vHead = new ListNode();
}
