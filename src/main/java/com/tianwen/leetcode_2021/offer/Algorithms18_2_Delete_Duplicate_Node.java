package com.tianwen.leetcode_2021.offer;

import com.tianwen.data.structure.Node;

import java.util.Objects;

/**
 * wangjq
 * 2020年12月06日  18:50
 */
public class Algorithms18_2_Delete_Duplicate_Node {

/*    static Node n5 = new Node(4);
    static Node n4 = new Node(3, n5);
    static Node n3 = new Node(2, n4);
    static Node n2 = new Node(2, n3);
    static Node n1 = new Node(1, n2);*/


/*    static Node n2 = new Node(1);
    static Node n1 = new Node(1, n2);*/

/*    static Node n2 = new Node(2);
    static Node n1 = new Node(1, n2);*/

/*    static Node n5 = new Node(3);
    static Node n4 = new Node(3, n5);
    static Node n3 = new Node(2, n4);
    static Node n2 = new Node(1, n3);
    static Node n1 = new Node(1, n2);*/


/*    static Node n3 = new Node(2);
    static Node n2 = new Node(2, n3);
    static Node n1 = new Node(1, n2);*/


    static Node n7 = new Node(4);
    static Node n6 = new Node(4, n7);
    static Node n5 = new Node(3, n6);
    static Node n4 = new Node(2, n5);
    static Node n3 = new Node(2, n4);
    static Node n2 = new Node(2, n3);
    static Node n1 = new Node(1, n2);


    public static void main(String[] args) {
        Node head = n1;
        System.out.println(head);
        deleteDuplicate(head);
        System.out.println(head);
    }

    private static void deleteDuplicate(Node head) {
        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return;
        }
        boolean delete = false;
        Node node = head;
        while (Objects.nonNull(node.next)) {
            Node next = node.next;
            // 如果当前节点和下一个节点是重复的
            // 当前节点指向下下个节点 并标识当前节点应该被删除（完成了删除下一个节点 并标识当前节点并在随后删除）
            if (node.value == next.value) {
                node.next = next.next;
                delete = true;
            } else {
                // 如果当前节点与下一个节点不同
                // 如果需要删除 用下一个值填充当前节点 在用当前节点指向下下个节点 以完成'删除当前节点'的逻辑
                if (delete) {
                    node.value = next.value;
                    node.next = next.next;
                    delete = false;
                } else {
                    // 如果不需要删除 只是简单的替换节点
                    node = node.next;
                }
            }
        }
        // 如果最后一个节点也需要删除
        if (delete) {
            deleteLast(head);
        }
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
