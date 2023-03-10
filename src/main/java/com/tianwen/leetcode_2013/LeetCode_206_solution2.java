package com.tianwen.leetcode_2013;

import com.tianwen.data.structure.ListNode;

import java.util.Objects;

/**
 * @Author: wangjq
 * @Date: 2023年03月09日 22:58
 */
public class LeetCode_206_solution2 {


    // 12345 -> 54321
    public ListNode reverseList(ListNode head) {
        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return head;
        }
        ListNode newHead = head;
        ListNode node = head.next;
        head.next = null;
        while (Objects.nonNull(node)) {
            ListNode next = node.next;
            node.next = newHead;
            newHead = node;
            node = next;
        }
        return newHead;
    }

}
