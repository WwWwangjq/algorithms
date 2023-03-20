package com.tianwen.leetcode_2023;

import com.sun.org.apache.regexp.internal.RE;

import java.util.Stack;

/**
 * @Author: wangjq
 * @Date: 2023年03月20日 8:38
 */
public class LeetCode_232 {

    /** 先入先出队列 */
    class MyQueue {

        private final Stack<Integer> in;
        private final Stack<Integer> out;

        public MyQueue() {
            in = new Stack<>();
            out = new Stack<>();
        }

        /** 将元素 x 推到队列的末尾 */
        public void push(int x) {
            in.push(x);
        }

        /** 从队列的开头移除并返回元素 */
        public int pop() {
            if (!out.isEmpty()) {
                return out.pop();
            }
            move();
            return out.pop();
        }

        private void move() {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }

        /** 返回队列开头的元素 */
        public int peek() {
            if (!out.isEmpty()) {
                return out.peek();
            }
            move();
            return out.peek();
        }

        public boolean empty() {
            return out.isEmpty() && in.empty();
        }
    }
}
