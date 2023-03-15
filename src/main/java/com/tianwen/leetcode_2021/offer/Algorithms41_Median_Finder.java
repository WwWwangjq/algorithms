package com.tianwen.leetcode_2021.offer;

import java.util.PriorityQueue;

/**
 * wangjq
 * 2020年12月28日  23:05
 */
public class Algorithms41_Median_Finder {

    /**
     * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
     *
     * 例如，
     *
     * [2,3,4] 的中位数是 3
     *
     * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
     *
     * 设计一个支持以下两种操作的数据结构：
     *
     * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
     * double findMedian() - 返回目前所有元素的中位数。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param args
     */
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> (b - a));
//        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a));
//        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(1);
//        queue.offer(6);
        queue.offer(5);
        System.out.println(queue);
        System.out.println(queue.poll());

        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }

    static class MedianFinder {

        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>((a, b) -> (b - a));
        int numCount;

        /** initialize your data structure here. */
        public MedianFinder() {

        }

        private boolean isOdd() {
            return (numCount & 1) == 1;
        }

        public void addNum(int num) {
            numCount++;
            if (isOdd()) {
                minQueue.add(num);
                Integer min = minQueue.remove();
                maxQueue.add(min);
            } else {
                maxQueue.add(num);
                Integer max = maxQueue.remove();
                minQueue.add(max);
            }
        }

        public double findMedian() {
            if (isOdd()) {
                return maxQueue.size() > 0 ? maxQueue.element() : 0;
            } else {
                if (maxQueue.size() > 0 && minQueue.size() > 0) {
                    return (maxQueue.element().doubleValue() + minQueue.element().doubleValue()) / 2;
                } else if (maxQueue.size() > 0) {
                    return maxQueue.element();
                } else if (minQueue.size() > 0) {
                    return minQueue.element();
                } else {
                    return 0;
                }
            }
        }
    }
}
