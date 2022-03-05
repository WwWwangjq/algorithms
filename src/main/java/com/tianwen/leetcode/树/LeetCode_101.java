package com.tianwen.leetcode.树;

import com.tianwen.data.structure.TreeNode;

import java.util.LinkedList;
import java.util.Objects;

/**
 * wangjq
 * 2021年04月06日  23:01
 */
public class LeetCode_101 {

    // 给定一个二叉树，检查它是否是镜像对称的。
    //
    // 
    //
    //例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
    //
    //    1
    //   / \
    //  2   2
    // / \ / \
    //3  4 4  3
    // 
    //
    //但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
    //
    //    1
    //   / \
    //  2   2
    //   \   \
    //   3    3
    // 
    //
    //进阶：
    //
    //你可以运用递归和迭代两种方法解决这个问题吗？
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/symmetric-tree
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    /** 递归 */
/*    public boolean isSymmetric(TreeNode root) {
        if (Objects.isNull(root)) {
            return false;
        }
        return recur(root.left, root.right);
    }

    private boolean recur(TreeNode treeNode1, TreeNode treeNode2) {
        if (Objects.isNull(treeNode1) && Objects.isNull(treeNode2)) {
            return true;
        } else if (Objects.isNull(treeNode1) || Objects.isNull(treeNode2)) {
            return false;
        } else {
            return treeNode1.val == treeNode2.val && recur(treeNode1.left, treeNode2.right) && recur(treeNode1.right, treeNode2.left);
        }
    }*/

    /** 迭代 */
    public boolean isSymmetric(TreeNode root) {
        if (Objects.isNull(root)) {
            return false;
        }
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.addLast(root);
        linkedList.addLast(root);
        while (!linkedList.isEmpty()) {
            TreeNode treeNode1 = linkedList.remove();
            TreeNode treeNode2 = linkedList.remove();
            if (Objects.isNull(treeNode1) && Objects.isNull(treeNode2)) {
                continue;
            }
            if (Objects.isNull(treeNode1) || Objects.isNull(treeNode2) || treeNode1.val != treeNode2.val) {
                return false;
            }
            linkedList.add(treeNode1.left);
            linkedList.add(treeNode2.right);
            linkedList.add(treeNode1.right);
            linkedList.add(treeNode2.left);
        }
        return true;
    }

}
