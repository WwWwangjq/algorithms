package com.tianwen.algorithms;

import com.tianwen.data.structure.TreeNode;
import sun.dc.pr.PRError;

/**
 * wangjq
 * 2021年01月03日  23:52
 */
public class Algorithms68_1_Lowest_Common_Ancestor {

    public static void main(String[] args) {
/*        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode4 = new TreeNode(4, treeNode3, treeNode5);
        TreeNode treeNode0 = new TreeNode(0);
        TreeNode treeNode8 = new TreeNode(8, treeNode7, treeNode9);
        TreeNode treeNode2 = new TreeNode(2, treeNode0, treeNode4);
        TreeNode treeNode6 = new TreeNode(6, treeNode2, treeNode8);
        TreeNode root = treeNode6;
//        TreeNode p = treeNode2;
//        TreeNode q = treeNode8;
        TreeNode p = treeNode9;
        TreeNode q = treeNode2;*/

        TreeNode treeNode5 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(1, null, treeNode5);
        TreeNode root = treeNode3;
//        TreeNode p = treeNode2;
//        TreeNode q = treeNode8;
        TreeNode p = treeNode5;
        TreeNode q = treeNode3;
        TreeNode treeNode = lowestCommonAncestor(root, p, q);
        System.out.println(treeNode);
    }

    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        return collect(root, q, p);
    }

    private static TreeNode collect(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val) {
            return collect(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return collect(root.right, p, q);
        } else {
            return root;
        }
    }
}
