package com.tianwen.leetcode_2013;

import com.tianwen.data.structure.ListNode;

import java.util.Objects;

/**
 * @Author: wangjq
 * @Date: 2023年03月09日 22:58
 */
public class LeetCode_206_solution1 {

    // 12345 -> 54321
    public ListNode reverseList(ListNode head) {
        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return head;
        }
        recur(null, head);
        return newHead;
    }

    private ListNode newHead;

    private void recur(ListNode preNode, ListNode node) {
        if (Objects.isNull(node)) {
            newHead = preNode;
            return;
        }
        recur(node, node.next);
        node.next = preNode;
    }
}
