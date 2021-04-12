package com.tianwen.offer;

import com.tianwen.data.structure.ListNode;

import java.util.Objects;

/**
 * wangjq
 * 2020年12月16日  23:11
 */
public class Algorithms25_LinkNode_Merge_1 {

    /**
     * 合并链表 循环
     * @param args
     */
    public static void main(String[] args) {

        ListNode n7 = new ListNode(7);
        ListNode n6 = new ListNode(6, n7);
        ListNode n5 = new ListNode(5, n6);
        ListNode n3 = new ListNode(3, n5);
        ListNode n1 = new ListNode(1, n3);

        ListNode n9 = new ListNode(9);
        ListNode n8 = new ListNode(8, n9);
        ListNode n4 = new ListNode(4, n8);
        ListNode n2 = new ListNode(2, n4);

        ListNode l1 = n1;
        ListNode l2 = n2;
        System.out.println(n1);
        System.out.println(n2);
        ListNode listNode = mergeTwoLists(n1, n2);
        System.out.println(listNode);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode result = head;
        while (l1 != null || l2 != null) {
            ListNode temp = new ListNode();
            if (Objects.nonNull(l1) && Objects.nonNull(l2)) {
                if (isLess(l1, l2)) {
                    temp.val = l1.val;
                    result.next = temp;
                    l1 = l1.next;
                } else {
                    temp.val = l2.val;
                    result.next = temp;
                    l2 = l2.next;
                }
            } else if (Objects.nonNull(l1)) {
                temp.val = l1.val;
                result.next = temp;
                l1 = l1.next;
            } else {
                temp.val = l2.val;
                result.next = temp;
                l2 = l2.next;
            }
            result = result.next;
        }
        return head.next;
    }

    private static boolean isLess(ListNode n1, ListNode n2) {
        return n1.val < n2.val;
    }
}
