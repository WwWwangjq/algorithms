package com.tianwen.leetcode.tree;

import com.tianwen.data.structure.TreeNode;

import java.util.Objects;

/**
 * @Author: wangjq
 * @Date: 2021年04月12日 16:44
 */
public class LeetCode_112 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (Objects.isNull(root)) {
            return false;
        }
        return hasPathSum(root, targetSum, 0);
    }

    private boolean hasPathSum(TreeNode root, int targetSum, int curSum) {
        if (Objects.isNull(root)) {
            return false;
        }
        curSum += root.val;
        if (Objects.isNull(root.left) && Objects.isNull(root.right)) {
            return curSum == targetSum;
        }
        return hasPathSum(root.left, targetSum, curSum) || hasPathSum(root.right, targetSum, curSum);
    }
}
