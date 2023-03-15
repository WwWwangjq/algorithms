package com.tianwen.leetcode_2022.链表;

import com.tianwen.data.structure.ListNode;

import java.util.Objects;

/**
 *
 *
 //head = [1,2,3,4,5], left = 2, right = 4
 //[1,4,3,2,5]
 * @Author: wangjq
 * @Date: 2022年03月24日 10:38
 */
public class LeetCode_92 {

    public static void main(String[] args) {
        LeetCode_92 leetCode_92 = new LeetCode_92();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
//        ListNode head = new ListNode(5);
        int left = 1;
        int right = 4;
        ListNode result = leetCode_92.reverseBetween(head, left, right);
        System.out.println(ListNode.listVal(result));
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        } else if (left > right) {
            return null;
        }
        if (Objects.isNull(head)) {
            return null;
        } else if (Objects.isNull(head.next)) {
            return head;
        }

        ListNode fixPre = null;
        ListNode fixSuf = null;
        ListNode leftHead = null;
        ListNode pre = new ListNode();
        pre.next = head;
        ListNode preResult = new ListNode();
        preResult.next = head;
        int sub = 1;
        ListNode node = head;
        while (Objects.nonNull(node)) {
            ListNode rNode = node.next;
            if (left == sub) {
                fixPre = pre;
                fixSuf = node;
                leftHead = node;
            }
            // swap
            if (left < sub && sub <= right) {
                fixSuf.next = node.next;
                node.next = leftHead;
                fixPre.next = node;
                leftHead = node;
            }
            // end
            if (right == sub) {
                if (left == 1) {
                    return fixPre.next;
                }
                break;
            }
            sub ++;
            node = rNode;
            pre = pre.next;
        }
        return head;
    }
}
