/**
 * Created by WangJun on 2016/10/20.
 * <pre>
 *     Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 *
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * </pre>
 */
public class MajorityElement {



    public class Solution {

        /**
         * (1)排个序，找中间的那个数就是，这样的话，时间：O(nlgn),感觉太慢了,并且改变了原始数组
         * (2)借助hashmap，时间：O(n)，空间O（n）
         * (3) MARK 找到两个不一样的就删除
         * @param nums
         * @return
         */
        public int majorityElement(int[] nums) {
            //1,2,3,3，4,2,2,2,2
            int major = 0;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if(count == 0){
                    major = nums[i];
                    count++;
                }else{
                    if(major == nums[i]){
                        count++;
                    }else{
                        count--;
                    }
                    if(count > nums.length / 2) return major;
                }
            }
            return major;
        }

    }





}
