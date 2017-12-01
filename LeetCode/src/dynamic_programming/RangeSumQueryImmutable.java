package dynamic_programming;

/**
 Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
<pre>
 Example:
 Given nums = [-2, 0, 3, -5, 2, -1]

 sumRange(0, 2) -> 1
 sumRange(2, 5) -> -1
 sumRange(0, 5) -> -3

 Note:
 You may assume that the array does not change.
 There are many calls to sumRange function.
 </pre>
 */
public class RangeSumQueryImmutable {

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray obj = new NumArray(nums);
        System.out.println(obj.sumRange(2,5));
    }

    /**
     * Your NumArray object will be instantiated and called as such:
     * NumArray obj = new NumArray(nums);
     * int param_1 = obj.sumRange(i,j);
     */
    static class NumArray {

        private int[] sums;
        //Q: use a array to save all the combination
        //A: it will take too much space
        //use a array to save the sum from 0 to i
        public NumArray(int[] nums) {
            int length = nums.length;
            sums = new int[length];
            int sum = 0;
            for (int i = 0; i < length; i++) {
                sum += nums[i];
                sums[i] = sum;
            }
        }

        public int sumRange(int i, int j) {
            int minus = i == 0 ? 0 : sums[i-1];
            return sums[j] - minus;
        }
    }





}
