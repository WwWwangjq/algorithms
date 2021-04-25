package com.tianwen.offer;

/**
 * wangjq
 * 2020年11月07日  17:52
 */
public class Algorithms11_Arr_Rotate {


    /**
     * 旋转数组的最小数字
     * 把一个数组的最开始若干个元素搬到数组的末尾
     * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素
     * 例如 {3, 4, 5, 1, 2} -> {1, 2, 3, 4, 5}的一个旋转，该数组的最小值为1
     *
     * @param args
     */
    public static void main(String[] args) {
//        int[] numbers = new int[]{1, 3, 5};
//        int[] numbers = new int[]{1, 1, 1, 1, 1, 0};
//        int[] numbers = new int[]{3, 4, 5, 7, 2};
//        int[] numbers = new int[]{2, 2, 2, 0, 1};
//        int[] numbers = new int[]{3,4,5,7,0,1,2};
        int[] numbers = new int[]{2,3,4,0,1};
        System.out.println(minArray(numbers));
    }

    private static int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return 0;
        }
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int mid = (right + left) / 2;
            if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else if (numbers[mid] < numbers[right]) {
                right = mid;
            } else {
                right --;
            }
        }
        return numbers[right];
//        return contraction(numbers, 0, numbers.length - 1);
    }

/*    private static int contraction(int[] arr, int lo, int hi) {
        if (lo == hi) {
            return arr[lo];
        }
        int mid = (lo + hi) >> 1;
        if (arr[mid] < arr[hi]) {
            return contraction(arr, lo, mid);
        } else if ((arr[mid] > arr[hi])) {
            return contraction(arr, mid + 1, hi);
        } else {
            return contraction(arr, lo, hi - 1);
        }
    }*/

    
}
