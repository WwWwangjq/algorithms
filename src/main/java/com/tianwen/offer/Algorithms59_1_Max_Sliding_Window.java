package com.tianwen.offer;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * wangjq
 * 2021年01月04日  21:07
 */
public class Algorithms59_1_Max_Sliding_Window {

    public static void main(String[] args) {
//        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
//        int k = 3;
        int[] nums = new int[]{1};
        int k = 1;
/*        int[] nums = new int[]{1, -1};
        int k = 1;*/
//        int[] nums = new int[]{9, 10, 9, -7, -4, -8, 2, -6};
//        int k = 5;
        int[] ints = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(ints));
    }

    private static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0 || k > nums.length) {
            return new int [0];
        }
        int n = nums.length;
        int[] result = new int[n - k + 1];
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (!linkedList.isEmpty() && i - k == linkedList.peekFirst()) {
                // 从前往后的顺序
                linkedList.removeFirst();
            }
            while (!linkedList.isEmpty()) {
                if (nums[i] <= nums[linkedList.peekLast()]) {
                    linkedList.addLast(i);
                    break;
                } else {
                    linkedList.removeLast();
                }
            }
            if (linkedList.isEmpty()) {
                linkedList.add(i);
            }
            if (i + 1 >= k) {
                result[i + 1 - k] = nums[linkedList.peekFirst()];
            }
        }
        return result;
    }
}
