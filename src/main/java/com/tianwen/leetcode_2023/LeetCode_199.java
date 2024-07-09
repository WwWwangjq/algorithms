package com.tianwen.leetcode_2023;

import com.sun.org.apache.regexp.internal.RE;
import com.tianwen.data.structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @Author: wangjq
 * @Date: 2023年03月20日 21:00
 */
public class LeetCode_199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        if (Objects.isNull(root)) {
            return resultList;
        }
        LinkedList<TreeNode> nodeList = new LinkedList<>();
        nodeList.addFirst(root);
        resultList.add(root.val);
        while (!nodeList.isEmpty()) {
            boolean collect = false;
            int size = nodeList.size();
            for (int i = 0; i < size; i ++) {
                TreeNode node = nodeList.removeFirst();
                TreeNode right = node.right;
                if (Objects.nonNull(right)) {
                    nodeList.addLast(right);
                    if (!collect) {
                        resultList.add(right.val);
                        collect = true;
                    }
                }
                TreeNode left = node.left;
                if (Objects.nonNull(left)) {
                    nodeList.addLast(left);
                    if (!collect) {
                        resultList.add(left.val);
                        collect = true;
                    }
                }
            }
        }
        return resultList;
    }
}
