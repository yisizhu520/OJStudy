import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by WangJun on 2016/10/14.
 * <pre>
 *     Given two arrays, write a function to compute their intersection.
 *
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 *
 * Note:
 * Each element in the result must be unique.
 * The result can be in any order.
 * </pre>
 */
public class IntersectionofTwoArrays {

    public class Solution {

        /**
         * 通过一个hashset来帮助过滤元素
         *
         * @param nums1
         * @param nums2
         * @return
         */
        public int[] intersection(int[] nums1, int[] nums2) {
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < nums1.length; i++) {
                set.add(nums1[i]);
            }
            ArrayList<Integer> list = new ArrayList<>(Math.min(nums1.length, nums2.length));
            for (int i = 0; i < nums2.length; i++) {
                if(set.contains(nums2[i])){
                    list.add(nums2[i]);
                    set.remove(nums2[i]);
                }
            }
            int[] result = new int[list.size()];
            for (int i = 0; i < result.length; i++) {
                result[i] = list.get(i);
            }
            return result;
        }
    }

}
