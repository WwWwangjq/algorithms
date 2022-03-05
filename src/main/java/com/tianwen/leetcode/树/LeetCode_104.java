package com.tianwen.leetcode.树;

import com.tianwen.data.structure.TreeNode;

import java.util.*;

/**
 * wangjq
 * 2021年04月06日  23:01
 */
public class LeetCode_104 {

    // 给定一个二叉树，找出其最大深度。
    //
    //二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
    //
    //说明: 叶子节点是指没有子节点的节点。
    //
    //示例：
    //给定二叉树 [3,9,20,null,null,15,7]，
    //
    //    3
    //   / \
    //  9  20
    //    /  \
    //   15   7
    //返回它的最大深度 3 。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    /** 深度优先 */
/*    public int maxDepth(TreeNode root) {
        int[] max = new int [] {0};
        recur(root, max, 0);
        return max[0];
    }

    private void recur(TreeNode root, int[] max, int curNum) {
        if (Objects.isNull(root)) {
            return;
        }
        max[0] = Math.max(max[0], ++curNum);
        recur(root.left, max, curNum);
        recur(root.right, max, curNum);
    }*/

    /** 广度优先 */
    public int maxDepth(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        int height = 0;
        linkedList.addLast(root);
        while (!linkedList.isEmpty()) {
            height ++;
            int size = linkedList.size();
            while (size > 0) {
                TreeNode treeNode = linkedList.removeLast();
                if (Objects.nonNull(treeNode.left)) {
                    linkedList.addFirst(treeNode.left);
                }
                if (Objects.nonNull(treeNode.right)) {
                    linkedList.addFirst(treeNode.right);
                }
                size --;
            }
        }
        return height;
    }
}
