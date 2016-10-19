/**
 * Created by WangJun on 2016/10/19.
 * <pre>
 *     Given two strings s and t, write a function to determine if t is an anagram of s.
 *
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 *
 * Note:
 * You may assume the string contains only lowercase alphabets.
 *
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 *
 * Subscribe to see which companies asked this question
 * </pre>
 */
public class ValidAnagram {

    public class Solution {
        /**
         * 如果字符串里全是小写字符的话，用个26长度的整形数组记录每个字符出现的次数即可。时：O(n),空：O(26)
         * 如果字符取值范围变成unicode，则改为hashmap，平均来说，时：O(n), 最坏空O(n)
         * @param s
         * @param t
         * @return
         */
        public boolean isAnagram(String s, String t) {
            if(s.length() != t.length()) return false;
            int[] counts = new int[26];
            for (int i = 0; i < s.length(); i++) {
                counts[s.charAt(i)-'a']++;
            }
            for (int i = 0; i < t.length(); i++) {
                int val = counts[t.charAt(i)-'a'];
                if(val == 0) return false;
                counts[t.charAt(i)-'a'] = val -1;
            }
            return true;
        }
    }

}
