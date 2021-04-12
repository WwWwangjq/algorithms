package com.tianwen.offer;

import com.tianwen.data.structure.Node;

import java.util.Objects;

/**
 * wangjq
 * 2020年11月07日  17:52
 */
public class Algorithms18_1_Delete_One_Node {

    static Node n5 = new Node(5);
    static Node n4 = new Node(4, n5);
    static Node n3 = new Node(3, n4);
    static Node n2 = new Node(2, n3);
    static Node n1 = new Node(1, n2);
//    static Node n1 = new Node(1, null);

    /**
     * 给定单向链表的头指针和节点指针 定义一个函数 在O(1)时间内删除该节点
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(n1);
        delete(n1, n5);
        System.out.println(n1);
    }


    private static void delete(Node head, Node node) {
        if (Objects.isNull(node)) {
            return;
        }
        if (Objects.isNull(node.next)) {
            System.out.println("要删除的节点是最后一个节点 只能通过遍历删除");
            deleteLast(head);
            return;
        }
        Node next = node.next;
        // 让要删除的节点值等于后面的节点值
        node.value = next.value;
        // 让要删除的节点指向后面的后面的节点
        node.next = next.next;
    }

    private static void deleteLast(Node node) {
        Node pre = null;
        while (Objects.nonNull(node.next)) {
            pre = node;
            node = node.next;
        }
        if (Objects.isNull(pre)) {
            node.value = 0;
            node.next = null;
        } else {
            pre.next = null;
        }
    }


}
