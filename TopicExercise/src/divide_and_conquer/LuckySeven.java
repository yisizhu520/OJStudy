package divide_and_conquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给一组树，求出两个数的所有排列，求出每种排列连接起来是7的个数
 * 比如：1 2 11 22 结果是2 ： 21 112
 */
public class LuckySeven {

    public static void main(String[] args) {
        int[] a = new int[20];
        List<Integer> l = new ArrayList<>(20);
        for (int i = 1; i < 20; i++) {
            a[i] = i;
            l.add(i);
        }
        long now = System.currentTimeMillis();
        System.out.println(luckySevenNum(a));
        System.out.println(System.currentTimeMillis() - now);
        now = System.currentTimeMillis();
        System.out.println("===========");
        arrangeSelect(Arrays.asList(1,2,11,22), new ArrayList<Integer>(), 2);
        System.out.println(num);
        System.out.println(System.currentTimeMillis() - now);
    }

    /**
     * 暴力循环求解排列，复杂度o(n2)
     *
     * @param a
     * @return
     */
    private static int luckySevenNum(int[] a) {
        int num = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (getPair(a[i],a[j]) % 7 == 0) {
                    num++;
                }
                if (getPair(a[j],a[i]) % 7 == 0) {
                    num++;
                }
            }
        }
        return num;
    }

    private static int getPair(int i, int j){
        int jLength = String.valueOf(j).length();
        return i * (int) Math.pow(10, jLength) + j;
    }

    static int num = 0;
    /**
     * 计算A(n,k)
     *
     * @param data
     * @param target
     * @param k
     */
    public static void arrangeSelect(List<Integer> data, List<Integer> target, int k) {
        List<Integer> copyData;
        List<Integer> copyTarget;
        if (target.size() == k) {
            if((getPair(target.get(0),target.get(1)) % 7 == 0)){
                num++;
            }
        }

        for (int i = 0; i < data.size(); i++) {
            copyData = new ArrayList<>(data);
            copyTarget = new ArrayList<>(target);

            copyTarget.add(copyData.get(i));
            copyData.remove(i);

            arrangeSelect(copyData, copyTarget, k);
        }
    }


}
