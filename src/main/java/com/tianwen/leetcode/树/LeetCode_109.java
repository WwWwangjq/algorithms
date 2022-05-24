package com.tianwen.leetcode.树;

import com.tianwen.data.structure.ListNode;
import com.tianwen.data.structure.TreeNode;

import java.util.Objects;

/**
 * wangjq
 * 2022年04月24日  20:58
 */
public class LeetCode_109 {

    public TreeNode sortedListToBST(ListNode head) {
        rootHead = head;
        int length = 0;
        ListNode node = head;
        while (Objects.nonNull(node)) {
            length ++;
            node = node.next;
        }
        return recur(0, length - 1);
    }

    private ListNode rootHead;

    public TreeNode recur(Integer left, Integer right) {
        if (left > right) {
            return null;
        }
        int mid = (right + left + 1) >> 1;
        TreeNode root = new TreeNode();
        root.left = recur(left, mid - 1);
        root.val = rootHead.val;
        rootHead = rootHead.next;
        root.right = recur(mid + 1, right);
        return root;
    }
}
