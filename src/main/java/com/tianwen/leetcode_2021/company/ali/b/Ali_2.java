package com.tianwen.leetcode_2021.company.ali.b;

import com.tianwen.data.structure.Node;

import java.util.LinkedList;
import java.util.Objects;

/**
 * wangjq
 * 2021年04月29日  21:00
 */
public class Ali_2 {

    public static void main(String[] args) {

        Ali_2 ali_2 = new Ali_2();
        Node node11 = new Node(1);
        Node node12 = new Node(2);
        Node node13 = new Node(3);
        node11.next = node12;
        node12.next = node13;

        Node node21 = new Node(2);
        Node node22 = new Node(3);
        Node node23 = new Node(4);
        node21.next = node22;
        node22.next = node23;
        Node add = ali_2.add(node11, node21);
        System.out.println(add);
    }

    /*
     * 实现两个单链表的加法, 链表每个节点存储的都是0-9的数字
     * 如有以下两个链表
     * 1->2->3
     * 2->3->4
     * 返回的结果为
     * 3->5->7
     * */

    public Node add(Node node1, Node node2) {
        if(Objects.isNull(node1) && Objects.isNull(node2)) {
            return null;
        }
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        while (true) {
            if (Objects.nonNull(node1)) {
                list1.addFirst(node1.value);
                node1 = node1.next;
            }
            if (Objects.nonNull(node2)) {
                list2.addFirst(node2.value);
                node2 = node2.next;
            }
            if (Objects.isNull(node1) && Objects.isNull(node2)) {
                break;
            }
        }
        Node next = null;
        while (true) {
            int val = 0;
            Integer val1 = list1.pollFirst();
            if (Objects.nonNull(val1)) {
                val += val1;
            }
            Integer val2 = list2.pollFirst();
            if (Objects.nonNull(val2)) {
                val += val2;
            }
            if (Objects.isNull(val1) && Objects.isNull(val2)) {
                break;
            }
            if (Objects.isNull(next)) {
                next = new Node(val);
            } else {
                Node node = new Node(val);
                node.next = next;
                next = node;
            }
        }
        return next;
    }


/*    public Node add(Node head1, Node head2) {
        head1 = reverse(head1);
        head2 = reverse(head2);
        Node node1 = head1;
        Node node2 = head2;
        Node result = null;
        while (true) {
            int val = 0;
            if (Objects.nonNull(node1)) {
                val += node1.value;
                node1 = node1.next;
            }
            if (Objects.nonNull(node2)) {
                val += node2.value;
                node2 = node2.next;
            }
            if (Objects.isNull(result)) {
                result = new Node(val);
            } else {
                Node node = new Node(val);
                node.next = result;
                result = node;
            }
            if (Objects.isNull(node1) && Objects.isNull(node2)) {
                break;
            }
        }
        return result;
    }*/

    private Node reverse(Node head) {
        Node pre = null;
        Node node = head;
        while (Objects.nonNull(node)) {
            Node next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }
}
