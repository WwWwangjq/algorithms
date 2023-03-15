package com.tianwen.leetcode_2022.树;

import com.tianwen.data.structure.TreeNode;

import java.util.Objects;

/**
 * wangjq
 * 2022年04月21日  21:21
 */
public class LeetCode_543 {
    /**
     *
     // 示例 :
     //给定二叉树
     //
     //           1
     //         / \
     //        2   3
     //       / \
     //      4   5
     //
     //
     // 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
     * @param args
     */

    public int diameterOfBinaryTree(TreeNode root) {
        recur(root);
        return result;
    }

    private int result;

    private int recur(TreeNode node) {
        if (Objects.isNull(node)) {
            return 0;
        }

        int left = recur(node.left);
        int right = recur(node.right);
        result =  Math.max(left + right, result);
        return Math.max(left, right) + 1;
    }
}
