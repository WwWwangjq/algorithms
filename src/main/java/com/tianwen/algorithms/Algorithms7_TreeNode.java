package com.tianwen.algorithms;

import com.tianwen.data.structure.TreeNode;

import java.util.Objects;

/**
 * wangjq
 * 2020年11月07日  17:52
 */
public class Algorithms7_TreeNode {

    /**
     * 重建二叉树
     * 给出前序遍历 中序遍历的结果 重建二叉树
     * 都不包含重复数字
     * 前序:
     * ->    ↙
     *    →
     * 1 2 4 7 3 5 8 6
     * <p>
     * 中序:
     *          ↘
     * ->  ↗
     * 4 7 2 1 6 3 8 6
     * <p>
     * 后序:
     * ->  →   ↖
     */
    public static void main(String[] args) {
        int[] preorder = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
        int[] inorder = new int[]{4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode root = null;
        if (preorder.length > 0) {
            root = new TreeNode(preorder[0]);
            build(preorder, inorder, root);
        }
        System.out.println(root);
    }

    static void build(int[] preorder, int[] inorder, TreeNode root) {
        if (Objects.isNull(root)) {
            return;
        }
        // 前序第一个为树跟节点
        int rootValue = preorder[0];
        // 根节点在中序中的下表按
        int inRootSub = getInRootSub(rootValue, inorder);
        // 根据根节点下标 将中序划分为左子树、右子树两部分
        int[][] inLeftRightTree = getInLeftRightTree(inorder, inRootSub);
        int leftTreeLength = inLeftRightTree[0].length;
        int rightTreeLength = inLeftRightTree[1].length;
        // 根据左子树 右子树的长度 将前序划分为左子树、右子树两部分
        int[][] preLeftRightTree = getPreLeftRightTree(preorder, leftTreeLength, rightTreeLength);
        Integer leftRoot = preLeftRightTree[0].length > 0 ? preLeftRightTree[0][0] : null;
        Integer rightRoot = preLeftRightTree[1].length> 0 ? preLeftRightTree[1][0] : null;
        // 前序左子树第一节点为根的左节点
        root.left = Objects.nonNull(leftRoot) ? new TreeNode(leftRoot) : null;
        // 前序右子树第一节点为根的右节点
        root.right = Objects.nonNull(rightRoot) ? new TreeNode(rightRoot) : null;
        build(preLeftRightTree[0], inLeftRightTree[0], root.left);
        build(preLeftRightTree[1], inLeftRightTree[1], root.right);
    }

    // 找出根节点在中序遍历中的下标
    static int getInRootSub(int rootValue, int[] inorder) {
        int sub = 0;
        for (; sub < inorder.length; sub++) {
            if (inorder[sub] == rootValue) {
                break;
            }
        }
        return sub;
    }

    static int[][] getInLeftRightTree(int[] inorder, int sub) {
        int[] leftTree = new int[sub];
        int[] rightTree = new int[inorder.length - sub - 1];
        int leftTreeSub = 0;
        int rightTreeSub = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (i == sub) {
                continue;
            }
            if (i < sub) {
                leftTree[leftTreeSub++] = inorder[i];
            } else {
                rightTree[rightTreeSub++] = inorder[i];
            }
        }
        return new int[][]{leftTree, rightTree};
    }

    static int[][] getPreLeftRightTree(int[] preorder, int leftTreeLength, int rightTreeLength) {
        int length = preorder.length;
        int[] leftTree = new int[leftTreeLength];
        int[] rightTree = new int[rightTreeLength];
        int leftTreeSub = 0;
        int rightTreeSub = 0;
        for (int i = 1; i < length; i++) {
            if (i < leftTreeLength + 1) {
                leftTree[leftTreeSub++] = preorder[i];
            } else {
                rightTree[rightTreeSub++] = preorder[i];
            }
        }
        return new int[][]{leftTree, rightTree};
    }
}
