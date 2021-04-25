package com.tianwen.leetcode.tree;

import com.tianwen.data.structure.TreeNode;

import java.util.Objects;

/**
 * wangjq
 * 2021年04月16日  20:35
 */
public class LeetCode_404 {

    public int sumOfLeftLeaves(TreeNode root) {
        sumOfLeftLeaves(root, false);
        return sum;
    }

    private int sum;

    private void sumOfLeftLeaves(TreeNode root, boolean isLeft) {
        if (Objects.isNull(root)) {
            return;
        }
        if (isLeft && Objects.isNull(root.left) && Objects.isNull(root.right)) {
            sum += root.val;
        }
        sumOfLeftLeaves(root.left, true);
        sumOfLeftLeaves(root.right, false);
    }
}
