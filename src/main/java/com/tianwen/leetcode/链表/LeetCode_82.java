package com.tianwen.leetcode.链表;

import com.tianwen.data.structure.ListNode;
import sun.dc.pr.PRError;

import java.util.Objects;

/**
 *
 * //输入：head = [1,2,3,3,4,4,5]
 * //输出：[1,2,5]
 * //
 * //输入：head = [1,1,1,2,3]
 * //输出：[2,3]
 * @Author: wangjq
 * @Date: 2022年03月23日 17:22
 */
public class LeetCode_82 {

    public static void main(String[] args) {
        LeetCode_82 leetCode_82 = new LeetCode_82();;
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5)))))));
//        ListNode head = new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3)))));
//        ListNode head = new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(1)))))));
//        ListNode head = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4)))))));
//        ListNode head = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4)))))));
        ListNode node = leetCode_82.deleteDuplicates(head);
        System.out.println(ListNode.listVal(node));
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (Objects.isNull(head)) {
            return null;
        } else if (Objects.isNull(head.next)) {
            return head;
        }
        ListNode pre = new ListNode();
        ListNode rPre = pre;
        ListNode left = head;
        ListNode right = head.next;
        boolean repeat = false;
        while (Objects.nonNull(right)) {
            if (left.val == right.val) {
                repeat = true;
            }
            if (left.val != right.val) {
                if (!repeat) {
                    pre.next = left;
                    pre = pre.next;
                    pre.next = null;
                }
                if (Objects.isNull(right.next)) {
                    pre.next = right;
                    pre = pre.next;
                }
                left = right;
                repeat = false;
            }
            right = right.next;
        }
        return rPre.next;
    }
}
