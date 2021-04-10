package com.tianwen.day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * wangjq
 * 2021年01月05日  18:13
 */
public class Algorithms_2021_01_05_Large_Group_Positions {

    public static void main(String[] args) {
//        String s = "abbxxxxzzy";
        String s = "aaa";
        List<List<Integer>> lists = largeGroupPositions(s);
        lists.forEach(System.out::print);
    }

    private static List<List<Integer>> largeGroupPositions(String s) {
        int i = 0, j = 0;
        List<List<Integer>> retList = new ArrayList<>();
        while (j < s.length()) {
            if (s.charAt(j) != s.charAt(i)) {
                if (j - i >= 3) {
                    retList.add(Arrays.asList(i, j - 1));
                }
                i = j;
            }
            j++;
        }
        if (j - i >= 3) {
            retList.add(Arrays.asList(i, j - 1));
        }
        return retList;
    }
}
