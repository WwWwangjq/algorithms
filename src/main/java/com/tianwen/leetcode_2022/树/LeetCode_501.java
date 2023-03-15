package com.tianwen.leetcode_2022.树;

import com.tianwen.data.structure.TreeNode;

import java.util.*;
import java.util.Map.Entry;

/**
 * @Author: wangjq
 * @Date: 2022年03月04日 11:08
 */
public class LeetCode_501 {

    public static void main(String[] args) {
        TreeNode treeNode3 = new TreeNode(2, null, null);
        TreeNode treeNode2 = new TreeNode(2, treeNode3, null);
        TreeNode treeNode1 = new TreeNode(1, null, treeNode2);
        LeetCode_501 leetCode_501 = new LeetCode_501();
        System.out.println(Arrays.toString(leetCode_501.findMode(treeNode1)));
    }

    HashMap<Integer, Integer> map = new HashMap<>();

    public int[] findMode(TreeNode root) {
        if (Objects.isNull(root)) {
            return new int[0];
        }
        collectMap(root);
        return collectArr();
    }

    private void collectMap(TreeNode node) {
        if (Objects.isNull(node)) {
            return;
        }
        collectMap(node.left);
        int val = node.val;
        map.put(val, map.containsKey(val) ? map.get(val) + 1 : 1);
        collectMap(node.right);
    }

    private int[] collectArr() {
        int max = 0;
        List<Integer> resultList = new ArrayList<>();
        for (Entry<Integer, Integer> e : map.entrySet()) {
            Integer key = e.getKey();
            Integer value = e.getValue();
            if (value > max) {
                resultList.clear();
                resultList.add(key);
            } else if (value == max) {
                resultList.add(key);
            }
            max = Math.max(max, value);
        }
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i ++) {
            result[i] = resultList.get(i);
        }
        return result;
    }
}
