package com.tianwen.offer;

/**
 * wangjq
 * 2021年01月02日  19:23
 */
public class Algorithms58_1_Reverse_Words {

    public static void main(String[] args) {
        String s = "      a good   example       ";
        System.out.println(s);
        System.out.println(reverseWords(s));
    }

    private static String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String[] sArr = s.split(" ");
        String[] result = getResultArr(sArr);
        int m = 0;
        int n = result.length - 1;

        int i = 0;
        int j = sArr.length - 1;
        while (i <= j) {
            if (sArr[i].equals("")) {
                i ++;
                continue;
            }
            if (sArr[j].equals("")) {
                j --;
                continue;
            }
            if (i == j) {
                result[n] = sArr[j];
                break;
            }
            result[n--] = sArr[i++];
            result[m++] = sArr[j--];
        }
        return String.join(" ", result);
    }

    private static String[] getResultArr(String[] sArr) {
        int size = 0;
        for (String str : sArr) {
            if (!str.equals("")) {
                size ++;
            }
        }
        return new String[size];
    }

/*    private static String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String reversal = reversal(s);
        String[] split = reversal.split(" ");
        List<String> result = new LinkedList<>();
        for (String value : split) {
            if (value.equals("")) {
                continue;
            }
            result.add(reversal(value.trim()));
        }
        return String.join(" ", result);
    }

    private static String reversal(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (i < j) {
            swap(chars, i, j);
            i++;
            j--;
        }
        return new String(chars);
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }*/
}
