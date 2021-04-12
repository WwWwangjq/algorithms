package com.tianwen.offer;

import com.tianwen.data.structure.ListNode;

/**
 * wangjq
 * 2020年12月13日  21:19
 */
public class Algorithms22_LinkNode_Last_K {


    /**
     * 链表中倒数第K个节点
     * 输入一个链表 输出该链表中倒数第K个节点
     * 本题从1开始计数 链表尾节点为倒数第一个
     * @param args
     */
    public static void main(String[] args) {
        ListNode n5 = new ListNode(5);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);
        ListNode head = n1;
        int k = 5;

        System.out.println(head);
        ListNode kNode = findK(head, k);
        System.out.println(kNode == null ? null : kNode.val);
    }

    private static ListNode findK(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int length = 1;
        ListNode fNode = head;
        ListNode sNode = head;
        while (fNode.next != null) {
            length ++;
            fNode = fNode.next;
            if (length > k) {
                sNode = sNode.next;
            }
        }
        if (k > length) {
            return null;
        }
        return sNode;
    }


}
