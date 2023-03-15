package com.tianwen.leetcode_2023;

import com.tianwen.data.structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @Author: wangjq
 * @Date: 2023年03月14日 8:16
 */
public class LeetCode_103 {
    // 始终从左往右读
    // 奇数层 因为下一层要从右往左读数据 所以数据插入时总是先左后右 addFist
    // 偶数层 因为下一层要从左往右读数据 所以数据插入时总是先右后左 addFist
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (Objects.isNull(root)) {
            return resultList;
        }
        LinkedList<TreeNode> nodeList = new LinkedList<>();
        nodeList.add(root);
        int level = 1;
        while (!nodeList.isEmpty()) {
            int size = nodeList.size();
            boolean odd = (level & 1) == 1;
            LinkedList<TreeNode> nextLevelNodeList = new LinkedList<>();
            List<Integer> valueList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = nodeList.removeFirst();
                valueList.add(treeNode.val);
                if (odd) {
                    if (Objects.nonNull(treeNode.left)) {
                        nextLevelNodeList.addFirst(treeNode.left);
                    }
                    if (Objects.nonNull(treeNode.right)) {
                        nextLevelNodeList.addFirst(treeNode.right);
                    }
                } else {
                    if (Objects.nonNull(treeNode.right)) {
                        nextLevelNodeList.addFirst(treeNode.right);
                    }
                    if (Objects.nonNull(treeNode.left)) {
                        nextLevelNodeList.addFirst(treeNode.left);
                    }
                }
            }
            resultList.add(valueList);
            nodeList = nextLevelNodeList;
            level++;
        }

        return resultList;
    }
}
