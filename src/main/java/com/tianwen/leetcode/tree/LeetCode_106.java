package com.tianwen.leetcode.tree;

import com.tianwen.data.structure.TreeNode;

import java.util.Objects;

/**
 * wangjq
 * 2021年04月10日  18:49
 */
public class LeetCode_106 {

    public TreeNode buildTree(int[] postorder, int[] inorder) {
        TreeNode root = new TreeNode();
        buildTree(postorder, inorder, root, true);
        return root.left;
    }

    private void buildTree(int[] postorder, int[] inorder, TreeNode root, boolean isLeft) {
        if (Objects.isNull(postorder) || postorder.length == 0) {
            return;
        }
        int rootVal = postorder[postorder.length - 1];
        TreeNode node = new TreeNode(rootVal);
        if (isLeft) {
            root.left = node;
        } else {
            root.right = node;
        }

        int sub = getSub(inorder, rootVal);
        int rightSize = inorder.length - sub - 1;

        int[] inLeft = new int[sub];
        int[] inRight = new int[rightSize];

        int[] postLeft = new int[sub];
        int[] postRight = new int[rightSize];

        int i = 0, j = 0, m = 0, n = 0;
        for (int k = 0; k < inorder.length; k ++) {
            int ik = inorder[k];
            int pk = postorder[k];
            if (k < sub) {
                inLeft[i ++] = ik;
            } else if (k > sub) {
                inRight[j ++] = ik;
            }
            if (k < sub) {
                postLeft[m++] = pk;
            } else if (k < inorder.length - 1) {
                postRight[n++] = pk;
            }
        }

        buildTree(postLeft, inLeft, node, true);
        buildTree(postRight, inRight, node, false);
    }

    private int getSub(int[] arr, int val) {
        int i = 0;
        for (int a : arr) {
            if (a == val) {
                return i;
            }
            i ++;
        }
        return 0;
    }
}
