package com.tianwen.leetcode_2023;

import com.tianwen.data.structure.ListNode;

import java.util.List;
import java.util.Objects;

/**
 * @Author: wangjq
 * @Date: 2023年03月16日 20:39
 */
public class LeetCode_92 {

    public static void main(String[] args) {
//        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
//        int left = 2;
//        int right = 4;
        ListNode head = new ListNode(1, new ListNode(2));
        int left = 1;
        int right = 2;
        LeetCode_92 leetCode92 = new LeetCode_92();
        ListNode listNode = leetCode92.reverseBetween(head, left, right);
        System.out.println(listNode);
    }

    // 12345
    // 13245
    // 14325
    // 2 4
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (Objects.isNull(head)) {
            return null;
        }
        ListNode nNode = new ListNode();
        nNode.next = head;
        ListNode vHead = nNode;
        ListNode pre = nNode;
        ListNode node = head;
        int i = 1;
        while (i <= right) {
            ListNode next = node.next;
            if (i == left - 1) {
                vHead = node;
            } else if (i == left) {
                pre = node;
            } else if (i > left) {
                ListNode vNext = vHead.next;
                vHead.next = node;
                node.next = vNext;

                pre.next = next;
            }
            node = next;
            i ++;
        }
        return nNode.next;
    }
}
