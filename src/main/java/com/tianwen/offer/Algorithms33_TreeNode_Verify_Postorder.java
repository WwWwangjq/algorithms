package com.tianwen.offer;

import java.util.*;

/**
 * wangjq
 * 2020年12月20日  14:08
 */
public class Algorithms33_TreeNode_Verify_Postorder {

    /**
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
     * <p>
     *  
     * <p>
     * 参考以下这颗二叉搜索树：
     * <p>
     * 5
     * / \
     * 2   6
     * / \
     * 1   3
     * 示例 1：
     * <p>
     * 输入: [1,6,3,2,5]
     * 输出: false
     * 示例 2：
     * <p>
     * 输入: [1,3,2,6,5]
     * 输出: true
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] postorder = new int[]{5, 7, 6, 9, 11, 10, 8};
        System.out.println(verifyPostorder(postorder));
    }

    public static boolean verifyPostorder(int[] postorder) {
        if (Objects.isNull(postorder)) {
            return false;
        }
        return verify(postorder);
    }

    private static boolean verify(int[] postorder) {
        int length = postorder.length;
        if (length == 0 || length == 1) {
            return true;
        }
        int rootVal = postorder[length - 1];
        // true: 左子树 false: 右子树
        boolean leftModel = postorder[0] < rootVal;
        int leftSize = 0;
        int rightSize = 0;
        for (int val : postorder) {
            if (val == rootVal) {
                break;
            }
            if (leftModel) {
                if (val < rootVal) {
                    leftSize++;
                } else {
                    rightSize++;
                    leftModel = false;
                }
            } else {
                if (val > rootVal) {
                    rightSize++;
                } else {
                    return false;
                }
            }
        }
        int[] left = new int[leftSize];
        int[] right = new int[rightSize];
        int i = 0;
        int j = 0;
        for (int val : postorder) {
            if (val == rootVal) {
                break;
            }
            if (val < rootVal) {
                left[i++] = val;
            } else {
                right[j++] = val;
            }
        }
        return verify(left) && verify(right);
    }
}
