package com.tianwen.leetcode_2023;

import java.util.LinkedList;
import java.util.Objects;

/**
 * @Author: wangjq
 * @Date: 2023年03月17日 21:13
 */
public class LeetCode_415 {


    public String addStrings(String num1, String num2) {
        if (Objects.isNull(num1) || num1.length() == 0) {
            return num2;
        } else if (Objects.isNull(num2) || num2.length() == 0) {
            return num1;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            int index1 = num1.length() - 1;
            int index2 = num2.length() - 1;
            int carry = 0;
            while (Math.max(index1, index2) >= 0) {
                char c1 = '0';
                if (index1 >= 0) {
                    c1 = num1.charAt(index1);
                    index1 --;
                }
                char c2 = '0';
                if (index2 >= 0) {
                    c2 = num2.charAt(index2);
                    index2 --;
                }
                int sum = c1 - '0' + c2 - '0' + carry;
                stringBuilder.append(sum % 10);
                carry = sum / 10;
            }
            if (carry != 0) {
                stringBuilder.append(carry);
            }
            return stringBuilder.reverse().toString();
        }
    }
}
