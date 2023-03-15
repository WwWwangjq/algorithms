package com.tianwen.leetcode_2022.滑动窗口;

/**
 * wangjq
 * 2022年04月18日  21:28
 */
public class LeetCode_567 {
    /**
     //输入：s1 = "ab" s2 = "eidbaooo"
     //输出：true
     //解释：s2 包含 s1 的排列之一 ("ba").
     //
     //输入：s1= "ab" s2 = "eidboaoo"
     //输出：false
     */
    public static void main(String[] args) {
        LeetCode_567 leetCode_567 = new LeetCode_567();
        String s1 = "ab";
        String s2 = "eidbaooo";
//        String s1 = "";
//        String s2 = "eidbaooo";
        System.out.println(leetCode_567.checkInclusion(s1, s2));
    }

    public boolean checkInclusion(String s1, String s2) {
        int[] s1Arr = new int[26];
        for (int i = 0; i < s1.length(); i ++) {
            s1Arr[s1.charAt(i) - 'a'] ++;
        }
        int left = 0;
        int right = 0;
        int[] s2Arr = new int[26];
        while (right < s2.length()) {
            s2Arr[s2.charAt(right) - 'a'] ++;
            if (right - left + 1 == s1.length()) {
                if (uniq(s1Arr, s2Arr)) {
                    return true;
                }
                s2Arr[s2.charAt(left) - 'a'] --;
                left ++;
            }
            right ++;
        }
        return false;
    }

    private boolean uniq(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i ++){
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

/*    private Set<String> listAllPermutation(String s) {
        Set<String> set = new HashSet<>();
        recur(s, 0, new LinkedList<>(), new boolean[s.length()], set);
        return set;
    }

    private void recur(String s, int sub, LinkedList<String> list, boolean[] visited, Set<String> set) {
        if (sub == s.length()) {
            set.add(String.join("", new ArrayList<>(list)));
            return;
        }
        for (int i = 0; i < s.length(); i ++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            list.add(String.valueOf(s.charAt(i)));
            recur(s, sub + 1, list, visited, set);
            visited[i] = false;
            list.removeLast();
        }
    }*/
}
