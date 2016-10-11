package dynamic_program;

import sun.text.resources.cldr.ia.FormatData_ia;

import java.util.concurrent.ForkJoinPool;

/**
 * 硬币问题
 * http://www.360doc.com/content/13/0601/00/8076359_289597587.shtml
 * Created by WangJun on 2016/8/25.
 */
public class Coin {


    public static void main(String[] args) {
        int value = coin();
        System.out.println(coinWithValue());
    }

    /**
     * 描述：如果我们有面值为1元、3元和5元的硬币若干枚，如何用最少的硬币凑够11元？
     *
     * @return
     */
    public static int coin(){
        int[] coinValues = {1,3,5};
        int k = 11;
        //状态：d(11)，即凑够11元最少需要多少个硬币
        //状态转移方程：d(i)=min{ d(i-vj)+1 }，其中i-vj >=0，vj表示第j个硬币的面值;

        int[] status = new int[k+1];
        status[0] = 0;
        for (int i = 1; i <= k; i++) {
            int min = 0;
            if(i >= coinValues[0]){
                min = status[i-coinValues[0]]+1;
            }
            for (int j = 1; j < coinValues.length; j++) {
                if(i >= coinValues[j])
                    min = Math.min(status[i-coinValues[j]]+1,min);
            }
            status[i] = min;
        }
        return status[k];
//        return getStatus(coinValues,11);

    }

    static class StatusItem{
        int count = 0;
        String coins = "";
    }

    /**
     * 打印出硬币的组合 551
     * @return
     */
    public static String coinWithValue(){
        int[] coinValues = {1,3,5};
        int k = 11;
        //状态：d(11)，即凑够11元最少需要多少个硬币
        //状态转移方程：d(i)=min{ d(i-vj)+1 }，其中i-vj >=0，vj表示第j个硬币的面值;

        StatusItem[] status = new StatusItem[k+1];
        status[0] = new StatusItem();
        for (int i = 1; i <= k; i++) {
            StatusItem min = new StatusItem();
            if(i >= coinValues[0]){
                min.count = status[i-coinValues[0]].count+1;
                min.coins = status[i-coinValues[0]].coins+coinValues[0];
            }
            for (int j = 1; j < coinValues.length; j++) {
                if(i >= coinValues[j]){
                    if(status[i-coinValues[j]].count+1 < min.count){
                        min.count = status[i-coinValues[j]].count+1;
                        min.coins = status[i-coinValues[j]].coins+coinValues[j];
                    }
                }

            }
            status[i] = min;
        }
        return status[k].coins;
//        return getStatus(coinValues,11);

    }

    /**
     * 硬币的递归实现
     * @param coinValues
     * @param d
     * @return
     */
    static int getStatus(int[] coinValues,int d){
        if(d == 0) return 0;
        int min = getStatus(coinValues,d-coinValues[0])+1;
        for (int j = 1; j < coinValues.length; j++) {
            if(d >= coinValues[j])
                min = Math.min(getStatus(coinValues,d - coinValues[j])+1,min);
        }
        return min;

    }


















}
