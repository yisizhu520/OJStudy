package dynamic_program;

import sun.applet.Main;

import java.util.Scanner;

/**
 * Created by WangJun on 2016/9/20.
 * <pre>
 *     题目大意：在一个桌子上放了若干个数值不等的红包，围成一个圈，现在让你选取若干个红包，<br>
 *     要求相邻的两个红包不能同时选取，编程求出选取红包所得钱数的最大值；
 *     http://blog.csdn.net/lrgdongnan/article/details/52506373
 * 输入：
 * 2
 * 1，2，3
 * 1，2，3，4
 * 输出：
 * 3
 * 6
 * </pre>
 */
public class RedPocket {


    public static void main(String[] args) {
        int[] sample = {1,2,3,4,10,6,7,8};
        int i=0;
        System.out.println(--i+i++);
        System.out.println(getMaxSum(sample));
    }

    /**
     * 使用动态规划去解决，由于DP只能处理线性问题，而不能处理环形问题
     * 所以这里要分情况来讨论
     * @param pockets
     * @return
     */
    static int getMaxSum(int[] pockets){
        int val1 = pockets[0] + chooseMaxSum(pockets,2,pockets.length-2);
        int val2 = chooseMaxSum(pockets,1,pockets.length-1);
        return Math.max(val1,val2);
    }

    /**
     * DP状态：d[i][1]:代表从0到i并包含i的红包里的金额最大值
     * DP转移方程：
     * d[i][0] = max( d[i-1][1],d[i-1][0] )
     * d[i][1] = d[i-1][0] + a[i]
     * @param pockets
     * @param begin
     * @param end
     * @return
     */
    static int chooseMaxSum(int[] pockets,int begin,int end){
        int d0 = 0,d1 = pockets[begin];
        for (int i = begin+1; i <= end; i++) {
            int temp = d1;
            d1 = d0 + pockets[i];
            d0 = Math.max(d0,temp);
        }
        return Math.max(d0,d1);
    }





}
