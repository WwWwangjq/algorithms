package com.tianwen.offer;

import java.util.Objects;

/**
 * wangjq
 * 2020年11月07日  11:17
 */
public class Algorithms3_1_Arr {

    /**
     * 找出数组中的重复数字
     * 数组中的数字取值范围不大于 （数组长度-1）
     */
    public static void main(String[] args) {
        int[] arr = new int[] {2, 3, 0, 1, 2, 5, 3};
//        Integer[] arr = new Integer[] {2, 7, 3, 0, 5, 4, 6, 1};
//        Integer[] arr = new Integer[] {2, 3, 1, 0, 0};
        Integer repeat = findRepeat(arr);
        System.out.println(repeat);
    }


    /**
     *
     * 从头到尾遍历数组
     * 将当前下标对应的值取出 再将该值作为下标再取出对应的值 交换一次
     * 再重复这个过程 直到数组当前下标与值一致 说明该位置已经ok 再看下一个下标
     * 以此类推 只要有重复数字出现 必然会比检测到
     * @param nums
     * @return
     */
    static int findRepeat(int[] nums) {
        int result = 0;
        if (Objects.isNull(nums) || nums.length == 0) {
            return result;
        }
        for (int i = 0; i < nums.length; i ++) {
            while (i != nums[i]) {
                int temp1 = nums[i];
                if (nums[temp1] == temp1) {
                    return temp1;
                }
                swap(nums, i, temp1);
            }
/*            for (Integer k : nums) {
                System.out.print(k + " ");
            }
            System.out.println();*/
        }
        return result;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr [j] = temp;
    }

}
