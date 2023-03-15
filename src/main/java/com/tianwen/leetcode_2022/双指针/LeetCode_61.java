package com.tianwen.leetcode_2022.双指针;

import com.tianwen.data.structure.ListNode;

import java.util.Objects;

/**
 * wangjq
 * 2021年05月29日  15:18
 */
public class LeetCode_61 {

    //输入：head = [1,2,3,4,5], k = 2
    //输出：[4,5,1,2,3]

    //输入：head = [0,1,2], k = 4
    //输出：[2,0,1]
    public static void main(String[] args) {

        LeetCode_61 leetCode_61 = new LeetCode_61();
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

/*        ListNode head = node1;
        int k = 4;*/

        ListNode head = node3;
        int k = 200000;
        ListNode node = leetCode_61.rotateRight(head, k);
        System.out.println(node);
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (Objects.isNull(head)) {
            return null;
        }
        boolean again = true;
        ListNode newHead = null;
        while (again) {
             if (k == 0) {
                return head;
            }
            int length = 0;
            ListNode slow = new ListNode();
            slow.next = head;
            ListNode fast = head;
            int i = 1;
            ListNode pre = null;
            while (Objects.nonNull(fast)) {
                if (i > k) {
                    slow = slow.next;
                }
                if (Objects.isNull(fast.next)) {
                    pre = fast;
                }
                fast = fast.next;
                i ++;
                length ++;
            }
            if (k >= length) {
                k %= length;
                continue;
            }
            again = false;
            newHead = slow.next;
            slow.next = null;
            pre.next = head;
        }
        return newHead;
    }
}
