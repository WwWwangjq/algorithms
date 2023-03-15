package com.tianwen.leetcode_2022.链表;

import com.tianwen.data.structure.ListNode;

import java.util.Objects;

/**
 * wangjq
 * 2022年03月26日  14:16
 */
public class LeetCode_143 {

    /**
     * //L0 → L1 → … → Ln - 1 → Ln
     * //
     * //
     * // 请将其重新排列后变为：
     * //
     * //
     * //L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
     * <p>
     * //输入：head = [1,2,3,4]
     * //输出：[1,4,2,3]
     * //
     * // 示例 2：
     * //
     * //
     * //
     * //
     * //输入：head = [1,2,3,4,5]
     * //输出：[1,5,2,4,3]
     * //
     * //输入：head = [1,2,3,4,5,6]
     * //输出：[1,6,2,5,3,4]
     */
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
//        ListNode head = new ListNode(1, new ListNode(2));
//        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));
//        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
//        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
//        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        LeetCode_143 leetCode_143 = new LeetCode_143();
        leetCode_143.reorderList(head);
        System.out.println(ListNode.listVal(head));
    }

/*    private List<ListNode> list = new ArrayList<>();

    public void reorderList(ListNode head) {
        if (Objects.isNull(head)) {
            return;
        }
        ListNode node = head;
        while (Objects.nonNull(node)) {
            list.add(node);
            node = node.next;
        }

        node = head;
        ListNode pre = new ListNode();
        pre.next = node;
        int i = 0;
        while ((odd(i) && Objects.nonNull(node.next) || (!odd(i) && Objects.nonNull(node.next) && Objects.nonNull(node.next.next)))) {
            // real
            ListNode rNext = node.next;
            ListNode rPre = pre.next;
            // last
            ListNode lastNode = list.get(list.size() - 1 - i);
            ListNode lastNodePre = list.get(list.size() - 1 - i - 1);
            // swap
            lastNodePre.next = null;
            ListNode next = node.next;
            node.next = lastNode;
            lastNode.next = next;

            node = rNext;
            pre = rPre;
            i ++;
        }
    }

    private boolean odd(int i) {
        return (i & 1) == 1;
    }*/

    public void reorderList(ListNode head) {
        if (Objects.isNull(head)) {
            return;
        }
        ListNode node = head;
        ListNode pre = new ListNode();
        pre.next = node;
        while (Objects.nonNull(node)) {
            // real
            ListNode rNext = node.next;
            ListNode rPre = pre.next;
            // current
            ListNode currentNode = node;
            ListNode currentNodePre = new ListNode();
            currentNodePre.next = currentNode;
            while (Objects.nonNull(currentNode.next)) {
                currentNode = currentNode.next;
                currentNodePre = currentNodePre.next;
            }
            // swap
            currentNodePre.next = null;
            ListNode next = node.next;
            node.next = currentNode;
            currentNode.next = next;

            node = rNext;
            pre = rPre;
        }
    }
}
