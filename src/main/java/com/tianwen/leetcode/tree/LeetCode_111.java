package com.tianwen.leetcode.tree;

import com.tianwen.data.structure.TreeNode;

import java.util.LinkedList;
import java.util.Objects;

/**
 * @Author: wangjq
 * @Date: 2021年04月12日 15:50
 */
public class LeetCode_111 {

    public int minDepth(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }
        LinkedList<TreeNode> treeNodeList = new LinkedList<>();
        treeNodeList.addLast(root);
        int height = 0;
        while (!treeNodeList.isEmpty()) {
            height ++;
            int size = treeNodeList.size();
            while (size > 0) {
                TreeNode treeNode = treeNodeList.removeFirst();
                if (Objects.isNull(treeNode.left) && Objects.isNull(treeNode.right)) {
                    return height;
                }
                if (Objects.nonNull(treeNode.left)) {
                    treeNodeList.addLast(treeNode.left);
                }
                if (Objects.nonNull(treeNode.right)) {
                    treeNodeList.addLast(treeNode.right);
                }
                size --;
            }
        }
        return height;
    }

}
