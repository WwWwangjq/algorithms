package com.tianwen.offer;

import com.tianwen.data.structure.TreeNode;

import java.util.*;

/**
 * wangjq
 * 2020年12月20日  14:08
 */
public class Algorithms34_TreeNode_PathSum {

    /**
     * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
     *
     *  
     *
     * 示例:
     * 给定如下二叉树，以及目标和 sum = 22，
     *
     *               5
     *              / \
     *             4   8
     *            /   / \
     *           11  13  4
     *          /  \    / \
     *         7    2  5   1
     * 返回:
     *
     * [
     *    [5,4,11,2],
     *    [5,8,4,5]
     * ]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param args
     */
    public static void main(String[] args) {
/*        TreeNode treeNode0 = new TreeNode(0);
        TreeNode treeNode12 = new TreeNode(12, null, treeNode0);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode5 = new TreeNode(5, treeNode4, treeNode7);
        TreeNode treeNode10 = new TreeNode(10, treeNode5, treeNode12);
        int sum = 22;*/

/*        TreeNode treeNode11 = new TreeNode(2);
        TreeNode treeNode10 = new TreeNode(1, null, treeNode11);
        int sum = 1;*/

/*        TreeNode treeNode11 = new TreeNode(-3);
        TreeNode treeNode10 = new TreeNode(-2, null, treeNode11);
        int sum = -5;*/

        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode5_1 = new TreeNode(5);
        TreeNode treeNode4_1 = new TreeNode(4, treeNode5_1, treeNode1);
        TreeNode treeNode13 = new TreeNode(13, null, null);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode11 = new TreeNode(11, treeNode7, treeNode2);
        TreeNode treeNode8 = new TreeNode(8, treeNode13, treeNode4_1);
        TreeNode treeNode4 = new TreeNode(4, treeNode11, null);
        TreeNode treeNode10 = new TreeNode(5, treeNode4, treeNode8);
        int sum = 22;

        List<List<Integer>> lists = pathSum(treeNode10, sum);
        lists.forEach(System.out::println);
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        collect(root, result, new LinkedList<>(), sum);
        return result;
    }

    private static void collect(TreeNode node, List<List<Integer>> result, LinkedList<Integer> path, int sum) {
        if (Objects.isNull(node)) {
            return;
        }
        int val = node.val;
        path.add(val);
        sum -= val;
        if (isLeaf(node) && sum == 0) {
            result.add(new LinkedList<>(path));
        }
        collect(node.left, result, path, sum);
        collect(node.right, result, path, sum);
        path.removeLast();
    }

    private static boolean isLeaf(TreeNode node) {
        return Objects.isNull(node.left) && Objects.isNull(node.right);
    }
}
