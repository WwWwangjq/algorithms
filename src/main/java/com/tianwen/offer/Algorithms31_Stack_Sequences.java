package com.tianwen.offer;

import java.util.Objects;
import java.util.Stack;

/**
 * wangjq
 * 2020年12月19日  11:11
 */
public class Algorithms31_Stack_Sequences {


    /**
     * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
     * 例如，序列 {1,2,3,4,5} 是某栈的压栈序列，
     * 序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，
     * 但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列
     *
     * @param args
     */
    public static void main(String[] args) {
//        int[] pushed = new int[]{1, 2, 3, 4, 5};
        int[] pushed = new int[]{1, 0};

//        int[] popped = new int[]{5, 4, 3, 2, 1};
//        int[] popped = new int[]{4, 3, 5, 2, 1};
//        int[] popped = new int[]{4, 3, 5, 1, 2};
        int[] popped = new int[]{1, 0};
        System.out.println(validateStackSequences(pushed, popped));

    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        if (Objects.isNull(pushed) || Objects.isNull(popped)) {
            return false;
        }
        int pushL = pushed.length;
        int popL = popped.length;
        if (popL == 0 && pushL == 0) {
            return true;
        }
        if (popL == 0 || pushL == 0) {
            return false;
        }
        return push(pushed, 0, popped, 0, new Stack<>());
    }

    public static boolean push(int[] pushed, int i, int[] popped, int j, Stack<Integer> stack) {
        if (i == pushed.length && j != popped.length) {
            return false;
        }
        stack.push(pushed[i]);
        while (j < popped.length && !stack.empty() && stack.peek() == popped[j]) {
            stack.pop();
            j++;
        }
        if (j == popped.length) {
            return true;
        }
        return push(pushed, i + 1, popped, j, stack);
    }
}
