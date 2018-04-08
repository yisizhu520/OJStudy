package dp;

/**
 * 一个序列有N个数：A[1],A[2],…,A[N]，求出最长非降子序列的长度。
 */
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        System.out.println(findLongestIncreasingSubsequence(new int[]{1,2,7,6,3,8,4,5}));
    }

    /*
    [1,2,7,6,3,8,4,5]，最长非降子序列的长度的是5:[1,2,3,4,5]
    要求一个序列的lis，从简入深，先求以A[i]结尾的lis
    那么逐步分析：
    d[1] = 1
    d[2] = 2 = d[1] + 1
    d[3] = 3 = d[2] + 1
    d[4] = 3 = max{d[1],d[2]} + 1 ,因为A[4]>A[1],A[2]
    所以状态转移方程是 d[i] = 1, max{d[j]}+1, j<i, A[j] <= A[i]
     */
    private static int findLongestIncreasingSubsequence(int[] A) {
        int[] d = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            d[i] = 1;
            for (int j = 0; j < i; j++) {
                if (A[j] <= A[i] && d[i] < d[j] + 1) {
                    d[i] = d[j] + 1;
                }
            }
        }
        int max = d[0];
        for (int i = 1; i < d.length; i++) {
            max = Math.max(max, d[i]);
        }
        return max;
    }


}
