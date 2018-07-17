package divide_and_conquer;

public class BinarySearch {

    public static void main(String[] args) {
        int[] a = new int[]{1,3,4,6,8,9,10};
        System.out.println(binarySearch(a, 12));
    }

    private static int binarySearch(int[] a, int key) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] > key) {
                high = mid - 1;
            } else if (a[mid] < key) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


}
