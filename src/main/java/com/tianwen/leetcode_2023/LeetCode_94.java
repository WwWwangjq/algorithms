package com.tianwen.leetcode_2023;

import com.tianwen.data.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Author: wangjq
 * @Date: 2023年03月19日 11:32
 */
public class LeetCode_94 {


    public List<Integer> inorderTraversal(TreeNode root) {
        if (Objects.isNull(root)) {
            return resultList;
        }
        recur(root);
        return resultList;
    }

    List<Integer> resultList = new ArrayList<>();

    private void recur(TreeNode root) {
        if (Objects.isNull(root)) {
            return;
        }
        recur(root.left);
        resultList.add(root.val);
        recur(root.right);
    }
}
