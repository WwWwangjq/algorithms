package com.tianwen.leetcode_2022.树;

//给定一个二叉树，判断其是否是一个有效的二叉搜索树。
//
// 假设一个二叉搜索树具有如下特征：
//
//
// 节点的左子树只包含小于当前节点的数。
// 节点的右子树只包含大于当前节点的数。
// 所有左子树和右子树自身必须也是二叉搜索树。
//
//
// 示例 1:
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
//
//
// 示例 2:
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
//
// Related Topics 树 深度优先搜索 递归
// 👍 1008 👎 0

import com.tianwen.data.structure.TreeNode;

import java.util.Objects;

/**
 * wangjq
 * 2021年04月09日  22:57
 */
public class LeetCode_98 {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long lower, long upper) {
        if (Objects.isNull(root)) {
            return true;
        }
        if (root.val >= upper || root.val <= lower) {
            return false;
        }
        return isValidBST(root.left, lower, root.val) && isValidBST(root.right, root.val, upper);
    }

/*    public boolean isValidBST(TreeNode root) {
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        double pre = -Double.MAX_VALUE;
        while (!linkedList.isEmpty() || Objects.nonNull(root)) {
            while (Objects.nonNull(root)) {
                linkedList.push(root);
                root = root.left;
            }
            TreeNode pop = linkedList.pop();
            if (pop.val <= pre) {
                return false;
            }
            pre = pop.val;
            root = pop.right;
        }
        return true;
    }*/
}
