package com.tianwen.leetcode_2022.树;

import com.tianwen.data.structure.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * wangjq
 * 2021年04月10日  19:38
 */
//给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
//
// 例如：
//给定二叉树 [3,9,20,null,null,15,7],
//
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//
// 返回其自底向上的层序遍历为：
//
//
//[
//  [15,7],
//  [9,20],
//  [3]
//]
//
// Related Topics 树 广度优先搜索
// 👍 424 👎 0
public class LeetCode_107 {


    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (Objects.isNull(root)) {
            return Collections.emptyList();
        }
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(root);
        LinkedList<List<Integer>> resultList = new LinkedList<>();
        while (!linkedList.isEmpty()) {
            LinkedList<Integer> list = new LinkedList<>();
            int size = linkedList.size();
            while (size > 0) {
                TreeNode treeNode = linkedList.removeFirst();
                list.add(treeNode.val);
                if (Objects.nonNull(treeNode.left)) {
                    linkedList.add(treeNode.left);
                }
                if (Objects.nonNull(treeNode.right)) {
                    linkedList.add(treeNode.right);
                }
                size --;
            }
            if (!list.isEmpty()) {
                resultList.addFirst(list);
            }
        }
        return resultList;
    }
}
