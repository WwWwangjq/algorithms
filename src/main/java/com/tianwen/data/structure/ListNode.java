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
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        String s = val + ", ";
/*        if (Objects.nonNull(next)) {
            s += next.toString();
        }*/
        return s;
    }
}
