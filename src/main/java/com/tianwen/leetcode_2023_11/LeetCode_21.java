package com.tianwen.leetcode_2023_11;

import com.tianwen.data.structure.ListNode;

import java.util.Objects;

/**
 * @Author: wangjq
 * @Date: 2023年11月22日 14:24
 */
public class LeetCode_21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (Objects.isNull(list1) && Objects.isNull(list2)) {
            return null;
        }
        ListNode head = new ListNode();
        ListNode pre = head;
        ListNode node1 = list1;
        ListNode node2 = list2;
        while (true) {
            if (Objects.isNull(node1)) {
                pre.next = node2;
                break;
            } else if (Objects.isNull(node2)) {
                pre.next = node1;
                break;
            } else {
                if (node1.val <= node2.val) {
                    pre.next = node1;
                    node1 = node1.next;
                } else {
                    pre.next = node2;
                    node2 = node2.next;
                }
                pre = pre.next;
            }
        }
        return head.next;
    }
}
