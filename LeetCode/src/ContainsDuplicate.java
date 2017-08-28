import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by WangJun on 2016/10/20.
 * <pre>
 *     Given an array of integers, find if the array contains any duplicates.
 *     Your function should return true if any value appears at least twice
 *     in the array, and it should return false if every element is distinct.
 * </pre>
 */
public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] nums = {3,3};
        boolean result = new Solution().containsDuplicate(nums);
        System.out.println(result);
    }

    public static class Solution {

        /**
         * 借助HashSet，时间：O（n），空间：O（n）
         * 排序，时间：O（nlgn），空间：O（1）
         * @param nums
         * @return
         */
        public boolean containsDuplicate(int[] nums) {
            //1,2,3,4,5,2
            HashSet<Integer> set =new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                if(set.contains(nums[i])){
                    return true;
                }
                set.add(nums[i]);
            }
            return false;
        }

    }

}
