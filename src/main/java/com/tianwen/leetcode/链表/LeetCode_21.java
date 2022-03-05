package com.tianwen.leetcode.链表;

import com.tianwen.data.structure.ListNode;

import java.util.Objects;

/**
 * wangjq
 * 2021年04月09日  22:57
 */
public class LeetCode_21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode listNode = null;
        while (true) {
            if (Objects.isNull(l1) && Objects.isNull(l2)) {
                break;
            } else if (Objects.isNull(l1)) {
                if (Objects.isNull(listNode)) {
                    listNode = new ListNode(l2.val);
                    head = listNode;
                } else {
                    listNode.next = new ListNode(l2.val);
                    listNode = listNode.next;
                }
                l2 = l2.next;
            } else if (Objects.isNull(l2)) {
                if (Objects.isNull(listNode)) {
                    listNode = new ListNode(l1.val);
                    head = listNode;
                } else {
                    listNode.next = new ListNode(l1.val);
                    listNode = listNode.next;
                }
                l1 = l1.next;
            } else {
                if (l1.val <= l2.val) {
                    if (Objects.isNull(listNode)) {
                        listNode = new ListNode(l1.val);
                        head = listNode;
                    } else {
                        listNode.next = new ListNode(l1.val);
                        listNode = listNode.next;
                    }
                    l1 = l1.next;
                } else {
                    if (Objects.isNull(listNode)) {
                        listNode = new ListNode(l2.val);
                        head = listNode;
                    } else {
                        listNode.next = new ListNode(l2.val);
                        listNode = listNode.next;
                    }
                    l2 = l2.next;
                }
            }
        }
        return head;
    }
}
