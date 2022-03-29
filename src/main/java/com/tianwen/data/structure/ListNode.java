package com.tianwen.data.structure;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
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
        return val + "";
    }

    public static List<Integer> listVal(ListNode head) {
        List<Integer> result = new ArrayList<>();
        ListNode node = head;
        while (Objects.nonNull(node)) {
            result.add(node.val);
            node = node.next;
        }
        return result;
    }

}
