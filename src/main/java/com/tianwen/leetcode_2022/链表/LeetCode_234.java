package com.tianwen.leetcode_2022.链表;

import com.tianwen.data.structure.ListNode;

import java.util.Objects;

/**
 * @Author: wangjq
 * @Date: 2022年03月28日 10:42
 */
public class LeetCode_234 {

    public static void main(String[] args) {
        LeetCode_234 leetCode_234 = new LeetCode_234();
//        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(1)))))));
//        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(2, new ListNode(1))))));
//        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(2, new ListNode(1))))));
//        ListNode head = new ListNode(1, new ListNode(2));
//        ListNode head = new ListNode(1, new ListNode(1));
//        ListNode head = new ListNode(1, new ListNode(2, new ListNode(1)));
        ListNode head = new ListNode(1);
        System.out.println(leetCode_234.isPalindrome(head));
    }

    public boolean isPalindrome(ListNode head) {
        if (Objects.isNull(head)) {
            return false;
        } else if (Objects.isNull(head.next)) {
            return true;
        }
        ListNode countNode = head;
        int count = 0;
        while (Objects.nonNull(countNode)) {
            countNode = countNode.next;
            count ++;
        }
        ListNode fPre = new ListNode();
        fPre.next = head;

        ListNode next = head.next;
        int i = 2;
        while (i <= (count / 2)) {
            ListNode rNext = next.next;

            // reverse
            head.next = next.next;
            ListNode leftFirst = fPre.next;
            fPre.next = next;
            next.next = leftFirst;

            if (i == (count / 2)) {
                head.next = null;
            }
            next = rNext;
            i ++;
        }

        ListNode leftHead = fPre.next;
        ListNode rightHead = (count & 1) == 1 ? next.next : next;
        while (Objects.nonNull(rightHead)) {
            if (leftHead.val != rightHead.val) {
                return false;
            }
            leftHead = leftHead.next;
            rightHead = rightHead.next;

        }
        return true;
    }
}
