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
public class ListNodeLoop {

    public int val;
    public ListNodeLoop next;

    public ListNodeLoop(int x) {
        val = x;
    }

    @Override
    public String toString() {
        String s = val + ", ";
        return s;
    }
}
