package divide_and_conquer;

import java.util.Arrays;
import java.util.Collections;

public class BigDecimalMultiply {

    public static void main(String[] args) {
        int[] a = new int[]{4, 5, 6};
        int[] b = new int[]{3, 7};
        print(bigDecimalMultiply(b, a));
    }

    private static void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
        System.out.println();
    }

    private static int[] bigDecimalMultiply(int[] a, int[] b) {
        // [1,2,3,4,5,6,7,0] * [8,7,6,5,4,3,2,1]
        int[] result = new int[a.length * b.length];
        // 倒序存储更容易进位操作
        reverse(a);
        reverse(b);
        int extraNow = 0;
        int extraNext = 0;
        for (int i = 0; i < result.length; i++) {
            int number = 0;
            // result[i] = a[1]*b[i-1] + a[2]*b[i-2] + ...
            for (int m = 0; m <= i; m++) {
                int mul1 = m >= b.length ? 0 : b[m];
                int mul2 = i - m >= a.length ? 0 : a[i - m];
                extraNext += mul1 * mul2 / 10;
                number += mul1 * mul2 % 10;
            }
            result[i] = (number + extraNow) % 10;
            extraNext += (number + extraNow) / 10;
            extraNow = extraNext;
            extraNext = 0;
        }
        reverse(result);
        return result;
    }

    private static void reverse(int[] a) {
        for (int i = 0; i < a.length / 2; i++) {
            int temp = a[i];
            a[i] = a[a.length - 1 - i];
            a[a.length - 1 - i] = temp;
        }
    }


}
