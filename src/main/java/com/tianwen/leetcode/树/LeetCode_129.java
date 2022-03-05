package com.tianwen.leetcode.树;

import com.tianwen.data.structure.TreeNode;

import java.util.Objects;

/**
 * @Author: wangjq
 * @Date: 2021年04月14日 14:13
 */
public class LeetCode_129 {
    public static void main(String[] args) {
        LeetCode_129 leetCode_129 = new LeetCode_129();
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        System.out.println(leetCode_129.sumNumbers(treeNode1));
    }

    private int sum;

    public int sumNumbers(TreeNode root) {
        sumNumbers(root, 0);
        return sum;
    }

    private void sumNumbers(TreeNode root, int curVal) {
        if (Objects.isNull(root)) {
            return;
        }
        if (Objects.isNull(root.left) && Objects.isNull(root.right)) {
            sum += curVal * 10 + root.val;
            return;
        }
        sumNumbers(root.left, curVal * 10 + root.val);
        sumNumbers(root.right, curVal * 10 + root.val);
    }
}
