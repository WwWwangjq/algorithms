package com.tianwen.leetcode_2021.company.byted;

import java.util.HashMap;

/**
 * wangjq
 * 2021年05月19日  21:14
 */
public class AAA {
/*
    给定一个字符串 s ，找出 至多包含 k 个不同字符的最长子串T ，输出子串 T长度
    输入: s = "eceba", k = 2
    输出: 3

    malloc
*/

    public static void main(String[] args) {
        AAA aaa = new AAA();
//        String s = "eceebaabb";
        String s = "eceba";
        int k = 2;
        System.out.println(aaa.getMax(s, k));
    }

    public int getMax(String s, int k) {
        int max = 0;
        String[] arr = s.split("");
        int left = 0, right = 0;
        HashMap<String, Integer> map = new HashMap<>();
        while(right < arr.length) {
            String curStr = arr[right];
            if (map.containsKey(curStr)) {
                map.put(curStr, map.get(curStr) + 1);
                max = Math.max(right - left + 1, max);
                right += 1;
            } else if (map.size() < k) {
                map.put(curStr, 1);
                max = Math.max(right - left + 1, max);
                right += 1;
            } else if (map.size() >= k) {
                String leftStr = arr[left];
                int count = map.get(leftStr) - 1;
                if (count == 0) {
                    map.remove(leftStr);
                } else {
                    map.put(leftStr, count);
                }
                left += 1;
            }
        }
        return max;
    }

    /*public int getMax(String s, int k) {
        int max = 0;
        String[] arr = s.split("");
        int left = 0, right = 0;
        LinkedList<String> list = new LinkedList<>();
        while(right < arr.length) {
            String curStr = arr[right];
            if (list.size() >= k) {
                max = k;
                left += 1;
                list.removeFirst();
            }  else if (list.contains(curStr)) {
                max = Math.max(list.size(), max);
                left += 1;
                list.removeFirst();
                continue;
            }
            list.add(curStr);
            right ++;
        }
        return max;
    }*/
}
