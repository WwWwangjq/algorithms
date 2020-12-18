package com.tianwen.sourcecode;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * wangjq
 * 2020年11月07日  20:44
 */
public class SourceCode_Unicode {

    public static void main(String[] args) {
        // Unicode
        // char 2字节 表数范围 0 - 65535
        char c = '香';
//        char c = 'c';
//        char c = 39321;
        // 香
        System.out.println(c);
        // 香 unicode编号: 39321
        System.out.println((int) c);
        // 香 16进制: 9999
        System.out.println(Integer.toHexString(c));
        // 香 2进制: 1001 1001 1001 1001
        System.out.println(Integer.toBinaryString(c));

        // UTF8
        // 该2进制(1001 1001 1001 1001)共16位 与UTF-8规则结合(不同位数有不同规则 这里16位规则为1110xxxx 10xxxxxx 10xxxxxx)
        // 得到 11101001 10100110 10011001
        // 转3字节
        byte[] byteArrUTF8 = new byte[]{(byte) 0xe9, (byte) 0xa6, (byte) 0x99};
        // UTF8输出结果: 香
        System.out.println(new String(byteArrUTF8, StandardCharsets.UTF_8));

        // UTF16
        // 该2进制(1001 1001 1001 1001)共16位 与UTF-16规则
        // 得到 10011001 10011001
        // 转2字节
//        byte[] byteArrUTF16 = new byte[]{(byte) 0x99, (byte) 0x99};
        byte[] byteArrUTF16 = new byte[]{(byte) 0x99, (byte) 0x99};
        // UTF16输出结果: 香
        System.out.println(new String(byteArrUTF16, StandardCharsets.UTF_16));


        System.out.println(Arrays.toString("A".getBytes(StandardCharsets.UTF_8)));
        System.out.println(Arrays.toString("A".getBytes(StandardCharsets.UTF_16)));
    }
}
