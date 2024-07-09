package com.tianwen.leetcode_2023_11;

import com.tianwen.data.structure.ListNode;

import java.util.Objects;

/**
 * @Author: wangjq
 * @Date: 2023年11月22日 13:52
 */
public class LeetCode_206 {

    public ListNode reverseList(ListNode head) {
        if (Objects.isNull(head)) {
            return null;
        }
        ListNode pre = new ListNode();
        ListNode node = head;
        while (Objects.nonNull(node)) {
            ListNode oldHead = pre.next;
            ListNode next = node.next;
            pre.next = node;
            node.next = oldHead;
            node = next;
        }
        return pre.next;
    }
}
