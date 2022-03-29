package com.tianwen.leetcode.链表;

import com.tianwen.data.structure.ListNode;

import java.util.Objects;

/**
 * //输入：head = [1,2,3,4]
 * //输出：[2,1,4,3]
 * 不修改节点内部值
 * @Author: wangjq
 * @Date: 2022年03月23日 10:39
 */
public class LeetCode_24 {

    public static void main(String[] args) {
        LeetCode_24 leetCode_24 = new LeetCode_24();
//        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
//        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode head = null;
        ListNode node = leetCode_24.swapPairs(head);
        System.out.println(ListNode.listVal(node));
    }

    public ListNode swapPairs(ListNode head) {
        int count = 1;
        boolean odd;
        ListNode preNode = new ListNode(0, head);
        ListNode nHead = preNode;
        ListNode oddNode = null;
        ListNode evenNode = null;
        ListNode node = head;
        while (Objects.nonNull(node)) {
            odd = (count & 1) == 1;
            if (odd) {
                oddNode = node;
            } else {
                evenNode = node;
            }
            node = node.next;
            count ++;
            if (!odd) {
                // swap
                oddNode.next = evenNode.next;
                evenNode.next = oddNode;
                preNode.next = evenNode;
                preNode = oddNode;
            }
        }
        return nHead.next;
    }
}
