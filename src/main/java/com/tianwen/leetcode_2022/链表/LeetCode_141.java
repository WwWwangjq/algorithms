package com.tianwen.leetcode_2022.链表;

import com.tianwen.data.structure.ListNode;

import java.util.Objects;

/**
 * wangjq
 * 2021年05月17日  21:39
 */
public class LeetCode_141 {

    public boolean hasCycle(ListNode head) {
        if (Objects.isNull(head)) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (true) {
            if (Objects.nonNull(fast.next) && Objects.nonNull(fast.next.next)) {
                fast = fast.next.next;
            } else {
                return false;
            }
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
    }
}
