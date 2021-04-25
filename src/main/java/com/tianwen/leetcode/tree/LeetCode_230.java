package com.tianwen.leetcode.tree;

import com.tianwen.data.structure.TreeNode;

import java.util.LinkedList;
import java.util.Objects;

/**
 * wangjq
 * 2021年04月14日  21:23
 */
public class LeetCode_230 {

/*    private int i;

    public int kthSmallest(TreeNode root, int k) {
        int[] arr = new int[k];
        try {
            kthSmallest(root, arr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arr[k - 1];
    }

    private void kthSmallest(TreeNode root, int[] arr) {
        if (Objects.isNull(root)) {
            return;
        }
        kthSmallest(root.left, arr);
        arr[i ++] = root.val;
        kthSmallest(root.right, arr);
    }*/

    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        int i = 1;
        while (Objects.nonNull(root) || !linkedList.isEmpty()) {
            while (Objects.nonNull(root)) {
                linkedList.push(root);
                root = root.left;
            }
            TreeNode pop = linkedList.pop();
            if (i ++ == k) {
                return pop.val;
            }
            root = pop.right;
        }
        return 0;
    }

}
