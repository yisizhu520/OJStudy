import java.util.*;

/**
 * Created by WangJun on 2016/9/19.
 * <pre>
 *     Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution.
 *
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * </pre>
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int[] result = new Solution().twoSum(nums,6);
        System.out.print("["+result[0]+","+result[1]+"");
    }


    public static class Solution {
        /**
         * 需要两次遍历
         * @param nums
         * @param target
         * @return
         */
        public int[] twoSum(int[] nums, int target) {
            //时间复杂度O(n)，空间复杂度0(n)
            HashMap<Integer, Integer> map = new HashMap<>(nums.length);
            int[] result = new int[2];
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], i);
            }
            for (int i = 0; i < nums.length; i++) {
                int other = target - nums[i];
                Integer index = map.get(other);
                if(index != null && index != i){
                    result[0] = i;
                    result[1] = index;
                    return result;
                }
            }
            return result;
        }

        /**
         * 只需要一次遍历即可
         * @param nums
         * @param target
         * @return
         */
        public int[] twoSum2(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int complement = target - nums[i];
                if (map.containsKey(complement)) {
                    return new int[] { map.get(complement), i };
                }
                map.put(nums[i], i);
            }
            throw new IllegalArgumentException("No two sum solution");
        }

    }


}
