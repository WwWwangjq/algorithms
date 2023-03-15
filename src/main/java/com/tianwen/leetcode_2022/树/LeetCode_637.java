package com.tianwen.leetcode_2022.树;

import com.tianwen.data.structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * wangjq
 * 2022年04月27日  21:45
 */
public class LeetCode_637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> resultList = new ArrayList<>();
        LinkedList<TreeNode> list = new LinkedList<>();
        list.addFirst(root);
        while (!list.isEmpty()) {
            int size = list.size();
            long sum = 0;
            for (int i = 0; i < size; i ++) {
                TreeNode treeNode = list.removeFirst();
                sum += treeNode.val;
                if (Objects.nonNull(treeNode.left)) {
                    list.addLast(treeNode.left);
                }
                if (Objects.nonNull(treeNode.right)) {
                    list.addLast(treeNode.right);
                }
            }
            resultList.add((double) sum / (double) size);
        }
        return resultList;
    }
}
