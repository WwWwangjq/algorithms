package com.tianwen.leetcode_2023;

import com.tianwen.data.structure.ListNode;

import java.util.Objects;

/**
 * @Author: wangjq
 * @Date: 2023年03月26日 14:44
 */
public class LeetCode_21_solution2 {

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
