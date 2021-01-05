package com.tianwen.algorithms;

import com.tianwen.data.structure.ListNode;

import java.util.List;

/**
 * wangjq
 * 2021年01月05日  11:42
 */
public class Algorithms18_2_Delete_One_Node {

    public static void main(String[] args) {

    }

    private static ListNode deleteNode(ListNode head, int val) {
        ListNode node = new ListNode();
        node.next = head;
        ListNode cur = node;
        while (cur != null) {
            ListNode next = cur.next;
            if (next != null && next.val == val) {
                cur.next = next.next;
            }
            cur = cur.next;
        }
        return node.next;
    }
}
