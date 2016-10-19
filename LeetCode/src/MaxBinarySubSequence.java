/**
 * Created by WangJun on 2016/10/15.
 * 求最长二进制数组的相同子序列：[01110010000101]，输出0000
 */
public class MaxBinarySubSequence {


    public static void main(String[] args) {
        int[] input = {0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1};
        int start = 0, end = 0, maxStart = 0, maxEnd = 0;
        while (end < input.length) {
            while (end < input.length && input[end] == input[start])
                end++;
            if (end > input.length) {
                end--;
            }
            if (end - start > maxEnd - maxStart) {
                maxStart = start;
                maxEnd = end;
            }
            start = end++;

        }
        System.out.print(maxStart + "," + (maxEnd-1));
    }


}
