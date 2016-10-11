import java.util.*;

/**
 * Created by WangJun on 2016/8/27.
 * 你就是一个画家！你现在想绘制一幅画，但是你现在没有足够颜色的颜料。
 * 为了让问题简单，我们用正整数表示不同颜色的颜料。你知道这幅画需要的n种颜色的颜料，
 * 你现在可以去商店购买一些颜料，但是商店不能保证能供应所有颜色的颜料，所以你需要自
 * 己混合一些颜料。混合两种不一样的颜色A和颜色B颜料可以产生(A XOR B)这种颜色的颜料
 * (新产生的颜料也可以用作继续混合产生新的颜色,XOR表示异或操作)。本着勤俭节约的精神，
 * 你想购买更少的颜料就满足要求，所以兼职程序员的你需要编程来计算出最少需要购买几种颜色的颜料？
 *
 * TODO 不会做，看解析说是用矩阵求极大线性无关组能求出来
 */
public class MixDrink {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = sc.nextInt();
        }

        Set<Integer> noneed = new HashSet<>();
        Set<Integer> need = new HashSet<>();


        for (int i = 0; i < n; i++) {
            int now = values[i];
            if(!noneed.contains(now) && !need.contains(now)){
                need.add(now);
            }
            for (int j = i+1; j < n-1; j++) {
                int next = values[j];
                int mix = now^next;
                for (int k = j+1; k < n; k++) {
                    int temp = values[k];
                    if(mix == temp){
                        noneed.add(temp);
                        break;
                    }

                }
            }

        }

        System.out.println(need.size());
//        System.out.println(noneed);
        HashMap<String,Integer> map = new HashMap<>();
        Iterator<Map.Entry<String,Integer>> i = map.entrySet().iterator();
        while(i.hasNext()){
            Map.Entry<String,Integer> entry = i.next();

        }

    }





}
