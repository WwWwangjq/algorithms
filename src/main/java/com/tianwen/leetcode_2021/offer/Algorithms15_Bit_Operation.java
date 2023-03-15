package com.tianwen.leetcode_2021.offer;

/**
 * wangjq
 * 2020年11月07日  17:52
 */
public class Algorithms15_Bit_Operation {


    /**
     * 位运算
     * @param args
     */
    public static void main(String[] args) {
        int n = -1;
        System.out.println(calculate1(n));
        System.out.println(calculate2(n));
    }

    private static int calculate1(int n) {
        int flag = 1;
        int count = 0;
        // 超出表数范围就成0了
        while (flag != 0) {
            // 一个数 与 flag等于 flag 说明与flag相同位为1
            if ((n & flag) == flag) {
                count++;
            }
            flag <<= 1;
        }
        return count;
    }

    private static int calculate2(int n) {
        int count = 0;
        while (n != 0) {
            // 一个数与它-1相与 会把最小的1变为0
            // 可以执行多少次 代表有多少个1
            n = n & (n -1);
            count ++;
        }
        return count;
    }
}
