package com.tianwen.leetcode_2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @Author: wangjq
 * @Date: 2023年03月14日 21:35
 */
public class LeetCode_88 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = new int[]{2, 5, 6};
        int n = 3;
        LeetCode_88 leetCode_88 = new LeetCode_88();
        leetCode_88.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1;
        int index2 = n - 1;
        for (int i = nums1.length - 1; i >= 0; i--) {
            if (index1 < 0) {
                nums1[i] = nums2[index2--];
            } else if (index2 < 0) {
                nums1[i] = nums1[index1--];
            } else {
                nums1[i] = Math.max(nums1[index1], nums2[index2]);
                if (nums1[index1] >= nums2[index2]) {
                    index1--;
                } else {
                    index2--;
                }
            }
        }
    }
}
