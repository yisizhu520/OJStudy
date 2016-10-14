/**
 * Created by WangJun on 2016/10/14.
 * <pre>
 *     Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
 *
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 *
 * Note:
 * Assume the length of given string will not exceed 1,010.
 *
 * Example:
 *
 * Input:
 * "abccccdd"
 *
 * Output:
 * 7
 *
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 * </pre>
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        int count = new Solution().longestPalindrome("abccccdd");
        System.out.println(count);
    }

    public static class Solution {
        /**
         * 找成对的字符串，或者计算每个字符出现的次数，偶数则全计，奇数则要减1，最后字符串长度是奇数再加1
         *
         * @param s
         * @return
         */
        public int longestPalindrome(String s) {
            int length = s.length();
            int[] lower = new int[52];
            for (int i = 0; i < length; i++) {
                if (s.charAt(i) >= 'a') {
                    lower[s.charAt(i) - 'a']++;
                } else {
                    lower[s.charAt(i) - 'A'+26]++;
                }
            }
            int count = 0;
            boolean hasSingle = false;
            for (int i = 0; i < lower.length; i++) {
                if (lower[i] % 2 == 0) {
                    count += lower[i];
                } else {
                    count += lower[i] - 1;
                    hasSingle = true;
                }
            }
            if (hasSingle) {
                count++;
            }
            return count;
        }

    }




}
