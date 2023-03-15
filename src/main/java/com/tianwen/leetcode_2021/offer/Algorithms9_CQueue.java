package com.tianwen.leetcode_2021.offer;

import java.util.Stack;

/**
 * wangjq
 * 2021年01月05日  9:39
 */
public class Algorithms9_CQueue {

    static class CQueue{

        private Stack<Integer> stackIn;
        private Stack<Integer> stackOut;

        public CQueue() {
            this.stackIn = new Stack<>();
            this.stackOut = new Stack<>();
        }

        public void appendTail(int value) {
            stackIn.push(value);
        }

        public int deleteHead() {
            if (stackIn.empty() && stackOut.empty()) {
                return -1;
            }
            if (stackOut.empty()) {
                while (!stackIn.empty()) {
                    stackOut.push(stackIn.pop());
                }
            }
            return stackOut.pop();
        }
    }

    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        cQueue.appendTail(3);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
    }
}
