package com.tianwen.leetcode;

import com.tianwen.data.structure.TreeNode;

import java.util.Objects;

/**
 * wangjq
 * 2021年04月10日  23:41
 */
public class LeetCode_108 {
    public static void main(String[] args) {
        LeetCode_108 leetCode_108 = new LeetCode_108();
//        int[] nums = new int [] {2,3,4,5,6,7,8};
        int[] nums = new int [] {-10,-3,0,5,9};
        TreeNode treeNode = leetCode_108.sortedArrayToBST(nums);
        System.out.println(treeNode);
    }


    public TreeNode sortedArrayToBST(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return null;
        }
        TreeNode init = new TreeNode();
        sortedArrayToBST(nums, 0, nums.length - 1, init, true);
        return init.left;
    }

    private void sortedArrayToBST(int[] nums, int start, int end, TreeNode root, boolean isLeft) {
        if (end < start) {
            return;
        }
        int min = (start + end) / 2;
        TreeNode treeNode = new TreeNode();
        treeNode.val = nums[min];
        if (isLeft) {
            root.left = treeNode;
        } else {
            root.right = treeNode;
        }
        sortedArrayToBST(nums, start, min - 1, treeNode, true);
        sortedArrayToBST(nums, min + 1, end, treeNode, false);
    }
}
