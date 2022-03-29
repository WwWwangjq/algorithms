package com.tianwen.leetcode.链表;

import com.tianwen.data.structure.ListNode;
import lombok.Data;

import java.util.Objects;

/**
 wangjq
 2022年03月25日  18:37
 */
public class LeetCode_142 {


    public ListNode detectCycle(ListNode head) {
        if (Objects.isNull(head) || Objects.isNull(head.next) || Objects.isNull(head.next.next)) {
            return null;
        } else if (head.next.next.equals(head)) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (Objects.nonNull(fast)) {
            if (!slow.equals(head) && slow.equals(fast)) {
                ListNode node1 = head;
                ListNode node2 = slow;
                while (true) {
                    if (node1.equals(node2)) {
                        return node1;
                    }
                    node1 = node1.next;
                    node2 = node2.next;
                }
            }
            slow = slow.next;
            fast = Objects.isNull(fast.next) ? fast.next : fast.next.next;
        }
        return null;
    }
}
