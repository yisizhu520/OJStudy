/**
 * Created by WangJun on 2016/9/5.
 * 求最大连续子数组之和
 */
public class MaxSubArray {


    public static void main(String[] args) {
        int[] arr = {1, -2, 4, 8, -4, 7, -1, -5};
        System.out.println(maxSubArrayDP3(arr));
    }


    /**
     * 简单粗暴的遍历,时间复杂度O(n2)
     *
     * @param arr
     * @return
     */
    static int maxSubArray(int arr[]) {
        //[1,-2,4,8,-4,7,-1,-5]
        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;
        //可以用来记录子数组的索引位置
        int startIndex = 0;
        int endIndex = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum > maxSum) {
                    maxSum = sum;
                    startIndex = i;
                    endIndex = j;
                }
            }
        }
        System.out.println(startIndex + "," + endIndex);
        return maxSum;
    }


    /**
     * 动态规划方法,时间复杂度O(n),空间复杂度O(2n)
     * <p>
     * 状态：d[i] : 前i个数里最大连续和；end[i] : 前i个数里以a[i]结尾的最大连续和<br/>
     * 状态方程： end[i] = max{ end[i-1]+a[i],a[i] }; d[i] = max{ d[i-1],end[i] }
     * </p>
     *
     * @param a
     * @return
     */
    static int maxSubArrayDP(int a[]) {
        int[] d = new int[a.length];
        int[] end = new int[a.length];
        d[0] = end[0] = a[0];
        for (int i = 1; i < a.length; i++) {
            end[i] = Math.max(end[i - 1] + a[i], a[i]);
            d[i] = Math.max(d[i - 1], end[i]);
        }
        return d[a.length - 1];
    }

    /**
     * 优化版的动态规划方式，空间复杂度优化为O(1)
     *
     * @param a
     * @return
     */
    static int maxSubArrayDP2(int a[]) {
        int d = a[0];
        int end = a[0];
        for (int i = 1; i < a.length; i++) {
            end = Math.max(end + a[i], a[i]);
            d = Math.max(d, end);
        }
        return d;
    }

    /**
     *
     * @param a
     * @return
     */
    static int maxSubArrayDP3(int a[]) {
        int d = a[0];
        int end = a[0];
        int startIndex = 0;
        int endIndex = 0;
        for (int i = 1; i < a.length; i++) {
            if(end + a[i] >= a[i]){
                end = end + a[i];
            }else {
                end = a[i];
                startIndex = i;
                endIndex = i;
            }
            if(d <= end){
                d = end;
                endIndex = i;
            }
        }
        System.out.println(startIndex + "," + endIndex);
        return d;
    }


}
