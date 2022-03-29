package com.tianwen.leetcode.链表;

import com.tianwen.data.structure.ListNode;

import java.util.Objects;

/**
 * wangjq
 * 2022年03月26日  16:58
 */
public class LeetCode_876 {
    public static void main(String[] args) {
//        ListNode head = new ListNode(1);
//        ListNode head = new ListNode(1, new ListNode(2));
//        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));
//        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
//        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));

        LeetCode_876 leetCode_876 = new LeetCode_876();
        ListNode node = leetCode_876.middleNode(head);
        System.out.println(ListNode.listVal(node));;
    }
    public ListNode middleNode(ListNode head) {
        if (Objects.isNull(head)) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (true) {
            ListNode fastNext = fast.next;
            if (Objects.isNull(fastNext)) {
                return slow;
            } else if (Objects.isNull(fastNext.next)) {
                return slow.next;
            }
            slow = slow.next;
            fast = fastNext.next;
        }
    }
}
