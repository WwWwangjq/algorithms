package com.tianwen.leetcode_2023;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @Author: wangjq
 * @Date: 2023年03月11日 10:34
 */
public class LeetCode_146 {

    class LRUCache {

        private final HashMap<Integer, Integer> dataMap;
        private final LinkedList<Integer> list;
        private final int capacity;

        public LRUCache(int capacity) {
            this.dataMap = new HashMap<>(capacity);
            this.list = new LinkedList<>();
            this.capacity = capacity;
        }

        public int get(int key) {
            if (!dataMap.containsKey(key)) {
                return -1;
            }
            list.remove(Integer.valueOf(key));
            list.addLast(key);
            return dataMap.get(key);
        }

        public void put(int key, int value) {
            if (dataMap.containsKey(key)) {
                list.remove(Integer.valueOf(key));
            } else if (list.size() == capacity) {
                Integer expireKey = list.removeFirst();
                dataMap.remove(expireKey);
            }
            dataMap.put(key, value);
            list.addLast(key);
        }
    }
}
