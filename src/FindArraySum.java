import java.util.Arrays;

/**
 * Created by WangJun on 2016/9/5.
 * 求数组中两两相加等于20的组合种数。
 */
public class FindArraySum {


    public static void main(String[] args) {
        int[] a = {1,7,17,2,6,3,14};
        findArraySum(a);
    }

    /**
     * 先排序，再从两头往中间遍历,时间复杂度O(nlogn)
     * @param a
     */
    static void findArraySum(int[] a){
        Arrays.sort(a);
        int i = 0;
        int j = a.length-1;
        while(i < j){
            if(a[i] + a[j] > 20){
                j--;
            }else if(a[i] + a[j] < 20){
                i++;
            }else{
                System.out.println(a[i]+","+a[j]);
                i++;
                j--;

            }
        }
    }



}



