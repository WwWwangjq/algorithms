package com.tianwen.leetcode_2021.company.tencent.a;

/**
 * wangjq
 * 2021年05月18日  20:12
 */
public class BBB {

    // 12345
    // 12345
    public static void main(String[] args) {
        BBB bbb = new BBB();
        String str = "12345";
//        System.out.println(bbb.func(str));
        char[] chars = str.toCharArray();
        char c = '0';
        int result = c;
        System.out.println(result);
    }

    int func(String str) {
        int result = 0;
        String[] split = str.split("");
        int j = 0;
        for (int i = split.length - 1; i >= 0; i --) {
            int c = Integer.parseInt(split[i]);
            result += c * Math.pow(10, j);
            j ++;
        }
        return result;
    }

}
