package com.tianwen.leetcode.tree;

import com.tianwen.data.structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @Author: wangjq
 * @Date: 2021年04月12日 18:13
 */
public class LeetCode_113 {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        pathSum(root, targetSum, 0, new LinkedList<>(), result);
        return result;
    }

    private void pathSum(TreeNode root, int targetSum, int curSum, LinkedList<Integer> curList, List<List<Integer>> result) {
        if (Objects.isNull(root)) {
            return;
        }
        curSum += root.val;
        curList.addLast(root.val);
        if (Objects.isNull(root.left) && Objects.isNull(root.right) && curSum == targetSum) {
            result.add(new ArrayList<>(curList));
        }
        pathSum(root.left, targetSum, curSum, curList, result);
        pathSum(root.right, targetSum, curSum, curList, result);
        curList.removeLast();
    }
}
