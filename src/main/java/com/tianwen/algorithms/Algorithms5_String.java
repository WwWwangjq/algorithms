package com.tianwen.algorithms;

import java.util.Arrays;

/**
 * wangjq
 * 2020年11月07日  17:52
 */
public class Algorithms5_String {

    final static char space = ' ';
    final static char[] replaceArr = new char[]{'%', '2', '0'};

    /**
     * 替换空格
     * 输入字符串 字符串中的空格被替换成%20
     * We are happy -> We%20are%20happy
     */
    public static void main(String[] args) {
        char[] sourceArr = new char[]{'W', 'e', ' ', 'a', 'r', 'e', ' ', 'h', 'a', 'p', 'p', 'y'};
        char[] resultArr = replace(sourceArr);
        // [W, e, 0, 2, %, a, r, e, 0, 2, %, h, a, p, p, y]
        System.out.println(Arrays.toString(resultArr));
    }

    static char[] replace(char[] sourceArr) {
        int spaceCount = 0;
        for (char c : sourceArr) {
            if (c == space) {
                spaceCount++;
            }
        }

        // 替换后数组长度
        char[] resultArr = new char[sourceArr.length - spaceCount + spaceCount * 3];
        // 数组最后一位的下标
        int sub1 = sourceArr.length - 1;
        int sub2 = resultArr.length - 1;
        while (sub1 >= 0) {
            // 非空格直接复制
            if (space != sourceArr[sub1]) {
                resultArr[sub2--] = sourceArr[sub1--];
                continue;
            }
            // 空格 改变下标 替换
            sub1--;
            for (char replace : replaceArr) {
                resultArr[sub2--] = replace;
            }
        }
        return resultArr;
    }
}
