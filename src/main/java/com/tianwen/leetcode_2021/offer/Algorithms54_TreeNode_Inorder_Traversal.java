package com.tianwen.leetcode_2021.offer;

import com.tianwen.data.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * wangjq
 * 2021年01月01日  19:48
 */
public class Algorithms54_TreeNode_Inorder_Traversal {

    public static void main(String[] args) {
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(1, null, treeNode2);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(3, treeNode1, treeNode4);
        System.out.println(kthLargest(treeNode3, 1));
    }

    public static int kthLargest(TreeNode root, int k) {
        if (root == null || k == 0) {
            return 0;
        }
        List<Integer> valList = new ArrayList<>();
        inorder(root, valList);
        return valList.size() < k ? 0 : valList.get(valList.size() - k);
    }

    private static void inorder(TreeNode root, List<Integer> valList) {
        if (root == null) {
            return;
        }
        inorder(root.left, valList);
        valList.add(root.val);
        inorder(root.right, valList);
    }
}
