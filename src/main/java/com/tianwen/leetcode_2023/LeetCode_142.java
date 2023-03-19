package com.tianwen.leetcode_2023;

import com.tianwen.data.structure.ListNode;

import java.util.Objects;

/**
 * @Author: wangjq
 * @Date: 2023年03月18日 22:09
 */
public class LeetCode_142 {


    private ListNode fast;

    /**
     * 证明：
     * slow = k
     * fast = 2k
     * fast - slow = k
     * 以相遇节点作为起点 相当于fast比slow多走了n个圈r
     * 所以 k = n * r
     * 忽略前面的重复n-1圈 只以最后一圈来考虑 k = r
     * 从环起点到相遇点的距离m两个slow都会走过
     * 所以
     * 起点到环起点a + m = k
     * 相遇点到环起点b + m = k
     * a = b
     * 即一指针从相遇点开始 一指针从起点开始走 相遇点为环起点
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (true) {
            if (Objects.isNull(fast) || Objects.isNull(fast.next)) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
            if (slow.equals(fast)) {
                break;
            }
        }
        ListNode slow2 = head;
        while (!slow2.equals(slow)) {
            slow2 = slow2.next;
            slow = slow.next;
        }
        return slow2;
    }
}
