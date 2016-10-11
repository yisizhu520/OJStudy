package dynamic_program;

/**
 * Created by WangJun on 2016/9/28.
 * 数组中的一个数字减去它右边子数组中的一个数字可以得到一个差值，求所有可能的差值中的最大值
 */
public class MaxDiff {


    public static void main(String[] args) {
        int[] a = {1,4,7,19,11,19};
        int result = maxDiff(a);
        System.out.println(result);
    }

    /**
     * 动态规划方法
     * 状态 d[i]:前i+1个元素中数对之差的最大值
     * d[i+1] = max{ d[i],max-a[i] }
     * @param a
     * @return
     */
    static int maxDiff(int[] a){
        int d = Integer.MIN_VALUE;
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            d = Math.max(d,max-a[i]);
            max = Math.max(max,a[i]);
        }
        return d;
    }



}
