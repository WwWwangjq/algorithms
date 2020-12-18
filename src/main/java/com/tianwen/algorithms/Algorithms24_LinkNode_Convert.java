package com.tianwen.algorithms;

import com.tianwen.data.structure.ListNode;

/**
 * wangjq
 * 2020年12月15日  23:14
 */
public class Algorithms24_LinkNode_Convert {

    /**
     * 反转链表
     * 定义一个函数 输入一个链表的头节点 反转该链表并输出反转后链表的头节点
     * @param args
     */
    public static void main(String[] args) {
        ListNode n9 = new ListNode(9);
        ListNode n8 = new ListNode(8, n9);
        ListNode n7 = new ListNode(7, n8);
        ListNode n6 = new ListNode(6, n7);
        ListNode n5 = new ListNode(5, n6);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);

        ListNode head = n1;
        ListNode reverseHead = reverseList(head);
        System.out.println(reverseHead);
    }

    private static ListNode reverseList(ListNode head) {
        ForSaveConvertNode save = new ForSaveConvertNode();
        reverseList(head, save);
        return save.node;
    }

    private static void reverseList(ListNode node, ForSaveConvertNode save) {
        if (node == null) {
            return;
        }
        if (node.next == null) {
            save.node = node;
            return;
        }
        reverseList(node.next, save);
        node.next.next = node;
        node.next = null;
    }

    static class ForSaveConvertNode {
        ListNode node;

        public ForSaveConvertNode() {}
    }
}
