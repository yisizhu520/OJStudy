import java.util.HashSet;

/**
 * Created by WangJun on 2016/9/19.
 * <pre>
 *     Given a string, find the length of the longest substring without repeating characters.
 *
 * Examples:
 *
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 *
 * Given "bbbbb", the answer is "b", with the length of 1.
 *
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * </pre>
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        int length = new Solution().lengthOfLongestSubstring("pwwkew");
        System.out.println(length);
    }


    public static class Solution {

        /**
         * 使用窗口的形式移动，时间复杂度为O(2n),空间复杂度O(n)
         * http://www.aichengxu.com/view/11060
         *
         * @param s
         * @return
         */
        public int lengthOfLongestSubstring(String s) {
            int max = 0, slow = 0, fast = 0;
            HashSet<Character> set = new HashSet<>(s.length());
            while(fast < s.length()){
                if(set.contains(s.charAt(fast))){
                    max = Math.max(max,fast-slow);
                    while(s.charAt(slow) != s.charAt(fast)){
                        set.remove(s.charAt(slow));
                        slow++;
                    }
                    slow++;
                }else{
                    set.add(s.charAt(fast));
                }
                fast++;
            }
            max = Math.max(max,fast-slow);
            return max;
        }

    }


}
