package com.tianwen.leetcode_2022.树;

import com.tianwen.data.structure.TreeNode;

import java.util.Objects;

/**
 * wangjq
 * 2022年04月25日  23:04
 */
public class LeetCode_671 {

    public int findSecondMinimumValue(TreeNode root) {
        if (Objects.isNull(root)) {
            return result.intValue();
        }
        rootVal = root.val;
        recur(root);
        return result == Long.MAX_VALUE ? -1 : result.intValue();
    }

    private int rootVal;
    private Long result = Long.MAX_VALUE;

    private void recur(TreeNode node) {
        if (Objects.isNull(node)) {
            return;
        }
        if (node.val != rootVal) {
            result = Math.min(result, node.val);
        }
        recur(node.left);
        recur(node.right);
    }
}
