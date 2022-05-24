package com.tianwen.leetcode.树;

import com.tianwen.data.structure.TreeNode;

import java.util.Objects;

/**
 * wangjq
 * 2022年04月23日  11:42
 */
public class LeetCode_530 {
    //543,384,652,null,445,null,699
    //236,104,701,null,227,null,911
    //600,424,612,null,499,null,689
    //0,null,2236,1277,2776,519
    public static void main(String[] args) {
        LeetCode_530 leetCode_530 = new LeetCode_530();
        TreeNode root = new TreeNode(236, new TreeNode(104, null, new TreeNode(227)),new TreeNode(701, null, new TreeNode(911)));
        System.out.println(leetCode_530.getMinimumDifference(root));
    }

    public int getMinimumDifference(TreeNode root) {
        recur(root);
        return result;
    }

    public int result = Integer.MAX_VALUE;
    public Integer preVal;

    public void recur(TreeNode node) {
        if (Objects.isNull(node)) {
            return;
        }
        recur(node.left);
        if (Objects.isNull(preVal)) {
            preVal = node.val;
        } else {
            result = Math.min(result, node.val - preVal);
            preVal = node.val;
        }
        recur(node.right);
    }
}
