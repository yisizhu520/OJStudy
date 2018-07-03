package greedy;

/**
 * 冒泡排序就是用的贪心算法，每次取最小的一个
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] test = new int[]{1, 3, 2, 5, 3, 9, 7};
        sort(test);
        print(test);
    }

    static void print(int[] array) {
        for (int anArray : array) {
            System.out.print(anArray + " ");
        }
    }

    private static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
    }


}
