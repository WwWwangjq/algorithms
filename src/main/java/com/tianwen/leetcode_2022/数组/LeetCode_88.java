package com.tianwen.leetcode_2022.数组;

import java.util.Arrays;
import java.util.Objects;

/**
 * wangjq
 * 2021年05月09日  21:10
 */
public class LeetCode_88 {

    public static void main(String[] args) {
/*        int[] nums1 = new int [] {2, 0};
        int m = 1;
        int[] nums2 = new int [] {1};
        int n = 1;*/
        int[] nums1 = new int [] {1};
        int m = 1;
        int[] nums2 = new int [] {};
        int n = 0;
/*        int[] nums1 = new int [] {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = new int [] {2,5,6};
        int n = 3;*/
        LeetCode_88 leetCode_88 = new LeetCode_88();
        leetCode_88.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (Objects.isNull(nums1) || nums1.length == 0) {
            return;
        }
        int right = nums1.length - 1;
        int right1 = m - 1;
        int right2 = n - 1;
        while (right2 >= 0) {
            int val;
            if (right1 >= 0) {
                val = Math.max(nums1[right1], nums2[right2]);
                nums1[right --] = val;
                if (val == nums1[right1]) {
                    right1 --;
                } else if (val == nums2[right2]) {
                    right2 --;
                }
            } else {
                val = nums2[right2 --];
                nums1[right --] = val;
            }
        }
    }
}
