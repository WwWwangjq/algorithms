package com.tianwen.leetcode_2023_11;

import com.tianwen.data.structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @Author: wangjq
 * @Date: 2023年11月24日 13:32
 */
public class LeetCode_102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (Objects.isNull(root)) {
            return new ArrayList<>();
        }
        List<List<Integer>> resultList = new ArrayList<>();
        LinkedList<TreeNode> nodeList = new LinkedList<>();
        nodeList.add(root);
        while (!nodeList.isEmpty()) {
            int size = nodeList.size();
            List<Integer> tempList = new ArrayList<>(size);
            for (int i = 0; i < size; i ++) {
                TreeNode treeNode = nodeList.removeFirst();
                tempList.add(treeNode.val);
                if (Objects.nonNull(treeNode.left)) {
                    nodeList.addLast(treeNode.left);
                }
                if (Objects.nonNull(treeNode.right)) {
                    nodeList.addLast(treeNode.right);
                }
            }
            resultList.add(tempList);
        }
        return resultList;
    }
}
