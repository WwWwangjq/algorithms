package com.tianwen.leetcode_2022.数组;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * wangjq
 * 2022年04月13日  22:54
 */
public class LeetCode_228 {
    /**
     *
     //输入：nums = [0,1,2,4,5,7]
     //输入：nums = [0,2,3,4,6,8,9]
     * @param args
     */
    public static void main(String[] args) {
        LeetCode_228 leetCode_228 = new LeetCode_228();
//        int[] nums = new int[] {0,1,2,4,5,7};
        int[] nums = new int[] {3,4,5};
//        int[] nums = new int[] {0,2,3,4,6,8,9};
        System.out.println(leetCode_228.summaryRanges(nums));
    }

    public List<String> summaryRanges(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return resultList;
        } else if (nums.length == 1) {
            resultList.add(String.valueOf(nums[0]));
            return resultList;
        }
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (right + 1 < nums.length && nums[right] + 1 == nums[right + 1]) {
                right ++;
                continue;
            }
            resultList.add(String.valueOf(left == right ? nums[left] : nums[left] + "->" + nums[right]));
            left = right + 1;
            right +=1;
        }
        return resultList;
    }

    List<String> resultList = new ArrayList<>();
}
