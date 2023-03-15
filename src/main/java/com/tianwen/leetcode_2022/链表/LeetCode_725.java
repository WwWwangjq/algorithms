package com.tianwen.leetcode_2022.链表;

import com.tianwen.data.structure.ListNode;

import java.util.Objects;

/**
 * wangjq
 * 2022年03月29日  20:15
 */
public class LeetCode_725 {

    public static void main(String[] args) {
//        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(1))))))))));
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        int k = 6;
//        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));
//        int k = 5;
        LeetCode_725 leetCode_725 = new LeetCode_725();
        ListNode[] listNodeArr = leetCode_725.splitListToParts(head, k);
        System.out.println(ListNode.listVal(listNodeArr));
    }

    public ListNode[] splitListToParts(ListNode head, int k) {
        if (Objects.isNull(head) || k == 0) {
            return new ListNode[k];
        }
        ListNode countNode = head;
        int count = 0;
        while (Objects.nonNull(countNode)) {
            countNode = countNode.next;
            count ++;
        }
        ListNode[] result = new ListNode[k];
        ListNode node = head;
        int length = count / k;
        int i = 0;
        ListNode sHead;
        int j = 0;
        while (i < k * length) {
            ListNode rNext = node.next;
            if (i % length == 0) {
                sHead = node;
                result[j ++] = sHead;
            }
            if (i % length == length - 1) {
                node.next = null;
            }

            i ++;
            node = rNext;
        }
        // 如果有剩余 每个链表补一个
        int m = 0;
        while (Objects.nonNull(node)) {
            ListNode rNext = node.next;
            ListNode nd = result[m];
            if (Objects.isNull(nd)) {
                result[m] = node;
                result[m].next = null;
            } else {
                while (Objects.nonNull(nd.next)) {
                    nd = nd.next;
                }
                nd.next = node;
            }
            m ++;
            node = rNext;
        }
        return result;
    }
}
