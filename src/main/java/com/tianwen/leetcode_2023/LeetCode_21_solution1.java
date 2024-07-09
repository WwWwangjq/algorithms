package com.tianwen.leetcode_2023;

import com.tianwen.data.structure.ListNode;

import java.util.Objects;

/**
 * @Author: wangjq
 * @Date: 2023年03月12日 18:04
 */
public class LeetCode_21_solution1 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (Objects.isNull(list1)) {
            return list2;
        } else if (Objects.isNull(list2)) {
            return list1;
        }
        ListNode node1 = list1;
        ListNode node2 = list2;
        ListNode node = new ListNode();
        ListNode vHead = node;

        while (true) {
            if (Objects.isNull(node1)) {
                node.next = node2;
                break;
            } else if (Objects.isNull(node2)) {
                node.next = node1;
                break;
            } else {
                ListNode newNode = new ListNode();
                if (node1.val < node2.val) {
                    newNode.val = node1.val;
                    node1 = node1.next;
                } else {
                    newNode.val = node2.val;
                    node2 = node2.next;
                }
                node.next = newNode;
                node = node.next;
            }
        }
        return vHead.next;
    }
}
