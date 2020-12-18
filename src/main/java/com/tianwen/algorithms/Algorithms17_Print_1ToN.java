package com.tianwen.algorithms;

/**
 * wangjq
 * 2020年11月07日  17:52
 */
public class Algorithms17_Print_1ToN {


    /**
     * 输入数字n 按顺序打印1-最大的n位十进制数
     * 例如输入n=3,打印从1-999
     *
     * @param args
     */
    public static void main(String[] args) {
        int n = 3;
        printN(n);
    }

    private static void printN(int n) {
        if (n < 0) {
            return;
        } else if (n == 0) {
            System.out.println(0);
            return;
        }
        char[] preArr = new char[n];
        int index = 0;
        println(preArr, index);
    }

    private static void println(char[] preArr, int index) {
        for (int i = 0; i < 10; i++) {
            // int -> char
            preArr[index] = Character.forDigit(i, Character.LETTER_NUMBER);
            if (preArr.length == index + 1) {
                System.out.println(optimizeIfNecessary(new String(preArr)));
            } else {
                println(preArr, index + 1);
            }
        }
    }

    private static String optimizeIfNecessary(String s) {
        s = s.replaceAll("^0*", "");
        if (s.equals("")) {
            s = "0";
        }
        return s;
    }


}
