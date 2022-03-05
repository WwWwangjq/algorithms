package com.tianwen;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * wangjq
 * 2021年06月20日  20:14
 */
public class HuaWeiOD1 {

    // a0 1
    // a1 2
    // a2 4
    // ai = a[i-1] + a[i-2] + a[i-3]
    // a3 = a2 + a1 + a0
    // a4 = a3 + a2 + a1
    // abcde -> bdgkr

    public static void main(String[] args) {
        HuaWeiOD1 huaWeiOD1 = new HuaWeiOD1();
//        String str = "abcde";
//        String str = "xy";
//        String str = "y";
//        System.out.println(huaWeiOD1.encrypt(str));

        List<String> list = Arrays.asList("abcde", "xy");
        list.forEach(str -> System.out.println(huaWeiOD1.encrypt(str)));
    }

    private String encrypt(String str) {
        if (Objects.isNull(str)) {
            return null;
        } else if (str.length() == 0) {
            return "";
        }
        int length = str.length();
        char[] charArr = str.toCharArray();
        int[] secretArr = buildAArr(length);
        char[] result = new char[length];
        for (int i = 0; i < length; i ++) {
            result[i] = encrypt(charArr[i], secretArr[i]);
        }
        return String.valueOf(result);
    }

    private char encrypt(char source, int secret) {
        int r = source + secret;
        if (r <= 'z') {
            return (char) r;
        } else {
            return (char) (r % ('z') + 'a' - 1);
        }
    }

    private int[] buildAArr(int n) {
        int[] aArr = new int[n];
        if (n == 0) {
            return aArr;
        }
        aArr[0] = 1;
        if (n == 1) {
            return aArr;
        }
        aArr[1] = 2;
        if (n == 2) {
            return aArr;
        }
        aArr[2] = 4;
        if (n == 3) {
            return aArr;
        }
        return recur(aArr, 3, n);
    }

    private int[] recur(int[] aArr, int i, int n) {
        aArr[i] = aArr[i - 1] + aArr[i - 2] + aArr[i - 3];
        if (++ i == n) {
            return aArr;
        }
        return recur(aArr, i, n);
    }
}

