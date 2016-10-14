/**
 * Created by WangJun on 2016/10/11.
 * <pre>
 *     Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
 *
 * Example:
 * For num = 5 you should return [0,1,1,2,1,2].
 *
 * Follow up:
 *
 * It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
 * Space complexity should be O(n).
 * Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
 * </pre>
 */
public class CountingBits {

    public static void main(String[] args) {
        new Solution().countBits2(100);
    }

    public static class Solution {
        int count = 0;

        public int[] countBits(int num) {
            for (int i = 0; i <= num; i++) {
                count++;
                System.out.print(Integer.bitCount(i) + " ");
                if (count % 4 == 0) {
                    System.out.println();
                }
            }

            return null;
        }

        /**
         * 这种题目给的限制立马就得想到找规律了
         * [2^(i-1),2^i-1]是由[0,2^(i-1)-1]数组+1得到的
         *
         * @param num
         * @return
         */
        public int[] countBits2(int num) {
            int[] result = new int[num + 1];
            int base = 1;
            int k = 1;
            while (k <= num) {
                for (int i = 0; i < base && k <= num; i++, k++) {
                    result[k] = result[i] + 1;
                }
                base <<= 1;
            }

            return result;
        }
    }


}
