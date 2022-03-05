package com.tianwen.leetcode.树;

import com.tianwen.data.structure.TreeNode;

import java.util.Objects;

/**
 * @Author: wangjq
 * @Date: 2021年04月12日 11:21
 */
public class LeetCode_110 {

    public static void main(String[] args) {
        TreeNode treeNode0 = new TreeNode(0);

        LeetCode_110 leetCode_110 = new LeetCode_110();
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.right = treeNode2;
        treeNode2.right = treeNode3;
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        treeNode4.left = treeNode5;
        treeNode5.left = treeNode6;

        treeNode0.left = treeNode4;
        treeNode0.right = treeNode1;
        System.out.println(leetCode_110.isBalanced(treeNode0));
    }

    public boolean isBalanced(TreeNode root) {
        return isBalanced(root, new int[1]);
    }

    private boolean isBalanced(TreeNode root, int[] arr) {
        if (Objects.isNull(root)) {
            arr[0] = 0;
            return true;
        }
        int[] leftArr = new int[1];
        int[] rightArr = new int[1];
        if (!isBalanced(root.left, leftArr) || !isBalanced(root.right, rightArr)) {
            return false;
        }
        leftArr[0] += 1;
        rightArr[0] += 1;
        arr[0] = Math.max(rightArr[0], leftArr[0]);
        return Math.abs(leftArr[0] - rightArr[0]) <= 1;
    }
}
