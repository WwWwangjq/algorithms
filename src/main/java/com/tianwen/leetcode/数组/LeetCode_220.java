package com.tianwen.leetcode.数组;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

/**
 * wangjq
 * 2022年04月13日  21:31
 */
public class LeetCode_220 {
    /**
     * //给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得 abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。
     *
     * //输入：nums = [1,2,3,1], k = 3, t = 0
     * //输出：true
     * //
     * // 示例 2：
     * //
     * //
     * //输入：nums = [1,0,1,1], k = 1, t = 2
     * //输出：true
     * //
     * // 示例 3：
     * //
     * //
     * //输入：nums = [1,5,9,1,5,9], k = 2, t = 3
     * //输出：false
     */
    public static void main(String[] args) {
        LeetCode_220 leetCode_220 = new LeetCode_220();
//        int[] nums = new int [] {1,2,3,1};
//        int k = 3;
//        int t = 0;
        int[] nums = new int [] {1,3,6,2};
        int k = 1;
        int t = 2;
/*
        int[] nums = new int [] {-2147483648,2147483647};
        int k = 1;
        int t = 1;
*/
        /*int[] nums = new int [] {1,0,1,1};
        int k = 1;
        int t = 2;*/
/*        int[] nums = new int [] {1,5,9,1,5,9};
        int k = 2;
        int t = 3;*/
        System.out.println(leetCode_220.containsNearbyAlmostDuplicate(nums, k, t));
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (Objects.isNull(nums) || nums.length < 2) {
            return false;
        }
        Model220[] arr = new Model220[nums.length];
        for (int i = 0; i < nums.length; i ++ ) {
            arr[i] = new Model220(i, nums[i]);
        }
        Arrays.sort(arr);
        int left = 0;
        int right = 1;
        while (right < nums.length) {
            Model220 mLeft = arr[left];
            Model220 mRight = arr[right];
            if (Math.abs(mRight.getSub() - mLeft.getSub()) <= k && mRight.getNum() - mLeft.getNum() <= t) {
                return true;
            }
            if (mRight.getNum() - mLeft.getNum() >= t) {
                left += 1;
                right = left + 1;
                continue;
            }
            right ++;
        }
        return false;
    }


    static class Model220 implements Comparable<Model220> {

        private Integer sub;
        private Long num;

        public Model220(Integer sub, Integer num) {
            this.sub = sub;
            this.num = num.longValue();
        }

        public Integer getSub() {
            return this.sub;
        }

        public Long getNum() {
            return this.num;
        }

        @Override
        public int compareTo(Model220 o) {
            return num.compareTo(o.num);
        }

        @Override
        public String toString() {
            return "sub: " + sub + ", " + "num: " + num;
        }
    }
}
