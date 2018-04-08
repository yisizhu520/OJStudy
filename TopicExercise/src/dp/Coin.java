package dp;

/**
 * 如果我们有面值为1元、3元和5元的硬币若干枚，如何用最少的硬币凑够11元
 */
public class Coin {

    public static void main(String[] args) {
        System.out.println(getLeastCountOfCoin(new int[]{1, 3, 5}, 11));
        inputCombinationOfCoin2(new int[]{1, 3, 5}, 11);
    }

    /**
     * 时间复杂度为O(n)，空间复杂度为O(n)
     *
     * @param coins
     * @param totalAmount
     * @return
     */
    private static int getLeastCountOfCoin(int[] coins, int totalAmount) {
        // 状态di = 凑够i元需要的最少的硬币数量
        // 初始值 d0 = 0, d1 = 1;
        // 状态转移方程 di = min{d[i-vj] + 1}, vj代表第j个硬币的面值
        if (totalAmount == 0) return 0;
        // 忽略掉凑不成的情况
        int[] coinCounts = new int[totalAmount + 1];
        for (int i = 1; i <= totalAmount; i++) {
            //MARK 求出几个值里的最小值，可以用一个边界值来辅助判断
            int best = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i < coins[j]) {
                    break;
                } else if (coinCounts[i - coins[j]] + 1 < best) {
                    best = coinCounts[i - coins[j]] + 1;
                }
            }
            if (best != Integer.MAX_VALUE) {
                coinCounts[i] = best;
            }
        }
        return coinCounts[coinCounts.length - 1];
    }

    /**
     * 打印出最少硬币的组合
     *
     * @param coins
     * @param totalAmount
     */
    private static void inputCombinationOfCoin(int[] coins, int totalAmount) {
        // 状态di = 凑够i元需要的最少的硬币数量
        // 初始值 d0 = 0, d1 = 1;
        // 状态转移方程 di = min{d[i-vj] + 1}, vj代表第j个硬币的面值
        if (totalAmount == 0) return;
        // 忽略掉凑不成的情况
        int[] coinCounts = new int[totalAmount + 1];
        // MARK 用一个数组来存储每个值所需要的硬币组合
        String[] coinStrs = new String[totalAmount + 1];
        for (int i = 0; i < coinStrs.length; i++) {
            coinStrs[i] = "";
        }
        for (int i = 1; i <= totalAmount; i++) {
            int best = Integer.MAX_VALUE;
            int coinIndex = -1;
            for (int j = 0; j < coins.length; j++) {
                if (i < coins[j]) {
                    break;
                } else if (coinCounts[i - coins[j]] + 1 < best) {
                    best = coinCounts[i - coins[j]] + 1;
                    coinIndex = j;
                }
            }
            if (best != Integer.MAX_VALUE) {
                coinCounts[i] = best;
                coinStrs[i] = coinStrs[i - coins[coinIndex]] + " " + coins[coinIndex];
            }
        }
        System.out.println(coinStrs[totalAmount].trim());
    }

    /**
     * 打印出最少硬币的组合2
     *
     * @param coins
     * @param totalAmount
     */
    private static void inputCombinationOfCoin2(int[] coins, int totalAmount) {
        // 状态di = 凑够i元需要的最少的硬币数量
        // 初始值 d0 = 0, d1 = 1;
        // 状态转移方程 di = min{d[i-vj] + 1}, vj代表第j个硬币的面值
        if (totalAmount == 0) return;
        // 忽略掉凑不成的情况
        int[] coinCounts = new int[totalAmount + 1];
        // MARK 用一个数组来存储当前值加了哪个硬币得到的
        int[] coinOffsets = new int[totalAmount + 1];
        for (int i = 1; i <= totalAmount; i++) {
            int best = Integer.MAX_VALUE;
            int coinIndex = -1;
            for (int j = 0; j < coins.length; j++) {
                if (i < coins[j]) {
                    break;
                } else if (coinCounts[i - coins[j]] + 1 < best) {
                    best = coinCounts[i - coins[j]] + 1;
                    coinIndex = j;
                }
            }
            if (best != Integer.MAX_VALUE) {
                coinCounts[i] = best;
                coinOffsets[i] = coins[coinIndex];
            }
        }
        int index = totalAmount;
        while (coinOffsets[index] != 0) {
            System.out.print(coinOffsets[index] + " ");
            index -= coinOffsets[index];
        }
    }


}
