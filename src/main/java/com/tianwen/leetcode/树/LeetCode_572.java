package com.tianwen.leetcode.树;

import com.tianwen.data.structure.TreeNode;

import java.util.LinkedList;
import java.util.Objects;

/**
 * wangjq
 * 2022年04月26日  22:26
 */
public class LeetCode_572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (Objects.isNull(root) && Objects.isNull(subRoot)) {
            return true;
        } else if (Objects.isNull(root) || Objects.isNull(subRoot)) {
            return false;
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            int size = list.size();
            for (int i = 0; i < size; i ++) {
                TreeNode treeNode = list.removeFirst();
                if (treeNode.val == subRoot.val && isEquals(treeNode, subRoot)) {
                    return true;
                }
                if (Objects.nonNull(treeNode.left)) {
                    list.addLast(treeNode.left);
                }
                if (Objects.nonNull(treeNode.right)) {
                    list.addLast(treeNode.right);
                }
            }

        }
        return false;
    }



    private boolean isEquals(TreeNode root1, TreeNode root2) {
        if (Objects.isNull(root1) && Objects.isNull(root2)) {
            return true;
        } else if (Objects.isNull(root1) || Objects.isNull(root2)) {
            return false;
        } else {
            return root1.val == root2.val && isEquals(root1.left, root2.left) && isEquals(root1.right, root2.right);
        }
    }
}
