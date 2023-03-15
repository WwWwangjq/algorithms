package com.tianwen.leetcode_2022.树;

import com.tianwen.data.structure.TreeNode;

import java.util.Objects;

/**
 * wangjq
 * 2022年04月22日  21:22
 */
public class LeetCode_563 {

    public int findTilt(TreeNode root) {
        recur(root);
        return ans;
    }

    private int ans;

    /**
     * @param node
     * @return 下层节点和
     */
    private int recur(TreeNode node) {
        if (Objects.isNull(node)) {
            return 0;
        }
        int sumLeft = recur(node.left);
        int sumRight = recur(node.right);
        // 树左右节点差绝对值 相加
        ans += Math.abs(sumLeft - sumRight);
        return node.val + sumLeft + sumRight;
    }
}
