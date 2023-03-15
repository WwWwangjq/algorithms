package com.tianwen.leetcode_2023;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Author: wangjq
 * @Date: 2023年03月11日 11:54
 */
public class LeetCode_146_solution2 {

    class LRUCache {

        private final Node vHead;
        private final Node vTail;
        private final int capacity;
        private final Map<Integer, Node> map;

        public LRUCache(int capacity) {
            this.vHead = new Node();
            this.vTail = new Node();
            combine(vHead, vTail);
            this.capacity = capacity;
            this.map = new HashMap<>(capacity);
        }

        public int get(int key) {
            Node node = map.get(key);
            if (Objects.isNull(node)) {
                return -1;
            }
            combine(node.pre, node.next);
            insertHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            if (capacity <= 0) {
                return;
            }
            // 替换
            if (map.containsKey(key)) {
                Node node = map.get(key);
                node.value = value;
                combine(node.pre, node.next);
                insertHead(node);
            } else {
                // 插入
                if (map.size() == capacity) {
                    // 移除
                    Node last = vTail.pre;
                    Node pre = last.pre;
                    combine(pre, vTail);
                    map.remove(last.key);
                }
                Node newHead = new Node();
                newHead.key = key;
                newHead.value = value;
                map.put(key, newHead);
                insertHead(newHead);
            }
        }

        private void insertHead(Node newHead) {
            Node head = vHead.next;
            combine(vHead, newHead);
            combine(newHead, head);
        }

        private void combine(Node n1, Node n2) {
            n1.next = n2;
            n2.pre = n1;
        }
        
        class Node {

            private Node pre;
            private Node next;
            private int key;
            private int value;
            
            @Override
            public int hashCode() {
                return Objects.hash(value);
            }
            
            @Override
            public boolean equals(Object o) {
                if (Objects.isNull(o)) {
                    return false;
                } else if (!(o instanceof Node)) {
                    return false;
                }
                Node otherNode = (Node) o;
                return this.value == otherNode.value;
            }
            
        }
    }
    
}
