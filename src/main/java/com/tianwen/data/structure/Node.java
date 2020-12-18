package com.tianwen.data.structure;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * wangjq
 * 2020年12月06日  18:08
 */
@NoArgsConstructor
@AllArgsConstructor
public class Node {
    public int value;
    public Node next;

    public Node(int value) {
        this.value = value;
    }

    public boolean hasNext() {
        return next != null;
    }

    @Override
    public String toString() {
        String s = value + ", ";
        if (Objects.nonNull(next)) {
            s += next.toString();
        }
        return s;
    }
}
