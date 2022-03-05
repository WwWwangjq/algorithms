package com.tianwen.tencent.b;

/**
 * wangjq
 * 2021年05月20日  20:03
 */
public class AAA {

    public static void main(String[] args) {
        AAA aaa = new AAA();
        int num = 12345;
        System.out.println(aaa.convert(num));
    }

//    整数， 输出反转后的整数
//  12345 -> 54321
    public int convert(int num) {
        String s = String.valueOf(num);
        char[] chars = s.toCharArray();
        int result = 0;
        for (int i = 0; i < chars.length; i ++) {
            char c = chars[i];
            result += (c - '0') * Math.pow(10, i);
        }
        return result;
    }
}
