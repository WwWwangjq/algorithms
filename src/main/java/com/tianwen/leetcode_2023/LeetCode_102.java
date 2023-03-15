package com.tianwen.leetcode_2023;

import com.tianwen.data.structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @Author: wangjq
 * @Date: 2023年03月13日 8:14
 */
public class LeetCode_102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (Objects.isNull(root)) {
            return new ArrayList<>();
        }
        List<List<Integer>> resultList = new ArrayList<>();
        LinkedList<TreeNode> nodeList = new LinkedList<>();
        nodeList.addLast(root);
        while (!nodeList.isEmpty()) {
            int size = nodeList.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i ++) {
                TreeNode treeNode = nodeList.removeFirst();
                list.add(treeNode.val);
                if (Objects.nonNull(treeNode.left)) {
                    nodeList.addLast(treeNode.left);
                }
                if (Objects.nonNull(treeNode.right)) {
                    nodeList.addLast(treeNode.right);
                }
            }
            resultList.add(list);
        }
        return resultList;
    }
}
