package com.tianwen.leetcode_2021.offer;

import com.tianwen.data.structure.TreeNode;

/**
 * wangjq
 * 2021年01月01日  20:09
 */
public class Algorithms55_1_TreeNode_Max_Depth {

    public static void main(String[] args) {

    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] maxPathL = new int[1];
        depth(root, 0, maxPathL);
        return maxPathL[0];
    }

    public static void depth(TreeNode root, int curPathL, int[] maxPathL) {
        if (root == null) {
            maxPathL[0] = Math.max(curPathL, maxPathL[0]);
            return;
        }
        curPathL += 1;
        depth(root.left, curPathL, maxPathL);
        depth(root.right, curPathL, maxPathL);
    }
}
