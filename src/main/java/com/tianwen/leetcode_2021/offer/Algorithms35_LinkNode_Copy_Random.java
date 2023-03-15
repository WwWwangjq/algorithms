package com.tianwen.leetcode_2021.offer;

/**
 * wangjq
 * 2020年12月21日  22:22
 */
public class Algorithms35_LinkNode_Copy_Random {

    /**
     * 复制一份复杂链表 且最终原链表不能有变动
     * 复制链表包含value next random random指向一个随机节点或null
     * @param args
     */
    public static void main(String[] args) {
        Node node5 = new Node(5);
        Node node4 = new Node(4);
        Node node3 = new Node(3);
        Node node2 = new Node(2);
        Node node1 = new Node(1);
        node1.next = node2;
        node1.random = node5;

        node2.next = node3;
        node2.random = node3;

        node3.next = node4;
        node4.next = node5;

        Node head = node1;
        Node node = copyRandomList(head);
        System.out.println(node);
    }

    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        replicaList(head);
        setRandom(head);
        Node init = new Node(0);
        split(head, init);
        return init.next;
    }

    private static void replicaList(Node node) {
/*        while (node != null) {
            Node copy = new Node(node.val);
            copy.next = node.next;
            node.next = copy;
            node = copy.next;
        }*/
        if (node == null) {
            return;
        }
        Node copy = new Node(node.val);
        copy.next = node.next;
        node.next = copy;
        replicaList(copy.next);
    }

    private static void setRandom(Node node) {
        if (node == null) {
            return;
        }
        Node random = node.random;
        Node copy = node.next;
        copy.random = random == null ? null : random.next;
        setRandom(node.next.next);
    }

    private static void split(Node node, Node result) {
        if (node == null) {
            return;
        }
        Node copy = node.next;
        result.next = copy;
        result = result.next;
        node.next = copy.next;
        split(node.next, result);
    }


    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
