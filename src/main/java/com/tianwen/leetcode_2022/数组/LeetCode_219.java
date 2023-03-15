package com.tianwen.leetcode_2022.数组;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * wangjq
 * 2022年04月12日  22:39
 */
public class LeetCode_219 {

    /**
     *
     //输入：nums = [1,2,3,1], k = 3
     //输出：true
     //
     // 示例 2：
     //
     //
     //输入：nums = [1,0,1,1], k = 1
     //输出：true
     //
     // 示例 3：
     //
     //
     //输入：nums = [1,2,3,1,2,3], k = 2
     //输出：false
     */
    public static void main(String[] args) {
        LeetCode_219 leetCode_219 = new LeetCode_219();
        int[] nums = new int [] {4,1,2,3,1,5};
//        int[] nums = new int [] {0,1,2,3,2,5};
        int k = 2;
//        int[] nums = new int [] {-1,-1};
//        int k = 1;
//        int[] nums = new int [] {1,0,1,1};
//        int k = 1;
        System.out.println(leetCode_219.containsNearbyDuplicate(nums, k));
    }

/*    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (Objects.isNull(nums) || nums.length < 2) {
            return false;
        }
        int left = 0;
        int right = 1;
        while (right < nums.length) {
            while (right < nums.length && right - left <= k) {
                if (nums[left] == nums[right]) {
                    return true;
                }
                right ++;
            }
            left ++;
            right = left + 1;
        }
        return false;
    }*/


    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (Objects.isNull(nums) || nums.length < 2) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int j = 0; j < nums.length; j ++) {
            int val = nums[j];
            if (map.containsKey(val)) {
                Integer i = map.get(val);
                if (j - i <= k) {
                    return true;
                }
            }
            map.put(val, j);
        }
        return false;
    }
}
