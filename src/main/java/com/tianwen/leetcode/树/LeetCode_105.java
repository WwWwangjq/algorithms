package com.tianwen.leetcode.树;

import com.tianwen.data.structure.TreeNode;

import java.util.Objects;

/**
 * wangjq
 * 2021年04月10日  16:36
 */
//根据一棵树的前序遍历与中序遍历构造二叉树。
//
// 注意:
//你可以假设树中没有重复的元素。
//
// 例如，给出
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7]
//
// 返回如下的二叉树：
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// Related Topics 树 深度优先搜索 数组
// 👍 977 👎 0
public class LeetCode_105 {

    public static void main(String[] args) {
        LeetCode_105 leetCode_105  = new LeetCode_105();
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        TreeNode treeNode = leetCode_105.buildTree(preorder, inorder);
        System.out.println(treeNode);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = new TreeNode();
        buildTree(preorder, inorder, root, true);
        return root.left;
    }

    private void buildTree(int[] preorder, int[] inorder, TreeNode root, boolean isLeft) {
        if (Objects.isNull(preorder) || preorder.length == 0) {
            return;
        }
        int rootVal = preorder[0];
        TreeNode node = new TreeNode(rootVal);
        if (isLeft) {
            root.left = node;
        } else {
            root.right = node;
        }

        int sub = getSub(inorder, rootVal);
        int rightSize = inorder.length - sub - 1;

        int[] inLeft = new int[sub];
        int[] inRight = new int[rightSize];
        int i = 0, j = 0, k = 0;
        for (int val : inorder) {
            if (k < sub) {
                inLeft[i ++] = val;
            } else if (k > sub) {
                inRight[j ++] = val;
            }
            k ++;
        }

        int[] preLeft = new int[sub];
        int[] preRight = new int[rightSize];
        i = 0;
        j = 0;
        for (k = 1; k < preorder.length; k++) {
            if (i < sub) {
                preLeft[i++] = preorder[k];
            } else {
                preRight[j++] = preorder[k];
            }
        }
        buildTree(preLeft, inLeft, node, true);
        buildTree(preRight, inRight, node, false);
    }

    private int getSub(int[] arr, int val) {
        int i = 0;
        for (int a : arr) {
            if (a == val) {
                return i;
            }
            i ++;
        }
        return 0;
    }
}
