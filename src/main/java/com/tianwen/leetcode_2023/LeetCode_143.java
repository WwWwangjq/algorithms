package com.tianwen.leetcode_2023;

import com.tianwen.data.structure.ListNode;

import java.util.Objects;
import java.util.Stack;

/**
 * @Author: wangjq
 * @Date: 2023年03月19日 11:08
 */
public class LeetCode_143 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        LeetCode_143 leetCode143 = new LeetCode_143();
        leetCode143.reorderList(head);
    }
    public void reorderList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode node = head;
        while (Objects.nonNull(node)) {
            stack.add(node);
            node = node.next;
        }
        int size = stack.size();
        if (size < 3) {
            return;
        }
        ListNode left = head;
        ListNode right = stack.pop();
        ListNode rightPre = stack.pop();
        int i = 1;
        int limit = size >> 1;
        while (i <= limit) {
            rightPre.next = right.next;

            ListNode leftNext = left.next;
            left.next = right;
            right.next = leftNext;

            left = leftNext;
            right = rightPre;
            rightPre = stack.pop();
            i ++;
        }
    }
}
