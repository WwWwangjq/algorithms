package com.tianwen.leetcode.链表;

import com.tianwen.data.structure.ListNode;

import java.util.Objects;

/**
 * wangjq
 * 2021年05月17日  21:29
 */
public class LeetCode_83 {

    public ListNode deleteDuplicates(ListNode head) {
        if (Objects.isNull(head)) {
            return null;
        }
        ListNode node = head.next;
        ListNode pre = head;
        while (Objects.nonNull(node)) {
            if (pre.val == node.val) {
                pre.next = node.next;
            } else {
                pre = node;
            }
            node = node.next;
        }
        return head;
    }
}
