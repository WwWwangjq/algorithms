package com.tianwen.leetcode_2022.链表;

import com.tianwen.data.structure.ListNode;

import java.util.Objects;

/**
 * wangjq
 * 2022年03月27日  10:50
 */
public class LeetCode_147 {

    /**
     * //输入: head = [4,2,1,3]
     * //输出: [1,2,3,4]
     * //
     * // 示例 2：
     * //
     * //
     * //
     * //
     * //输入: head = [-1,5,3,4,0]
     * //输出: [-1,0,3,4,5]
     */
    public static void main(String[] args) {
        LeetCode_147 leetCode_147 = new LeetCode_147();
//        ListNode head = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
//        ListNode head = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3, new ListNode(1)))));
//        ListNode head = new ListNode(-1, new ListNode(5, new ListNode(3, new ListNode(4, new ListNode(0)))));
//        ListNode head = new ListNode(-1, new ListNode(5));
//        ListNode head = new ListNode(2, new ListNode(1));
        ListNode head = new ListNode(1);
        ListNode node = leetCode_147.insertionSortList(head);
        System.out.println(ListNode.listVal(node));
    }

    public ListNode insertionSortList(ListNode head) {
        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return head;
        }
        ListNode rightPre = new ListNode();
        rightPre.next = head;
        ListNode right = head;
        int i = 0;
        while (Objects.nonNull(right)) {
            ListNode rNext = right.next;
            ListNode leftPre = new ListNode();
            leftPre.next = head;
            ListNode left = head;
            int j = 0;
            ListNode rightPreNext = null;
            while (j < i) {
                // insert
                if (left.val > right.val) {
                    rightPre.next = right.next;
                    leftPre.next = right;
                    right.next = left;
                    rightPreNext = rightPre;
                    if (j == 0) {
                        head = leftPre.next;
                    }
                    break;
                }
                leftPre = leftPre.next;
                left = left.next;
                j ++;
            }
            rightPre = Objects.nonNull(rightPreNext) ? rightPre : rightPre.next;
            right = rNext;
            i ++;
        }
        return head;
    }
}
