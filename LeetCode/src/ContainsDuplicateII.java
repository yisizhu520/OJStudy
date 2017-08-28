import java.util.HashSet;

/**
 * Created by WangJun on 2016/10/20.
 * <pre>
 *    Given an array of integers and an integer k, find out whether
 *    there are two distinct indices i and j in the array such that
 *    nums[i] = nums[j] and the difference between i and j is at most k. (New Version)
 * </pre>
 */
public class ContainsDuplicateII {

    public static void main(String[] args) {
        int[] nums = {3,3};
        boolean result = new Solution().containsDuplicate(nums,4);
        System.out.println(result);
    }

    public static class Solution {

        /**
         * 借助HashMap，时间：O（n），空间：O（n）
         * @param nums
         * @return
         */
        public boolean containsDuplicate(int[] nums, int k) {
            return false;
        }

    }

}
