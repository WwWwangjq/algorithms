package com.tianwen.leetcode.滑动窗口;

import java.util.Objects;

/**
 * wangjq
 * 2022年04月17日  14:13
 */
public class LeetCode_643 {
    /**
     *
     //输入：nums = [1,12,-5,-6,50,3], k = 4
     //输出：12.75
     //解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
     //
     //输入：nums = [5], k = 1
     //输出：5.00000
     */
    public static void main(String[] args) {
        LeetCode_643 leetCode_643 = new LeetCode_643();
//        int[] nums = new int [] {1,12,-5,-6,50,3};
//        int k = 2;
        int[] nums = new int [] {-6662,5432,-8558,-8935,8731,-3083,4115,9931,-4006,-3284,-3024,1714,-2825,-2374,-2750,-959,6516,9356,8040,-2169,-9490,-3068,6299,7823,-9767,5751,-7897,6680,-1293,-3486,-6785,6337,-9158,-4183,6240,-2846,-2588,-5458,-9576,-1501,-908,-5477,7596,-8863,-4088,7922,8231,-4928,7636,-3994,-243,-1327,8425,-3468,-4218,-364,4257,5690,1035,6217,8880,4127,-6299,-1831,2854,-4498,-6983,-677,2216,-1938,3348,4099,3591,9076,942,4571,-4200,7271,-6920,-1886,662,7844,3658,-6562,-2106,-296,-3280,8909,-8352,-9413,3513,1352,-8825};
        System.out.println(nums.length);
        int k = 90;
//        int[] nums = new int [] {-1};
//        int k = 1;
        System.out.println(leetCode_643.findMaxAverage(nums, k));
    }

    public double findMaxAverage(int[] nums, int k) {
        if (Objects.isNull(nums)) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int sum = 0;
        int result = Integer.MIN_VALUE;
        while (right < nums.length) {
            sum += nums[right];
            if (right - left + 1 == k) {
                result = Math.max(result, sum);
                sum -= nums[left ++];
            }
            right ++;
        }
        return (double) result / k;
    }
}
