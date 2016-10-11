package dp;

import java.util.*;

/**
 * <pre>
 *     现定义数组单调和为所有元素i的f(i)值之和。这里的f(i)函数定义为元素i左边(不包括其自身)小于等于它的数字之和。请设计一个高效算法，计算数组的单调和。
 * 给定一个数组A同时给定数组的大小n，请返回数组的单调和。保证数组大小小于等于500，同时保证单调和不会超过int范围。
 * 测试样例：
 * [1,3,5,2,4,6],6
 * 返回：27
 * </pre>
 */
public class MonoSum {

    public static void main(String[] args) {
        int[] A = {1,2,5,2,4,6};
        int sum = new MonoSum().calcMonoSum2(A,6);
        System.out.println(sum);
    }

    public int calcMonoSum(int[] A, int n) {
        int[] d = new int[n];
        d[0] = 0;
        for (int i = 1; i < n; i++) {
            int j = i - 1;
            while (j > 0 && A[i] < A[j]) {
                j--;
            }
            if(j == 0 && A[i] < A[j]){
                d[i] = 0;
            }else{
                d[i] = d[j] + A[j];
            }
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += d[i];
        }
        return sum;
    }

    public int calcMonoSum2(int[] A, int n) {
        int sum = 0;
        for (int i = 1; i < n; i++) {
            int val = 0;
            for (int j = 0; j < i; j++) {
                if(A[i] >= A[j]){
                    val += A[j];
                }
            }
            sum += val;
        }
        return sum;
    }
}
