package com.tianwen.data.structure;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * wangjq
 * 2020年12月13日  22:29
 */
@NoArgsConstructor
@AllArgsConstructor
public class ListNodeDouble {

    public int val;
    public ListNodeDouble next;
    public ListNodeDouble pre;

    public ListNodeDouble(int x) {
        val = x;
    }

    @Override
    public String toString() {
        String s = val + ", ";
        return s;
    }
}
