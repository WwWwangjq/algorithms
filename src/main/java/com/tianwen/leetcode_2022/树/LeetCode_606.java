package com.tianwen.leetcode_2022.树;

import com.tianwen.data.structure.TreeNode;

import java.util.Objects;

/**
 * wangjq
 * 2022年04月23日  14:52
 */
public class LeetCode_606 {
    /**
     *
     //输入：root = [1,2,3,4]
     //输出："1(2(4))(3)"
     //解释：初步转化后得到 "1(2(4)())(3()())" ，但省略所有不必要的空括号对后，字符串应该是"1(2(4))(3)" 。
     //
     //输入：root = [1,2,3,null,4]
     //输出："1(2()(4))(3)"
     //解释：和第一个示例类似，但是无法省略第一个空括号对，否则会破坏输入与输出一一映射的关系。
     * @param args
     */
    public static void main(String[] args) {

    }

    public String tree2str(TreeNode root) {
        return recur(root);
    }

    private String recur(TreeNode node) {
        if (Objects.isNull(node)) {
            return "";
        }
        String leftReturn = "";
        if (Objects.nonNull(node.left) || Objects.nonNull(node.right)) {
            leftReturn = "(" + recur(node.left) + ")";
        }
        String rightReturn = "";
        if (Objects.nonNull(node.right)) {
            rightReturn = "(" + recur(node.right) + ")";
        }
        return node.val + leftReturn + rightReturn;
    }
}
