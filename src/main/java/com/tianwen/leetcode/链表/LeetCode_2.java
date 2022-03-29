package com.tianwen.leetcode.链表;

import com.tianwen.data.structure.ListNode;

import java.util.Objects;

/**
 * //输入：l1 = [2,4,3], l2 = [5,6,4]
 * //输出：[7,0,8]
 * //解释：342 + 465 = 807.
 * @Author: wangjq
 * @Date: 2022年03月22日 15:14
 */
public class LeetCode_2 {

    public static void main(String[] args) {
        LeetCode_2 leetCode_2 = new LeetCode_2();
        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        /*ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));*/

        ListNode listNode = leetCode_2.addTwoNumbers(l1, l2);
        System.out.println(ListNode.listVal(listNode));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (Objects.isNull(l1)) {
            return l2;
        } else if (Objects.isNull(l2)) {
            return l1;
        }
        boolean nonEnd1 = true;
        boolean nonEnd2 = true;
        ListNode node1 = l1;
        ListNode node2 = l2;
        int add = 0;
        ListNode head = new ListNode(0);
        ListNode pre = head;
        while (nonEnd1 || nonEnd2) {
            int curSum = add;
            if (Objects.nonNull(node1)) {
                curSum += node1.val;
                node1 = node1.next;
                if (Objects.isNull(node1)) {
                    nonEnd1 = false;
                }
            }
            if (Objects.nonNull(node2)) {
                curSum += node2.val;
                node2 = node2.next;
                if (Objects.isNull(node2)) {
                    nonEnd2 = false;
                }
            }
            int val = curSum % 10;
            add = curSum / 10;
            pre.next = new ListNode(val);
            pre = pre.next;
        }
        if (add != 0) {
            pre.next = new ListNode(add);
        }
        return head.next;
    }
}
