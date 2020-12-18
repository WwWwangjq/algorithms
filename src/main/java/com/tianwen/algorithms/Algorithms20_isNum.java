package com.tianwen.algorithms;

/**
 * wangjq
 * 2020年12月08日  23:45
 */
public class Algorithms20_isNum {


    /**
     * 请实现一个函数用来判断字符串是否能表示一个数值（包括整数小数）
     * 数值:    +100 5e2 -123 3.1416 -1E-16
     * 非数值:  12e 1a3.14 1.2.3 +-5 12e+5.4
     *
     * @param args
     */
    public static void main(String[] args) {
//        String s = "+100";
//        String s = "5e2";
//        String s = "-123";
//        String s = "3.1416";
//        String s = "-1E-16";
//        String s = "12e";
//        String s = "1a3.14";
//        String s = "1.2.3";
//        String s = "+-5";
//        String s = "12e+5.4";
//        String s = "1 ";
//        String s = " ";
//        String s = ".e1";
//        String s = "1 4";
//        String s = ".1.";
//        String s = "+E3";
//        String s = "+.8";
        String s = ".e1";
        System.out.println(isNum(s));
    }

    private static boolean isNum(String s) {
        if (s == null) {
            return false;
        }
        s = format(s);
        if (s.length() == 0) {
            return false;
        }
        return isNum(s.toCharArray());
    }

    private static String format(String s) {
        s = s.trim();
        if (s.endsWith(".")) {
            char[] chars = s.toCharArray();
            int i = 0;
            for (char c : chars) {
                if (c == '.') {
                    i++;
                }
            }
            if (i == 1) {
                s = s.substring(0, s.length() - 1);
            }
        }
        return s;
    }

    private static boolean isNum(char[] str) {
        int i = 0;
        int sLength = str.length;
        if (!legalStart(str[i])) {
            return false;
        }
        if (isSigned(str[i])) {
            if (++i == sLength || !(isNum(str[i]) || isDecimal(str[i]))) {
                return false;
            }
        }
        if (isNum(str[i])) {
            while (isNum(str[i])) {
                if (++i == str.length) {
                    return true;
                }
            }
        }
        if (isDecimal(str[i])) {
            if (++i == sLength || !(isNum(str[i]) || isExponent(str[i]))) {
                return false;
            }
            while (isNum(str[i])) {
                if (++i == str.length) {
                    return true;
                }
            }
        }
        if (isExponent(str[i])) {
            if (++i == sLength) {
                return false;
            }
            if (isSigned(str[i])) {
                if (++i == sLength || !isNum(str[i])) {
                    return false;
                }
            }
            while (isNum(str[i])) {
                if (++i == str.length) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private final static char[] chars = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    private static boolean legalStart(char ch) {
        return isSigned(ch) || isNum(ch) || isDecimal(ch);
    }

    private static boolean isSigned(char ch) {
        return (ch == '+' || ch == '-');
    }

    private static boolean isNum(char ch) {
        for (char c : chars) {
            if (c == ch) {
                return true;
            }
        }
        return false;
    }

    private static boolean isDecimal(char ch) {
        return ch == '.';
    }

    private static boolean isExponent(char ch) {
        return ch == 'e' || ch == 'E';
    }

}
