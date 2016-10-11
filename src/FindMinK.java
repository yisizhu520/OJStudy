/**
 * Created by WangJun on 2016/9/7.
 * 查找一个数组中第K个最小的数,数组元素不重复
 */
public class FindMinK {

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9};
        System.out.println(findMinK(a, 1));
    }

    /**
     * 使用类似快速排序的方式去切分元素，查找第K个最小的数，时间复杂度是O(lgn)
     * @param a
     * @param k
     * @return
     */
    static int findMinK(int[] a, int k) {
        k--;
        int low = 0;
        int high = a.length - 1;
        if(k < low || k > high){
            throw new IllegalArgumentException();
        }
        while (low < high) {
            int j = partition(a, low, high);
            if (j > k) high = j - 1;
            else if (j < k) low = j + 1;
            else return a[k];
        }
        return a[low];

    }

    static int partition(int[] a, int low, int high) {
        int cmp = a[low];
        int m = low;
        int n = high + 1;
        while (true) {
            while (a[++m] < cmp) {
                if (m >= high) break;
            }
            while (a[--n] > cmp) {
            }
            if (m >= n) break;
            swap(a, m, n);
        }
        swap(a, low, n);
        return n;
    }

    static void swap(int a[], int m, int n) {
        int temp = a[m];
        a[m] = a[n];
        a[n] = temp;
    }


}
