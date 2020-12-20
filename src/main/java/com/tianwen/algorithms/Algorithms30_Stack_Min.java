package com.tianwen.algorithms;


import java.util.Objects;

/**
 * wangjq
 * 2020年12月18日  22:56
 */
public class Algorithms30_Stack_Min {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
/*        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.min());*/

/*        minStack.push(-2);
        minStack.push(0);
        minStack.push(-1);
        System.out.println(minStack.min());
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.min());*/

        minStack.push(2);
        minStack.push(0);
        minStack.push(3);
        minStack.push(0);
        minStack.pop();
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
    }

    static class MinStack {

        private ListNodeDouble stack;
        private ListNodeDouble minStack;

        public MinStack() {
        }

        public void push(int x) {
            if (Objects.isNull(stack)) {
                stack = new ListNodeDouble(x);
                minStack = new ListNodeDouble(x);
            } else {
                ListNodeDouble node = new ListNodeDouble(x);
                stack.next = node;
                node.pre = stack;
                stack = stack.next;
                if (x <= minStack.val) {
                    node = new ListNodeDouble(x);
                    minStack.pre = node;
                    node.next = minStack;
                    minStack = minStack.pre;
                }
            }
        }

        public void pop() {
            if (Objects.isNull(stack)) {
                return;
            }
            if (Objects.isNull(stack.pre)) {
                stack = null;
                minStack = null;
            } else {
                if (stack.val == minStack.val) {
                    minStack = minStack.next;
                }
                stack = stack.pre;
                stack.next = null;
            }
        }

        public int top() {
            if (Objects.isNull(stack)) {
                return 0;
            }
            return stack.val;
        }

        public int min() {
            if (Objects.isNull(minStack)) {
                return 0;
            }
            return minStack.val;
        }

        private class ListNodeDouble {

            public int val;
            public ListNodeDouble next;
            public ListNodeDouble pre;

            public ListNodeDouble(int x) {
                val = x;
            }

            @Override
            public String toString() {
                String s = val + ", ";
                return s;
            }
        }
    }
}
