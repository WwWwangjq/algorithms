package com.tianwen.leetcode.tree;

import com.tianwen.data.structure.TreeNode;

import java.util.*;

/**
 * @Author: wangjq
 * @Date: 2021年04月14日 15:25
 */
public class LeetCode_145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        if (Objects.isNull(root)) {
            return Collections.emptyList();
        }
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.push(root);
        LinkedList<Integer> resultList = new LinkedList<>();
        while (!treeNodes.isEmpty()) {
            TreeNode treeNode = treeNodes.removeFirst();
            resultList.addFirst(treeNode.val);
            if (Objects.nonNull(treeNode.left)) {
                treeNodes.addFirst(treeNode.left);
            }
            if (Objects.nonNull(treeNode.right)) {
                treeNodes.addFirst(treeNode.right);
            }

        }
        return resultList;
    }
}
