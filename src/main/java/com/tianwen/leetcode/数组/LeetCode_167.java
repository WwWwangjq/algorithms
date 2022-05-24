package com.tianwen.leetcode.数组;

import java.util.Arrays;
import java.util.Objects;

/**
 * wangjq
 * 2022年04月11日  21:43
 */
public class LeetCode_167 {
    /**
     *
     //输入：numbers = [2,7,11,15], target = 9
     //输出：[1,2]
     //解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。
     //
     //输入：numbers = [2,3,4], target = 6
     //输出：[1,3]
     //解释：2 与 4 之和等于目标数 6 。因此 index1 = 1, index2 = 3 。返回 [1, 3] 。
     //
     //输入：numbers = [-1,0], target = -1
     //输出：[1,2]
     */
    public static void main(String[] args) {
        LeetCode_167 leetCode_167 = new LeetCode_167();
//        int[] numbers = new int[] {2,7,11,15};
//        int target = 18;
//        int[] numbers = new int[] {2,3,4};
//        int target = 6;
        int[] numbers = new int[] {-1,0};
        int target = -2;
        int[] result = leetCode_167.twoSum(numbers, target);
        System.out.println(Arrays.toString(result));
    }
    public int[] twoSum(int[] numbers, int target) {
        if (Objects.isNull(numbers) || numbers.length < 1) {
            return new int[2];
        }
        int left = 0;
        int right = numbers.length - 1;
        int[] result = new int[2];
        while (left < right) {
            int mid = (left + right) >> 1;
            if (numbers[left] + numbers[right] > target ) {
                if (numbers[left] + numbers[mid] >= target) {
                    right = mid;
                } else {
                    right -= 1;
                }
            } else if (numbers[left] + numbers[right] < target) {
                if (numbers[mid] + numbers[right] <= target) {
                    left = mid;
                } else {
                    left += 1;
                }
            } else {
                result[0] = left + 1;
                result[1] = right + 1;
                break;
            }
        }
        return result;
    }
}
