package com.tianwen.offer;

import com.tianwen.data.structure.TreeNode2;

import java.util.Objects;

/**
 * wangjq
 * 2020年11月07日  17:52
 */
public class Algorithms8_TreeNode2 {

    static TreeNode2 A = new TreeNode2("a");
    static TreeNode2 B = new TreeNode2("b");
    static TreeNode2 C = new TreeNode2("c");
    static TreeNode2 D = new TreeNode2("d");
    static TreeNode2 E = new TreeNode2("e");
    static TreeNode2 F = new TreeNode2("f");
    static TreeNode2 G = new TreeNode2("g");
    static TreeNode2 H = new TreeNode2("h");
    static TreeNode2 I = new TreeNode2("i");

    static {
        A.left = B;
        A.right = C;
        B.parent = A;
        B.left = D;
        B.right = E;
        C.parent = A;
        C.left = F;
        C.right = G;
        D.parent = B;
        E.parent = B;
        E.left = H;
        E.right = I;
        F.parent = C;
        G.parent = C;
        H.parent = E;
        I.parent = E;
    }

    /**
     * 二叉树的
     * 有一个中序遍历的结果
     * 输入一个中序遍历的节点 找到他后面的下一个节点
     */
    public static void main(String[] args) {
        TreeNode2 treeNode = I;
        TreeNode2 nextNode;
        if (Objects.isNull(treeNode)) {
            return;
        }
        if (Objects.nonNull(treeNode.right)) {
            nextNode = getLeftest(treeNode.right);
        } else if (treeNode.parent.left.equals(treeNode)) {
            nextNode = treeNode.parent;
        } else {
            //
            nextNode = getParentLeft(treeNode);
        }
        System.out.println(nextNode);
    }

    /** 如果无右节点 且它是父节点的左子节点 它的下一个节点就是父节点 */
    private static TreeNode2 getLeftest(TreeNode2 treeNode) {
        if (Objects.nonNull(treeNode) && Objects.nonNull(treeNode.left)) {
            return getLeftest(treeNode.left);
        }
        return treeNode;
    }

    /** 如果无右节点 且它是父节点的右子节点 要找它的父节点 并且它的父节点要是父节点的左子节点 这个节点才会是下一个节点（中序遍历的逻辑 先左再根再右） */
    private static TreeNode2 getParentLeft(TreeNode2 treeNode) {
        TreeNode2 parent = treeNode.parent;
        if (Objects.isNull(parent)) {
            return null;
        }
        if (Objects.nonNull(parent.left) && parent.left.equals(treeNode)) {
            return parent;
        }
        return getParentLeft(parent);
    }
}
