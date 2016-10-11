/**
 * Created by WangJun on 2016/9/12.
 * 如何用递归方法求一个整数数组的最大元素
 */
public class IntegerArrayMax {


    public static void main(String[] args) {
        int[] a = {7, 4, 8, 2, 5, 9};
        System.out.println(findMax(a, 0));
    }

    /**
     * 思路：拆解问题，找最大的元素，也就是找第一个元素和剩下元素的最大元素中更大的那个
     *
     * @param a
     */
    static int findMax(int[] a, int index) {
        if (index == a.length - 1) {
            return a[a.length - 1];
        }
        return Math.max(a[index], findMax(a, index + 1));
    }


}
