package com.tianwen.leetcode;

import com.tianwen.data.structure.TreeNode;

import java.util.*;

/**
 * @Author: wangjq
 * @Date: 2021年04月14日 17:23
 */
public class LeetCode_199 {

    public List<Integer> rightSideView(TreeNode root) {
        if (Objects.isNull(root)) {
            return Collections.emptyList();
        }
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.addFirst(root);
        List<Integer> result = new ArrayList<>();
        while (!treeNodes.isEmpty()) {
            int size = treeNodes.size();
            while (size > 0) {
                TreeNode treeNode = treeNodes.removeFirst();
                if (Objects.nonNull(treeNode.left)) {
                    treeNodes.addLast(treeNode.left);
                }
                if (Objects.nonNull(treeNode.right)) {
                    treeNodes.addLast(treeNode.right);
                }
                size --;
                if (size == 0) {
                    result.add(treeNode.val);
                }
            }
        }
        return result;
    }
}
