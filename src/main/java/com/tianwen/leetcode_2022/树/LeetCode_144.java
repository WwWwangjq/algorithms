package com.tianwen.leetcode_2022.树;

import com.tianwen.data.structure.TreeNode;

import java.util.*;

/**
 * @Author: wangjq
 * @Date: 2021年04月14日 14:49
 */
public class LeetCode_144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        if (Objects.isNull(root)) {
            return Collections.emptyList();
        }
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.addFirst(root);
        List<Integer> resultList = new ArrayList<>();
        while (!treeNodes.isEmpty()) {
            TreeNode treeNode = treeNodes.removeFirst();
            resultList.add(treeNode.val);
            if (Objects.nonNull(treeNode.right)) {
                treeNodes.addFirst(treeNode.right);
            }
            if (Objects.nonNull(treeNode.left)) {
                treeNodes.addFirst(treeNode.left);
            }
        }
        return resultList;
    }
}
