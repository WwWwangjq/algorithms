package com.tianwen.data.structure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * wangjq
 * 2020年12月06日  18:10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int value) {
        this.val = value;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}
