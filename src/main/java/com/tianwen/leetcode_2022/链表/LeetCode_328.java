package com.tianwen.leetcode_2022.链表;

import com.tianwen.data.structure.ListNode;

import java.util.Objects;

/**
 * @Author: wangjq
 * @Date: 2022年03月28日 17:13
 */
public class LeetCode_328 {

    /**
     * //输入: head = [1,2,3,4,5]
     * //输出: [1,3,5,2,4]
     * //
     * //输入: head = [2,1,3,5,6,4,7]
     * //输出: [2,3,6,7,1,5,4]
     */
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
//        ListNode head = new ListNode(2, new ListNode(1, new ListNode(3, new ListNode(5, new ListNode(6, new ListNode(4, new ListNode(7)))))));
//        ListNode head = new ListNode(2);
//        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));
//        ListNode head = new ListNode(1, new ListNode(2));
//        ListNode head = new ListNode(1, new ListNode(2, new ListNode(1)));
//        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));
        LeetCode_328 leetCode_328 = new LeetCode_328();
        ListNode node = leetCode_328.oddEvenList(head);
        System.out.println(ListNode.listVal(node));
    }

    public ListNode oddEvenList(ListNode head) {
        if (Objects.isNull(head) || Objects.isNull(head.next) || Objects.isNull(head.next.next)) {
            return head;
        }
        ListNode lastNode = head;
        int count = 1;
        while (Objects.nonNull(lastNode.next)) {
            lastNode = lastNode.next;
            count ++;
        }

        ListNode pre = new ListNode();
        pre.next = head;
        ListNode node = head;
        int i = 1;
        while (i <= count) {
            ListNode next = node.next;
            // even move
            if ((i & 1) == 0) {
                pre.next = node.next;
                node.next = null;
                lastNode.next = node;
                lastNode = lastNode.next;
            } else {
                // odd
                pre = pre.next;
            }
            i ++;
            node = next;
        }
        return head;
    }
}
