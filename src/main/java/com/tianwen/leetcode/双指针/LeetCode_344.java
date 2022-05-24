package com.tianwen.leetcode.双指针;

import java.util.Objects;

/**
 * wangjq
 * 2022年04月30日  19:14
 */
public class LeetCode_344 {
    public void reverseString(char[] s) {
        if (Objects.isNull(s) || s.length == 0) {
            return;
        }
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            swap(s, left, right);
            left ++;
            right -- ;
        }
    }

    private void swap(char[] arr, int left, int right) {
        char c = arr[left];
        arr[left] = arr[right];
        arr[right] = c;
    }
}
