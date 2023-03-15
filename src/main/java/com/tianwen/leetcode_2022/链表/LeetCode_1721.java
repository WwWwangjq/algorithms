package com.tianwen.leetcode_2022.链表;

import com.tianwen.data.structure.ListNode;

import java.util.Objects;

/**
 * @Author: wangjq
 * @Date: 2022年03月29日 16:11
 */
public class LeetCode_1721 {

    public static void main(String[] args) {
        LeetCode_1721 leetCode_1721 = new LeetCode_1721();
//        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
//        ListNode head = new ListNode(1, new ListNode(2));
        ListNode head = new ListNode(1);
        int k = 1;
        ListNode node = leetCode_1721.swapNodes(head, k);
        System.out.println(ListNode.listVal(node));
    }

    public ListNode swapNodes(ListNode head, int k) {
        if (Objects.isNull(head) || k <= 0) {
            return head;
        }

        int i = 1;
        ListNode fPre = new ListNode();
        fPre.next = head;

        ListNode rightPre = new ListNode();
        rightPre.next = head;

        ListNode leftPre = new ListNode();
        leftPre.next = head;

        ListNode node = head;
        while (Objects.nonNull(node)) {
            if (i < k) {
                leftPre = leftPre.next;
            } else if (i > k) {
                rightPre = rightPre.next;
            }
            node = node.next;
            i ++;
        }
        if (k > i - 1) {
            return null;
        }

        ListNode left = leftPre.next;
        ListNode right = rightPre.next;
        int lVal = left.val;
        left.val = right.val;
        right.val = lVal;
        return fPre.next;
    }

}
