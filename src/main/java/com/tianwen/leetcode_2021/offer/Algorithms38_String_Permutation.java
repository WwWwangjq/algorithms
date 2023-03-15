package com.tianwen.leetcode_2021.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * wangjq
 * 2020年12月23日  23:16
 */
public class Algorithms38_String_Permutation {

    public static void main(String[] args) {
        String s = "dkjphedy";
//        String s = "aab";
        System.out.println(Arrays.toString(permutation(s)));
    }

    public static String[] permutation(String s) {
        if (s == null || s.equals("")) {
            return new String[]{};
        }
        char[] source = s.toCharArray();
        ArrayList<String> resultList = new ArrayList<>();
//        collect(source, new char[source.length], 0, new ArrayList<>(), resultList);
        collect(source, new char[source.length], 0, resultList);
        return resultList.toArray(new String[] {});
    }

    private static void collect(char[] source, char[] result, int index, List<String> resultList) {
        int length = source.length;
        if (index == length) {
            resultList.add(new String(result));
            return;
        }
        char[] tempUsed = new char[length];
        for (int i = index; i < length; i ++) {
            if (isUsedChar(tempUsed, source[i])) {
                continue;
            }
            result[index] = source[i];
            tempUsed[i] = source[i];
            swap(source, i, index);
            collect(source, result, index + 1, resultList);
            swap(source, index, i);
        }
    }

    private static void swap(char[] source, int i, int j) {
        char temp = source[i];
        source[i] = source[j];
        source[j] = temp;
    }

    private static boolean isUsedChar(char[] used, char ch) {
        for (char c : used) {
            if (c == ch) {
                return true;
            }
        }
        return false;
    }

    private static void collect(char[] source, char[] result, int index, List<Integer> fixIndex, List<String> resultList) {
        int length = source.length;
        if (index == length) {
            resultList.add(new String(result));
            return;
        }
        char[] tempUsed = new char[length];
        for (int i = 0; i < source.length; i ++) {
            if (fixIndex.contains(i) || isUsedChar(tempUsed, source[i])) {
                continue;
            }
            // 去除
            tempUsed[i] = source[i];
            result[index] = source[i];
            // 固定位数
            fixIndex.add(i);
            collect(source, result, index + 1, fixIndex, resultList);
            fixIndex.remove(index);
        }
    }

}
