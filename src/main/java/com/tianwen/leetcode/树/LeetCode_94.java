package com.tianwen.leetcode.树;

import com.tianwen.data.structure.TreeNode;

import java.util.*;

/**
 * wangjq
 * 2021年04月06日  23:01
 */
public class LeetCode_94 {

    // 给定一个二叉树的根节点 root ，返回它的 中序 遍历。


/*    public List<Integer> inorderTraversal(TreeNode root) {
        if (Objects.isNull(root)) {
            return Collections.emptyList();
        }
        List<Integer> resultList = new ArrayList<>();
        collect(root, resultList);
        return resultList;
    }

    private void collect(TreeNode root, List<Integer> resultList) {
        if (Objects.isNull(root)) {
            return;
        }
        collect(root.left, resultList);
        resultList.add(root.val);
        collect(root.right, resultList);
    }*/


    public List<Integer> inorderTraversal(TreeNode root) {
        if (Objects.isNull(root)) {
            return Collections.emptyList();
        }
        List<Integer> resultList = new ArrayList<>();
        LinkedList<TreeNode> treeList = new LinkedList<>();
        while (Objects.nonNull(root) || !treeList.isEmpty()) {
            while (Objects.nonNull(root)) {
                treeList.push(root);
                root = root.left;
            }
            TreeNode pop = treeList.pop();
            resultList.add(pop.val);
            root = pop.right;
        }
        return resultList;
    }
}
