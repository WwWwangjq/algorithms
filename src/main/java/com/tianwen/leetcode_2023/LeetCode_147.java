package com.tianwen.leetcode_2023;

import com.tianwen.data.structure.ListNode;

import java.util.Objects;

/**
 * @Author: wangjq
 * @Date: 2023年03月26日 13:55
 */
public class LeetCode_147 {

    public ListNode insertionSortList(ListNode head) {
        ListNode vHead = new ListNode();
        vHead.next = head;
        ListNode node = vHead;
        int maxValue = Integer.MIN_VALUE;
        while (true) {
            ListNode next = node.next;
            if (Objects.isNull(next)) {
                break;
            } else if (next.val >= maxValue) {
                node = next;
                maxValue = next.val;
            } else {
                node.next = next.next;
                sort(vHead, next);
            }
        }
        return vHead.next;
    }

    private void sort(ListNode vHead, ListNode insertNode) {
        ListNode node = vHead;
        while (Objects.nonNull(node)) {
            if (Objects.isNull(node.next)) {
                node.next = insertNode;
            } else if (node.next.val > insertNode.val) {
                ListNode next = node.next;
                node.next = insertNode;
                insertNode.next = next;
                break;
            }
            node = node.next;
        }
    }
}
