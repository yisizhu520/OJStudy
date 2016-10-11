/**
 * 将一个数组循环移动K位
 * Created by WangJun on 2016/9/7.
 */
public class ArrayShiftK {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        arrayShiftK(a, 8);
        print(a);
    }

    /**
     * 通过一个辅助数组来移位，时间复杂度O（n）,需要额外的空间
     *
     * @param a
     * @param k
     */
    static void arrayShiftK(int[] a, int k) {
        int length = a.length;
        k = k % length;
        if (k == 0) return;
        int[] temps = new int[k];
        for (int i = 0; i < k; i++) {
            temps[i] = a[i];
        }
        for (int i = 0; i < length; i++) {
            if (i < k) {
                a[i] = a[i - k + length];
            } else {
                int temp = a[i];
                a[i] = temps[(i - k) % k];
                temps[(i - k) % k] = temp;
            }
        }
    }

    /**
     * 思路：
     * <p>
     * 假如12345678右移2位，则分别逆序子数组123456-->654321，78-->87 <br/>
     * 再全部逆序65432187-->78123456
     * 总共只需要逆序3次即可，不需要额外的空间
     * </p>
     *
     * @param a
     * @param k
     */
    static void arrayShiftKReverse(int[] a, int k) {
        int n = a.length;
        k = k % n;
        if (k == 0) return;
        reverse(a, n - k, n - 1);
        reverse(a, 0, n - k - 1);
        reverse(a, 0, n - 1);
    }

    static void reverse(int[] a, int start, int end) {
        for (; start < end; start++, end--) {
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;
        }
    }

    static void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }


}
