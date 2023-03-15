package com.tianwen.leetcode_2022.双指针;

import com.tianwen.data.structure.ListNode;

import java.util.Objects;
import java.util.Optional;

/**
 * wangjq
 * 2021年05月23日  16:09
 */
public class LeetCode_19 {

    // 示例 1：
    //
    //
    //输入：head = [1,2,3,4,5], n = 2
    //输出：[1,2,3,5]
    //
    //
    // 示例 2：
    //
    //
    //输入：head = [1], n = 1
    //输出：[]
    //
    //
    // 示例 3：
    //
    //
    //输入：head = [1,2], n = 1
    //输出：[1]

    public static void main(String[] args) {
        LeetCode_19 leetCode_19 = new LeetCode_19();
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        ListNode head = node5;
        int n = 1;
        ListNode result = leetCode_19.removeNthFromEnd(head, n);
        System.out.println(result);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (Objects.isNull(head)) {
            return null;
        }
        ListNode fast = head;
        ListNode pre = new ListNode();
        pre.next = head;
        ListNode slow = pre;
        int i = 1;
        while (Objects.nonNull(fast)) {
            if (i > n) {
                slow = slow.next;
            }
            fast = fast.next;
            i ++;
        }
        slow.next = Optional.ofNullable(slow.next).orElse(new ListNode()).next;
        return pre.next;
    }
}
