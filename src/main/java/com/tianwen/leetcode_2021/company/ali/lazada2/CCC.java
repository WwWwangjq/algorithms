package com.tianwen.leetcode_2021.company.ali.lazada2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * wangjq
 * 2021年06月03日  21:30
 */
public class CCC {

    /**
     * 问题2：10G带时间戳的N条kv结构乱序文件存在重复数据，在一台2C4G服务器上去重并保留最新时间戳数据有序输出文件
     * 说明：
     * 1、按照时间戳升序排列
     * 2、时间戳相同，按值的字母序升序排列
     * 案例输入：KV（毫秒时间戳+文本值0-50变长字符串，仅包含字母和数字）
     * 1570593273486,03Ad2k33
     * 1570593273487,03Ad233d988dfd
     * 1570593273488,03Ad2k34
     * 1570593273488,03Ad233d988dfd
     * 1570593273489,03Ad2k33
     * 1570593273487,03Ad233d988dfd
     * 1570593273486,03Ad2k34
     * 1570593273492,03Ad233d988dfd
     * 1570593273493,03Ad2k33
     * 1570593273494,03Ad233d988dfd
     * 1570593273494,03Ad234d988dfd
     * 案例输出：
     * 1570593273488,03Ad2k34
     * 1570593273493,03Ad2k33
     * 1570593273494,03Ad233d988dfd
     * 1570593273494,03Ad234d988dfd
     */
    // 时间戳 构造小根堆
    // map去重
    public static void main(String[] args) {
        List<M> list = Arrays.asList(
                new M(1570593273486L, "03Ad2k33"),
                new M(1570593273487L, "03Ad233d988dfd"),
                new M(1570593273488L, "03Ad2k34"),
                new M(1570593273488L, "03Ad233d988dfd"),
                new M(1570593273489L, "03Ad2k33"),
                new M(1570593273487L, "03Ad233d988dfd"),
                new M(1570593273486L, "03Ad2k34"),
                new M(1570593273492L, "03Ad233d988dfd"),
                new M(1570593273493L, "03Ad2k33"),
                new M(1570593273494L, "03Ad233d988dfd"),
                new M(1570593273494L, "03Ad234d988dfd")
                );

        CCC ccc = new CCC();
        list.forEach(ccc::removeDuplicates);
        System.out.println(Arrays.asList(ccc.queue.toArray(new M[] {})));
    }

    private int needNum = 10;

    PriorityBlockingQueue<M> queue = new PriorityBlockingQueue<>(needNum, new M());

    public void removeDuplicates(M m) {
        if (replace(m)) {
            return;
        }
        queue.offer(m);
        if (queue.size() == needNum + 1) {
            queue.poll();
        }
    }

    private boolean replace(M m) {
        M[] ms = queue.toArray(new M[]{});
        for (M mm : ms) {
            if (mm.getS().equals(m.getS())) {
                mm.setL(Math.max(mm.l, m.l));
                return true;
            }
        }
        return false;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class M implements Comparator<M> {
        private Long l;
        private String s;

        @Override
        public int compare(M m1, M m2) {
            if (m1.getL() > m2.getL()) {
                return 1;
            } else if (m1.getL() < m2.getL()) {
                return -1;
            } else {
                return m1.getS().compareTo(m2.getS());
            }
        }
    }
}
