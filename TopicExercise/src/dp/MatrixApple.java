package dp;

/**
 * 平面上有N*M个格子，每个格子中放着一定数量的苹果。你从左上角的格子开始，
 * 每一步只能向下走或是向右走，每次走到一个格子上就把格子里的苹果收集起来，
 * 这样下去，你最多能收集到多少个苹果。
 * Created by WangJun on 2018/4/11.
 */
public class MatrixApple {

    public static void main(String[] args) {
        int[][] A = {
                {1,2,3,4,5},
                {1,31,3,33,5},
                {1,2,3,4,5},
                {66,2,3,4,5},
        };
        getMostApples(4,5,A);
    }

    /**
     * 如果想获取到最多的苹果，那么肯定得计算出终点是每个格子的所有情况下的苹果数，取最大的。
     * 如何计算出所有格子的最终苹果数，而不重复计算走过的格子是关键。
     * 状态转移方程  d[i][j] = max { d[i]d[j-1],d[i-1][j] } + A[i][j],
     * 由此可见，从最左边一行和最上面一列开始遍历计算
     * @param A
     */
    private static void getMostApples(int N, int M, int[][] A){
        int[][] d = new int[N][M];
        for (int i = 0; i < M; i++) {
            d[0][i] = A[0][i];
        }
        for (int i = 0; i < N; i++) {
            d[i][0] = A[i][0];
        }
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                d[i][j] = Math.max(d[i][j-1], d[i-1][j]) + A[i][j];
            }
        }
        System.out.println(d[N-1][M-1]);
    }

}
