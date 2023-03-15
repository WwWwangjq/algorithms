package com.tianwen.leetcode_2022.数组;

import java.util.Arrays;
import java.util.Objects;

/**
 * @Author: wangjq
 * @Date: 2022年03月07日 15:11
 */
public class LeetCode_80 {

    /**
     * //输入：nums = [1,1,1,2,2,3]
     * //输出：5, nums = [1,1,2,2,3]
     * //解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。 不需要考虑数组中超出新长度后面的元素。
     * //
     * //
     * // 示例 2：
     * //
     * //
     * //输入：nums = [0,0,1,1,1,1,2,3,3]
     * //输出：7, nums = [0,0,1,1,2,3,3]
     * //解释：函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。 不需要考虑数组中超出新长度后面的
     * //元素。
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{1};
//        int[] nums = new int[]{1, 1};
//        int[] nums = new int[]{1, 1, 1, 2};
//        int[] nums = new int[]{1, 1, 1, 2, 3, 3, 3, 3, 4};
//        int[] nums = new int[]{1, 1, 2, 3};
//        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
//        int[] nums = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        LeetCode_80 leetCode_80 = new LeetCode_80();
        System.out.println(leetCode_80.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    public int removeDuplicates(int[] nums) {
        if (Objects.isNull(nums) || nums.length < 3) {
            return nums.length;
        }
        int left = 0;
        int right = 1;
        boolean repeat = false;
        while (right < nums.length) {
            if (nums[left] == nums[right] && !repeat) {
                swap(nums, left + 1, right);
                left ++;
                repeat = true;
            } else if (nums[left] != nums[right]) {
                swap(nums, left + 1, right);
                left ++;
                repeat = false;
            }
            right ++;
        }
        return left + 1;
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
