/**
 * Created by WangJun on 2016/9/28.
 * <pre>
 *     Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it.
 *     Find and return the shortest palindrome you can find by performing this transformation.
 *
 * For example:
 *
 * Given "aacecaaa", return "aaacecaaa".
 *
 * Given "abcd", return "dcbabcd".
 * </pre>
 */
public class ShortestPalindrome {

    public static void main(String[] args) {
        String res = new Solution().shortestPalindrome2("aacecaaa");
        System.out.println(res);
    }

    public static class Solution {
        /**
         * 比较暴力的做法，从头寻找原字符串里最长的回文子串，再翻转剩下的字符添加到开头即可
         * 时间复杂度O(n2)
         *
         * @param s
         * @return
         */
        public String shortestPalindrome(String s) {
            int n = s.length();
            int index = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = n - 1; i >= 0; i--) {
                if (isPalindrome(s, 0, i)) {
                    index = i;
                    break;
                }
            }
            for (int i = n - 1; i > index; i--) {
                sb.append(s.charAt(i));
            }
            sb.append(s);
            return sb.toString();
        }

        public boolean isPalindrome(String A, int begin, int end) {
            while (begin < end) {
                if (A.charAt(begin) != A.charAt(end)) {
                    return false;
                }
                begin++;
                end--;
            }
            return true;
        }

        /**
         *
         * 巧妙的做法：
         * <pre>
         * 求字符串s的翻转s_rev
         * 将两个字符串进行拼接：{s}#{s_rev}
         * 找出新字符串中最长公共前缀后缀长度comLen
         * s_rev.substring(0, s.length() - comLen)就是在原字符串头部插入的子串部分
         * https://segmentfault.com/a/1190000003059361
         * </pre>
         * 时间复杂度O(n)
         *
         * @param s
         * @return
         */
        public String shortestPalindrome2(String s) {
           StringBuilder sb = new StringBuilder(s);
            return sb.reverse().substring(0,s.length()-getMaxPalindromeLength(s)) + s;
        }

        public int getMaxPalindromeLength(String s){
            StringBuilder sb = new StringBuilder(s);
            sb.append("#").append(new StringBuilder(s).reverse());//为何要连接一个#字符串呢？怕巧合
            int next = 0;
            for (int i = 1; i < sb.length(); i++) {
                if(sb.charAt(i) == sb.charAt(next)){
                    next = next+1;
                }else if(sb.charAt(i) == sb.charAt(0)){
                    next = 1;
                }else{
                    next = 0;
                }
            }
            return next;
        }

    }


}
