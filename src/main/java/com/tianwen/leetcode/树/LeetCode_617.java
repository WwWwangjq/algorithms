package com.tianwen.leetcode.树;

import com.tianwen.data.structure.TreeNode;

import java.util.Objects;

/**
 * wangjq
 * 2022年04月26日  23:03
 */
public class LeetCode_617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (Objects.isNull(root1) && Objects.isNull(root2)) {
            return null;
        } else if (Objects.isNull(root1)) {
            return root2;
        } else if (Objects.isNull(root2)) {
            return root1;
        } else {
            recur(root1, root2);
            return root1;
        }
    }

    private void recur(TreeNode root1, TreeNode root2) {
        int sum = root1.val + root2.val;
        root1.val = sum;
        root2.val = sum;
        if (Objects.nonNull(root1.left) && Objects.nonNull(root2.left)) {
            recur(root1.left, root2.left);
        } else if (Objects.nonNull(root1.left)) {
            root2.left = root1.left;
        } else if (Objects.nonNull(root2.left)) {
            root1.left = root2.left;
        }
        if (Objects.nonNull(root1.right) && Objects.nonNull(root2.right)) {
            recur(root1.right, root2.right);
        } else if (Objects.nonNull(root1.right)) {
            root2.right = root1.right;
        } else if (Objects.nonNull(root2.right)) {
            root1.right = root2.right;
        }
    }
}
