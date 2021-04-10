package com.tianwen.leetcode;

import com.tianwen.data.structure.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * wangjq
 * 2021年04月06日  23:01
 */
public class LeetCode_102 {

    // 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
    //
    // 
    //
    //示例：
    //二叉树：[3,9,20,null,null,15,7],
    //
    //    3
    //   / \
    //  9  20
    //    /  \
    //   15   7
    //返回其层序遍历结果：
    //
    //[
    //  [3],
    //  [9,20],
    //  [15,7]
    //]
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (Objects.isNull(root)) {
            return Collections.emptyList();
        }
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.addLast(root);
        List<List<Integer>> resultList = new LinkedList<>();
        while (!linkedList.isEmpty()) {
            List<Integer> list = new LinkedList<>();
            int size = linkedList.size();
            while (size > 0) {
                TreeNode treeNode = linkedList.removeFirst();
                list.add(treeNode.val);
                if (Objects.nonNull(treeNode.left)) {
                    linkedList.addLast(treeNode.left);
                }
                if (Objects.nonNull(treeNode.right)) {
                    linkedList.addLast(treeNode.right);
                }
                size --;
            }
            if (!list.isEmpty()) {
                resultList.add(list);
            }
        }
        return resultList;
    }
}
