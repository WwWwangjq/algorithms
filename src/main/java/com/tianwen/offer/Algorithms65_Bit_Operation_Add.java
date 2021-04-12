package com.tianwen.offer;

/**
 * wangjq
 * 2021年01月03日  22:58
 */
public class Algorithms65_Bit_Operation_Add {

    public static void main(String[] args) {
        int a = -1;
        int b = 0;
//        System.out.println(add(a, b));
        System.out.println((2 & 3) << 1);
    }

/*    private static int add(int a, int b) {
        int[] ret = new int[32];
        boolean flag = false;
        int carr = 1;
        for (int i = 31; i >= 0; i --) {
            int al = a & 1;
            int bl = b & 1;
            ret[i] = flag ? al ^ bl ^ carr : al ^ bl;
            if ((al == 1 && bl == 1) || (al == 1 && flag) || (bl == 1 && flag)) {
                flag = true;
            } else {
                flag = false;
            }
            a >>>= 1;
            b >>>= 1;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 32; i ++) {
            builder.append(ret[i]);
        }
        System.out.println(builder.toString().length());
        return Integer.parseInt(builder.toString(), 2);
    }*/
}
