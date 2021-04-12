package com.tianwen.offer;

import com.tianwen.data.structure.TreeNode;

import java.util.Objects;

/**
 * wangjq
 * 2020年12月17日  23:24
 */
public class Algorithms26_TreeNode_Find_Child {

    /**
     * 输入两颗二叉树A和B 判断B是不是A的子结构
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

        TreeNode A = treeNode1;
        TreeNode B = treeNode101;
        System.out.println(isSubStructure(A, B));

    }

    private static boolean isSubStructure(TreeNode A, TreeNode B) {
        if (Objects.isNull(A) || Objects.isNull(B)) {
            return false;
        }
        return isSameRoot(A, B);
    }

    private static boolean isSameRoot(TreeNode a, TreeNode b) {
        if (Objects.isNull(a)) {
            return false;
        }
        if (a.val == b.val && isSameTree(a, b)) {
            return true;
        }
        return isSameRoot(a.left, b) || isSameRoot(a.right, b);
    }

    private static boolean isSameTree(TreeNode a, TreeNode b) {
        if (Objects.isNull(b)) {
            return true;
        } else if (Objects.isNull(a)) {
            return false;
        } else {
            return a.val == b.val && isSameTree(a.left, b.left) && isSameTree(a.right, b.right);
        }
    }
}
