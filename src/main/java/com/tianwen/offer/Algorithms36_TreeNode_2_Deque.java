package com.tianwen.offer;

/**
 * wangjq
 * 2020年12月21日  23:20
 */
public class Algorithms36_TreeNode_2_Deque {

    /**
     * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
     *
     * @param args
     */
    public static void main(String[] args) {
        Node node68 = new Node(68);
        Node node59 = new Node(59);
        Node node58 = new Node(58);
        Node node8 = new Node(8);
        Node node8_ = new Node(-8);
        Node node34_ = new Node(-34);
        Node node55 = new Node(55);
        Node node99_ = new Node(-99);
        Node node27 = new Node(27);

        node27.left = node99_;
        node27.right = node55;

        node99_.right = node34_;
        node34_.right = node8_;
        node8_.right = node8;

        node55.right = node58;
        node58.right = node59;
        node59.right = node68;

        Node root = node27;
        Node node = treeToDoublyList(root);
        System.out.println(node);
    }

    static Node pre, head;

    public static Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        recur(root);
        pre.right = head;
        head.left = pre;
        return head;
    }

    private static void recur(Node cur) {
        if (cur == null) {
            return;
        }
        recur(cur.left);
        if (pre != null) {
            pre.right = cur;
        } else {
            head = cur;
        }
        cur.left = pre;
        pre = cur;
        recur(cur.right);
    }

    private static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }

        @Override
        public String toString() {
            return val + "";
        }
    }
}
