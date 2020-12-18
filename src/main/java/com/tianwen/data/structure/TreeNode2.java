package com.tianwen.data.structure;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * wangjq
 * 2020年12月06日  18:10
 */
@NoArgsConstructor
@AllArgsConstructor
public class TreeNode2 {
    public String value;
    public TreeNode2 left;
    public TreeNode2 right;
    public TreeNode2 parent;

    public TreeNode2(String value) {
        this.value = value;
    }

    public String toString() {
        return this.value;
    }
}
