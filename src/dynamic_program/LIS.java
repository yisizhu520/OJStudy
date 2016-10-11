package dynamic_program;

/**
 * 一个序列有N个数：A[1],A[2],…,A[N]，求出最长非降子序列的长度。
 * (讲DP基本都会讲到的一个问题LIS：longest increasing subsequence)
 * Created by WangJun on 2016/8/25.
 */
public class LIS {

    public static void main(String[] args) {
        int[] A = {5, 3, 4, 8, 6, 7};
        System.out.println(lis(A));

    }


    static int lis(int[] A){
        int length = A.length;
        int[] d = new int[length];
        //状态：d[i]，前i个数中以A[i]结尾的最长非降序序列的长度
        //状态方程：d[i] = max{1,d[j]+1},j<i,A[j]<=A[i]
        //用来记录到达A[i]的上一个数的索引
        int[] lastIndexs = new int[length];
        int result = 1;
        int index = 0;
        for (int i = 0; i < length; i++) {
            d[i] = 1;
            lastIndexs[i] = i;
            for (int j = 0; j < i; j++) {
                if(A[i] >= A[j] && d[j]+1>d[i]){
                    d[i] = d[j] +1;
                    lastIndexs[i] = j;
                }
            }
            if(result < d[i]){
                result = d[i];
                index = i;
            }
        }
        StringBuilder sb = new StringBuilder(A[index]+"");
        while(lastIndexs[index] != index){
            index = lastIndexs[index];
            sb.insert(0, " ");
            sb.insert(0,A[index]);
        }
        System.out.println(sb.toString());
        return  result;

    }



}
