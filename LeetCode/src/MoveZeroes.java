/**
 * Created by WangJun on 2016/10/13.
 * <pre>
 *     Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 *
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 * </pre>
 */
public class MoveZeroes {

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        new Solution().moveZeroes(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
    }

    public static class Solution {

        /**
         * 本来一开始打算用类似冒泡排序的方式去做的，发现这样做交换和比较的次数太多了
         * 而其实我们是知道非0和0的数据的最终位置的，所以直接放到该放的位置即可，时间复杂度O(n),赋值次数也很少，但也不是最优的，比如[0,0,0,0,1]
         * @param nums
         */
        public void moveZeroes(int[] nums) {
            int shift = 0;
            for (int i = 0; i < nums.length; i++) {
                if(nums[i] != 0){
                    nums[shift++] = nums[i];
                }
            }
            for (int i = shift; i < nums.length; i++) {
                nums[i] = 0;
            }
        }

        /**
         * 采用交换来做，可以在最坏情况下赋值最少，但是一般情况下，赋值比上一种方式还多
         * @param nums
         */
        public void moveZeroes2(int[] nums) {
            for (int lastNonZeroFoundAt = 0, cur = 0; cur < nums.length; cur++) {
                if (nums[cur] != 0) {
                    int temp = nums[lastNonZeroFoundAt];
                    nums[lastNonZeroFoundAt++] = nums[cur] ;
                    nums[cur] = temp;
                }
            }
        }


        
    }
    
    
    
}
