package com.tianwen.leetcode_2023;

import com.tianwen.data.structure.ListNode;

import java.util.Objects;

/**
 * @Author: wangjq
 * @Date: 2023年03月20日 8:19
 */
public class LeetCode_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n < 1) {
            return head;
        }
        ListNode vHead = new ListNode();
        vHead.next = head;
        ListNode pre = vHead;
        ListNode slow = head;
        ListNode fast = head;
        int i = 1;
        while (Objects.nonNull(fast)) {
            ListNode fNext = fast.next;
            if (Objects.isNull(fNext)) {
                pre.next = slow.next;
            } else if (i >= n) {
                pre = pre.next;
                slow = slow.next;
            }
            fast = fNext;
            i ++;
        }
        return vHead.next;
    }
}
