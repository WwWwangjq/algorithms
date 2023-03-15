package com.tianwen.leetcode_2021.offer;

import com.tianwen.data.structure.ListNode;

import java.util.Arrays;
import java.util.Objects;

/**
 * wangjq
 * 2020年11月07日  17:52
 */
public class Algorithms6_LinkNode_print {

    /**
     * 自尾向头打印链表
     */
    public static void main(String[] args) {
        ListNode n5 = new ListNode(5);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);

        ListNode head = n5;
        int[] print = reversePrint(head);
        System.out.println(Arrays.toString(print));
    }

    private static int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[]{};
        }
        return print(head, 0);
    }

    static int[] print(ListNode node, int count) {
        int[] print;
        if (Objects.nonNull(node.next)) {
            print = print(node.next, count + 1);
        } else {
            print = new int[count + 1];
        }
        print[print.length - count - 1] = node.val;
        return print;
    }

}
