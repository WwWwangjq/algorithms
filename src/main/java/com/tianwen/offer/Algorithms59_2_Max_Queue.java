package com.tianwen.offer;

import java.util.LinkedList;

/**
 * wangjq
 * 2021年01月04日  23:23
 */
public class Algorithms59_2_Max_Queue {


    static class MaxQueue {

        private LinkedList<Integer> maxList = new LinkedList<>();
        private LinkedList<Integer> dataList = new LinkedList<>();

        public MaxQueue() {

        }

        public int max_value() {
            if (maxList.isEmpty()) {
                return -1;
            }
            return maxList.peekFirst();
        }

        public void push_back(int value) {
            dataList.add(value);
            while (!maxList.isEmpty()) {
                if (value <= maxList.peekLast()) {
                    maxList.add(value);
                    break;
                } else {
                    maxList.removeLast();
                }
            }
            if (maxList.isEmpty()) {
                maxList.add(value);
            }
        }

        public int pop_front() {
            if (dataList.isEmpty()) {
                return -1;
            }
            Integer ret = dataList.removeFirst();
            if (ret.equals(maxList.peekFirst())) {
                maxList.removeFirst();
            }
            return ret;
        }
    }
}
