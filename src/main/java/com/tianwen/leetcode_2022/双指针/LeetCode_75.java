package com.tianwen.leetcode_2022.双指针;

import java.util.Arrays;
import java.util.Objects;

/**
 * wangjq
 * 2021年05月29日  17:03
 */
public class LeetCode_75 {
    //我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
    //输入：nums = [2,0,2,1,1,0]
    //输出：[0,0,1,1,2,2]
    //
    //
    // 示例 2：
    //
    //
    //输入：nums = [2,0,1]
    //输出：[0,1,2]

    public static void main(String[] args) {
        LeetCode_75 leetCode_75 = new LeetCode_75();
//        int[] nums = new int[] {0};
        int[] nums = new int[] {1};
//        int[] nums = new int[] {2,0,2,1,1,0};
//        int[] nums = new int[] {2,2,1};
//        int[] nums = new int[] {0,2,2,2,0,2,1,1};
//        int[] nums = new int[] {2,1,0,1,2,0,1,1,1,0};
//        int[] nums = new int[] {0,0,1};
//        int[] nums = new int[] {2,0,1};
        leetCode_75.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sortColors(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return;
        }
        int left = 0;
        int red = 0, blue = nums.length - 1;
        while (left <= blue) {
            if (isRed(nums[left])) {
                if (red < left) {
                    swap(nums, red, left);
                }
                red ++;
            } else if (isBlue(nums[left])) {
                swap(nums, left, blue);
                blue --;
                continue;
            }
            left ++;
        }
    }

    private boolean isRed(int num) {
        return num == 0;
    }

    private boolean isWhite(int num) {
        return num == 1;
    }

    private boolean isBlue(int num) {
        return num == 2;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
