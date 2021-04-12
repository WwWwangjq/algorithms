package com.tianwen.offer;

import com.tianwen.data.structure.TreeNode;

import java.util.*;

/**
 * wangjq
 * 2020年12月20日  14:08
 */
public class Algorithms32_2_TreeNode_Print {

    /**
     * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
     * <p>
     *  
     * <p>
     * 例如:
     * 给定二叉树: [3,9,20,null,null,15,7],
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 返回其层次遍历结果：
     * <p>
     * [
     * [3],
     * [9,20],
     * [15,7]
     * ]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode treeNode11 = new TreeNode(11);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode10 = new TreeNode(10, treeNode9, treeNode11);
        TreeNode treeNode6 = new TreeNode(6, treeNode5, treeNode7);
        TreeNode treeNode8 = new TreeNode(8, treeNode6, treeNode10);

        List<List<Integer>> lists = levelOrder(treeNode8);
        lists.forEach(System.out::println);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (Objects.isNull(root)) {
            return Collections.emptyList();
        }
        List<List<Integer>> resultList = new LinkedList<>();
        collect(root, resultList);
        return resultList;
    }

    private static void collect(TreeNode root, List<List<Integer>> resultList) {
        LinkedList<TreeNode> nodeList = new LinkedList<>();
        nodeList.add(root);
        while (!nodeList.isEmpty()) {
            List<TreeNode> tempList = new ArrayList<>();
            List<Integer> result = new ArrayList<>();
            while (!nodeList.isEmpty()) {
                TreeNode treeNode = nodeList.removeFirst();
                result.add(treeNode.val);
                if (Objects.nonNull(treeNode.left)) {
                    tempList.add(treeNode.left);
                }
                if (Objects.nonNull(treeNode.right)) {
                    tempList.add(treeNode.right);
                }
            }
            resultList.add(result);
            if (!tempList.isEmpty()) {
                nodeList.addAll(tempList);
            }
        }
    }
}
