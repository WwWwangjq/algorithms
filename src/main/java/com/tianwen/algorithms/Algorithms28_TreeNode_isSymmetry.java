package com.tianwen.algorithms;

import com.tianwen.data.structure.TreeNode;

import java.util.Objects;

/**
 * wangjq
 * 2020年12月18日  20:21
 */
public class Algorithms28_TreeNode_isSymmetry {

    /**
     * 判断一颗二叉树是否对称
     * 一棵树和它的镜像一样，那么它是对称的
     * @param args
     */
    public static void main(String[] args) {

    }

    private static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private static boolean isSymmetric(TreeNode left, TreeNode right) {
        if (Objects.isNull(left) && Objects.isNull(right)) {
            return true;
        } else if (Objects.isNull(left) || Objects.isNull(right)) {
            return false;
        } else {
            return left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
        }
    }

}
