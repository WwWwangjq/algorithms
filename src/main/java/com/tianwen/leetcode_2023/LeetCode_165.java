package com.tianwen.leetcode_2023;

/**
 * @Author: wangjq
 * @Date: 2023年03月25日 22:17
 */
public class LeetCode_165 {

    public int compareVersion(String version1, String version2) {
        String[] vArr1 = version1.split("\\.");
        String[] vArr2 = version2.split("\\.");
        for (int i = 0; i < Math.max(vArr1.length, vArr2.length); i ++) {
            int temp1 = i < vArr1.length ? Integer.parseInt(vArr1[i]) : 0;
            int temp2 = i < vArr2.length ? Integer.parseInt(vArr2[i]) : 0;
            if (temp1 == temp2) {
                continue;
            }
            return temp1 > temp2 ? 1 : -1;
        }
        return 0;
    }

}
