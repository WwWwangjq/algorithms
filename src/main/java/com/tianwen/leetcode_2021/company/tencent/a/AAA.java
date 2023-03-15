package com.tianwen.leetcode_2021.company.tencent.a;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * wangjq
 * 2021年05月18日  19:47
 */

/*
19:44
        面试官
        来了，马上
        19:47
        面试官
        给定两个非空的数组，表示两个非负的整数。它们每个数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字[0-9]。
        请你将两个数相加，并以相同形式返回一个表示和的数组。
        你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
        示例：
        输入：l1 = [2,4,3], l2 = [5,6,4]
        输出：[7,0,8]
        解释：342 + 465 = 807 ，结果是返回的807的逆序
        实现一个如下的接口 List add(List l1, List l2)
*/

public class AAA {

    public static void main(String[] args) {
        AAA aaa = new AAA();
        List<Integer> l1 = new ArrayList<>();
        l1.add(2);
        l1.add(4);
        l1.add(3);
        List<Integer> l2 = new ArrayList<>();
        l2.add(5);
        l2.add(6);
        l2.add(4);
        List<Integer> add = aaa.add(l1, l2);
        System.out.println(add);

    }

    public List<Integer> add(List<Integer> l1, List<Integer> l2) {
        LinkedList<Integer> result = new LinkedList<>();
        int size1 = l1.size() - 1;
        int size2 = l2.size() - 1;
        int i1 = 0, i2 = 0, num1 = 0,  num2 = 0;
        boolean flag = false;
        while (i1 <= size1 || i2 <= size2) {
            if (i1 <= size1) {
                num1 = l1.get(i1 ++);
            }
            if (i2 <= size2) {
                num2 = l2.get(i2 ++);
            }
            int num = num1 + num2 >= 9 ? (num1 + num2) % 10 : num1 + num2;
            if (flag) {
                num += 1;
            }
            result.add(num);
            flag = num1 + num2 >= 10;
        }
        return result;
    }
}
