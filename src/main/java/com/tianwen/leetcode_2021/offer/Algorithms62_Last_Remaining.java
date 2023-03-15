package com.tianwen.leetcode_2021.offer;

import java.util.ArrayList;

/**
 * wangjq
 * 2021年01月03日  21:34
 */
public class Algorithms62_Last_Remaining {

    public static void main(String[] args) {
        int n = 5;
        int m = 3;
        System.out.println(lastRemaining(n, m));
    }

    private static int lastRemaining(int n, int m) {
        if (n == 0 || m == 0) {
            return 0;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        while (list.size() != 1) {
            for (int i = 0; i < m - 1; i ++) {
                list.add(list.remove(0));
            }
            list.remove(0);
        }
        return list.get(0);
    }

/*    private static int lastRemaining(int n, int m) {
        if (n == 0 || m == 0) {
            return 0;
        }
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        while (list.size() != 1) {
            for (int i = 0; i < m - 1; i ++) {
                list.add(list.removeFirst());
            }
            list.removeFirst();
        }
        return list.get(0);
    }*/
}
