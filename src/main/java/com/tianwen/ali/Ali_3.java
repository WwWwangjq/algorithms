package com.tianwen.ali;

import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * wangjq
 * 2021年04月29日  21:17
 */
public class Ali_3 {

    /**
     *  一个大文件10G, 里面一行行的数字(Integer, 空格分隔)，要找其中出最大的10个数字的值
     *  相同的数字算作一个，
     *  比如最大的数字是  20、10、13、20、3，则最大的3个数字是 20、13、10
     */

    PriorityBlockingQueue<Integer> minQueue = new PriorityBlockingQueue<>(3, Comparator.comparingInt(o -> o));

    public void loadNum(int num) {
        if (minQueue.contains(num)) {
            return;
        }
        minQueue.offer(num);
        if (minQueue.size() == 4) {
            minQueue.poll();
        }
    }

    public static void main(String[] args) {
/*        PriorityBlockingQueue<Integer> minQueue = new PriorityBlockingQueue<>(3, Comparator.comparingInt(o -> o));
        minQueue.add(10);
        minQueue.add(20);
        minQueue.add(13);
        minQueue.add(20);
        minQueue.add(3);
        while (!minQueue.isEmpty()) {
            System.out.println(minQueue.poll());
        }*/
        int[] nums = new int [] {20, 10, 13, 20, 482, 315, 721, 216, 325, 354, 136, 562};
        Ali_3 ali_3 = new Ali_3();
        for (int num : nums) {
            ali_3.loadNum(num);
        }
        System.out.println(Arrays.toString(ali_3.minQueue.toArray()));

    }
}
