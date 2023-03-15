package com.tianwen.leetcode_2023;

import com.tianwen.data.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Author: wangjq
 * @Date: 2023年03月14日 22:22
 */
public class LeetCode_236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathP = new ArrayList<>();
        preOrder(root, p, pathP);
        List<TreeNode> pathQ = new ArrayList<>();
        preOrder(root, q, pathQ);
        int i;
        for (i = 0; i < Math.min(pathP.size(), pathQ.size()); i ++) {
            if (pathP.get(i) != pathQ.get(i)) {
                break;
            }
        }
        return pathP.get(i - 1);
    }

    private boolean preOrder(TreeNode node, TreeNode t, List<TreeNode> path) {
        if (Objects.isNull(node)) {
            return false;
        }
        path.add(node);
        if (node.equals(t)) {
            return true;
        }
        boolean need1 = preOrder(node.left, t, path);
        boolean need2 = preOrder(node.right, t, path);
        boolean need = need1 || need2;
        if (!need) {
            path.remove(node);
        }
        return need;
    }
}
