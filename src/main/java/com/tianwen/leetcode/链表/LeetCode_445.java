package com.tianwen.leetcode.链表;

import com.tianwen.data.structure.ListNode;

import java.util.Objects;

/**
 * @Author: wangjq
 * @Date: 2022年03月29日 11:52
 */
public class LeetCode_445 {

    /**
     *
     //输入：l1 = [7,2,4,3], l2 = [5,6,4]
     //输出：[7,8,0,7]
     */
    public static void main(String[] args) {
        LeetCode_445 leetCode_445 = new LeetCode_445();
//        ListNode l1 = new ListNode(7, new ListNode(2, new ListNode(4, new ListNode(3))));
//        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
//        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
//        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2, new ListNode(1));
        ListNode node = leetCode_445.addTwoNumbers(l1, l2);
        System.out.println(ListNode.listVal(node));
    }

    int limit = 0;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (Objects.isNull(l1)) {
            return l2;
        } else if (Objects.isNull(l2)) {
            return l1;
        }
        int count1 = 0;
        int count2 = 0;
        ListNode countNode1 = l1;
        ListNode countNode2 = l2;
        while (Objects.nonNull(countNode1) || Objects.nonNull(countNode2)) {
            if (Objects.nonNull(countNode1)) {
                countNode1 = countNode1.next;
                count1 ++;
            }
            if (Objects.nonNull(countNode2)) {
                countNode2 = countNode2.next;
                count2 ++;
            }
        }
        limit = Math.abs(count1 - count2);
        ListNode nodeLong = count1 >= count2 ? l1 : l2;
        ListNode nodeShort = count1 >= count2 ? l2 : l1;
        ListNode node = new ListNode();
        int add = recur(nodeLong, nodeShort, node, 1);
        if (add > 0) {
            ListNode pre = new ListNode();
            pre.val = add;
            pre.next = node;
            return pre;
        }
        return node;
    }

    private int recur(ListNode nodeLong, ListNode nodeShort, ListNode node, int i) {
        if (Objects.isNull(nodeLong) && Objects.isNull(nodeShort)) {
            return 0;
        }
        ListNode next = new ListNode();
        int sum = 0;
        sum += nodeLong.val;
        if (i > limit) {
            sum += nodeShort.val;
        }
        int add = recur(nodeLong.next, i ++ > limit ? nodeShort.next : nodeShort, next, i);
        sum += add;

        int curAdd = sum / 10;
        int val = sum % 10;
        node.val = val;
        if (Objects.nonNull(nodeLong.next) || Objects.nonNull(nodeShort.next)) {
            node.next = next;
        }
        return curAdd;
    }
}
