import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by WangJun on 2016/10/14.
 * <pre>
 *     Given two arrays, write a function to compute their intersection.
 *
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
 *
 * Note:
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 * Follow up:
 * What if the given array is already sorted? How would you optimize your algorithm?
 * --(二分查找)
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * --去nums2里查找nums1
 * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 * --载入nums1到内存，分段载入nums2
 * </pre>
 */
public class IntersectionofTwoArraysII {

    public class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            //MARK 这里用HashMap应该更好
            ArrayList<Integer> nums1List = new ArrayList<>(nums1.length);
            for (int i = 0; i < nums1.length; i++) {
                nums1List.add(nums1[i]);
            }
            ArrayList<Integer> list = new ArrayList<>(Math.min(nums1.length, nums2.length));
            for (int i = 0; i < nums2.length; i++) {
                if(nums1List.contains(nums2[i])){
                    list.add(nums2[i]);
                    nums1List.remove((Integer)nums2[i]);
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
