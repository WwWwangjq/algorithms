package com.tianwen.leetcode.树;

import com.tianwen.data.structure.TreeNode;

import java.util.*;

/**
 * wangjq
 * 2021年04月09日  22:30
 */
public class LeetCode_103 {



    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (Objects.isNull(root)) {
            return Collections.emptyList();
        }
        List<List<Integer>> resultList = new LinkedList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        int i = 0;
        while (!deque.isEmpty()) {
            LinkedList<Integer> list = new LinkedList<>();
            int size = deque.size();
            boolean isOdd = (i & 1) == 1;
            while (size > 0) {
                TreeNode treeNode = deque.removeFirst();
                if (Objects.nonNull(treeNode.left)) {
                    deque.addLast(treeNode.left);
                }
                if (Objects.nonNull(treeNode.right)) {
                    deque.addLast(treeNode.right);
                }
                if (isOdd) {
                    list.addFirst(treeNode.val);
                } else {
                    list.addLast(treeNode.val);
                }
                size --;
            }
            resultList.add(list);
            i ++;
        }
        return resultList;
    }

}
