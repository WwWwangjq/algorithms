package com.tianwen.algorithms;

import com.tianwen.data.structure.TreeNode;

import java.util.Objects;

/**
 * wangjq
 * 2020年12月17日  23:24
 */
public class Algorithms27_TreeNode_Mirror {

    /**
     * 输入一颗二叉树 输出它的镜像
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode8 = new TreeNode(8, null, treeNode9);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode6 = new TreeNode(6, null, treeNode7);
        TreeNode treeNode5 = new TreeNode(5, null, treeNode6);
        TreeNode treeNode4 = new TreeNode(4, null, treeNode8);
        TreeNode treeNode3 = new TreeNode(3, treeNode4, treeNode5);
        TreeNode treeNode2 = new TreeNode(2, null, treeNode3);
        TreeNode treeNode1 = new TreeNode(1, treeNode2, null);

        TreeNode treeNode103= new TreeNode(9);
        TreeNode treeNode102 = new TreeNode(8, null, treeNode103);
        TreeNode treeNode101 = new TreeNode(4, null, treeNode102);

        TreeNode b = treeNode101;
        TreeNode mirrorTree = mirrorTree(b);
        System.out.println(mirrorTree);

    }

    public static TreeNode mirrorTree(TreeNode root) {
        if (Objects.isNull(root)) {
            return null;
        }
        TreeNode mirror = new TreeNode(root.val);
        mirror(root, mirror);
        return mirror;
    }

    private static void mirror(TreeNode node, TreeNode mirror) {
        if (Objects.isNull(node)) {
            return;
        }
        if (Objects.nonNull(node.left)) {
            mirror.right = new TreeNode(node.left.val);
            mirror(node.left, mirror.right);
        }
        if (Objects.nonNull(node.right)) {
            mirror.left = new TreeNode(node.right.val);
            mirror(node.right, mirror.left);
        }
    }
}
