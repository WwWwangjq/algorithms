package com.tianwen.leetcode_2021.offer;

import com.tianwen.data.structure.TreeNode;

import java.util.*;

/**
 * wangjq
 * 2020年12月19日  11:11
 */
public class Algorithms32_1_TreeNode_Print {


    /**
     * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
     *
     * 例如:
     * 给定二叉树: [3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param args
     */
    public static void main(String[] args) {
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode8 = new TreeNode(8, null, treeNode9);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode6 = new TreeNode(6, null, treeNode7);
        TreeNode treeNode5 = new TreeNode(5, null, treeNode6);
        TreeNode treeNode4 = new TreeNode(4, null, treeNode8);
        TreeNode treeNode3 = new TreeNode(3, treeNode4, treeNode5);
        TreeNode treeNode2 = new TreeNode(2, null, treeNode3);
        TreeNode treeNode1 = new TreeNode(1, treeNode2, null);

        int[] ints = levelOrder(treeNode1);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] levelOrder(TreeNode root) {
        if (Objects.isNull(root)) {
            return new int[0];
        }
        ArrayList<Integer> intList = new ArrayList<>();
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.addFirst(root);
        while (!linkedList.isEmpty()) {
            TreeNode head = linkedList.getFirst();
            if (Objects.nonNull(head.left)) {
                linkedList.addLast(head.left);
            }
            if (Objects.nonNull(head.right)) {
                linkedList.addLast(head.right);
            }
            intList.add(linkedList.removeFirst().val);
        }
        return intList.stream().mapToInt(Integer::intValue).toArray();
    }
}
