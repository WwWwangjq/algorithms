package com.tianwen.leetcode_2021.offer;

import com.tianwen.data.structure.TreeNode;

/**
 * wangjq
 * 2021年01月01日  20:19
 */
public class Algorithms55_2_TreeNode_Is_Balanced {

    public static void main(String[] args) {

    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean[] isBalanced = new boolean[1];
        isBalanced[0] = true;
        postorder(root, 0, isBalanced);
        return isBalanced[0];
    }

    private static int postorder(TreeNode root, int curPathL, boolean[] isBalanced) {
        if (root == null) {
            return curPathL;
        }
        curPathL += 1;
        int leftDepth = postorder(root.left, curPathL, isBalanced);
        int rightDepth = postorder(root.right, curPathL, isBalanced);
        if (Math.abs(rightDepth - leftDepth) > 1) {
            isBalanced[0] = false;
        }
        return Math.max(leftDepth, rightDepth);
    }
}
