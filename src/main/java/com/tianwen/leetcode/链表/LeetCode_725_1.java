package com.tianwen.leetcode.链表;

import com.tianwen.data.structure.ListNode;

import java.util.Objects;

/**
 * wangjq
 * 2022年03月29日  20:15
 */
public class LeetCode_725_1 {

    public static void main(String[] args) {
//        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(1))))))))));
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        int k = 2;
//        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));
//        int k = 5;
        LeetCode_725_1 leetCode_725 = new LeetCode_725_1();
        ListNode[] listNodeArr = leetCode_725.splitListToParts(head, k);
        System.out.println(ListNode.listVal(listNodeArr));
    }

    public ListNode[] splitListToParts(ListNode head, int k) {
        if (Objects.isNull(head) || k == 0) {
            return new ListNode[0];
        }
        ListNode countNode = head;
        int count = 0;
        while (Objects.nonNull(countNode)) {
            countNode = countNode.next;
            count ++;
        }

        // 初始化数组容量
        int length = count / k;
        int mod = count % k;
        int[] lengthArr = new int[k];
        for (int i = 0; i < k; i ++) {
            int l = length;
            if (mod > 0) {
                l += 1;
                mod --;
            }
            lengthArr[i] = l;
        }
        // 填充数组
        ListNode[] result = new ListNode[k];
        int i = 0;
        ListNode sHead;
        ListNode node = head;
        while (Objects.nonNull(node)) {
            int l = lengthArr[i];
            sHead = node;
            result[i] = sHead;
            while (l > 1) {
                node = node.next;
                l --;
            }
            ListNode rNext = node.next;
            node.next = null;
            node = rNext;
            i ++;
        }
        return result;
    }
}
