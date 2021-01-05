package com.tianwen.algorithms;

import java.util.Arrays;

/**
 * wangjq
 * 2020年11月07日  17:52
 */
public class Algorithms10_3_Arr_Sort {

    /**
     * 对几万名员工的年龄排序 要求O(n)
     * 员工年龄在1-100之间
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] ageArr = new int[]{78, 26, 52, 27, 27, 17, 18, 26, 27, 68};
        System.out.println(Arrays.toString(ageArr));
        sort(ageArr);
        System.out.println(Arrays.toString(ageArr));
    }

    private static void sort(int[] ageArr) {
        // 声明一个统计数组长度100 对应年龄 初始化每一位为0
        int[] statArr = new int[100];
        // 遍历年龄数组 计算每个年龄人数到统计数组
        for (int age : ageArr) {
            statArr[age - 1] += 1;
        }
        // 遍历100次 看每个年龄有统计多少次 有多少次就将该年龄写多少次
        // 最终收集到一个每个年龄重复多少次的数组
        int index = 0;
        for (int i = 0; i < statArr.length; i ++) {
            for (int j = 0; j < statArr[i]; j ++) {
                ageArr[index ++] = i + 1;
            }
        }
    }
}
