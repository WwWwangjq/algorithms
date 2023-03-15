package com.tianwen.leetcode_2022.链表;

import com.tianwen.data.structure.ListNode;

import java.util.Objects;

/**
 * @Author: wangjq
 * @Date: 2022年03月28日 12:21
 */
public class LeetCode_237 {

    /**
     * //输入：head = [4,5,1,9], node = 5
     * //输出：[4,1,9]
     *
     //输入：head = [4,5,1,9], node = 1
     //输出：[4,5,9]
     */
    public void deleteNode(ListNode node) {
        if (Objects.isNull(node)) {
            return;
        }
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
    }
}
