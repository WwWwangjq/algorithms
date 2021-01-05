package com.tianwen.algorithms;

import com.tianwen.data.structure.ListNode;

/**
 * wangjq
 * 2021年01月01日  15:48
 */
public class Algorithms52_ListNode_Intersection_Node {

    public static void main(String[] args) {
        int abs = Math.abs(1 - 4);
        System.out.println(abs);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int countA = getLength(headA);
        int countB = getLength(headB);
        int abs = Math.abs(countB - countA);
        ListNode nA = headA;
        ListNode nB = headB;
        while (abs != 0) {
            if (countA > countB) {
                nA = nA.next;
            } else {
                nB = nB.next;
            }
            abs--;
        }
        while (nA != null) {
            if (nA == nB) {
                return nA;
            }
            nA = nA.next;
            nB = nB.next;
        }
        return null;
    }

    private static int getLength(ListNode node) {
        int i = 0;
        while (node != null) {
            i ++;
            node = node.next;
        }
        return i;
    }
}
