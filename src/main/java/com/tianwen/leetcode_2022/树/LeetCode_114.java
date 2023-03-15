package com.tianwen.leetcode_2022.树;

import com.tianwen.data.structure.TreeNode;

import java.util.Objects;

/**
 * wangjq
 * 2021年04月13日  20:02
 */
public class LeetCode_114 {

    public void flatten(TreeNode root) {
        flatten(root, new TreeNode());
    }

    private TreeNode flatten(TreeNode root, TreeNode pre) {
        if (Objects.isNull(root)) {
            return pre;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        pre.left = null;
        pre.right = root;
        return flatten(right, flatten(left, root));
    }
}
