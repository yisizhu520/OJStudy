import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Stack;

/**
 * Created by WangJun on 2016/9/18.
 * <pre>
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 * For example, given s ="aab",
 * Return
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 * </pre>
 *
 * TODO 不会做，木有思路
 */
public class PalindromePartitioning {

    public static void main(String[] args) {
        System.out.println(new Solution().partition("aabb"));
    }

    public static class Solution {

        public ArrayList<ArrayList<String>> partition(String s) {

            ArrayList<ArrayList<String>> al = new ArrayList<ArrayList<String>>();
            if (s.length() == 0)
                return al;
            Stack<String> path = new Stack<String>();
            partition(s, 0, "", al, path);
            return al;

        }

        public void partition(String s, int start, String part_Str, ArrayList<ArrayList<String>> al, Stack<String> path) {
            if (!part_Str.isEmpty()) {
                path.push(part_Str);
            }
            if (start == s.length()) {
                ArrayList<String> re = new ArrayList<String>();
                for (String t : path)
                    re.add(t);
                al.add(re);
                return;
            }
            for (int i = start; i < s.length(); i++) {
                if (isPalindrome(s, start, i)) {
                    String par_Str = s.substring(start, i + 1);
                    partition(s, i + 1, par_Str, al, path);
                    path.pop();
                }
            }
        }

        public boolean isPalindrome(String a, int start, int end) {
            int mid = (start + end) / 2;
            for (int i = start; i < mid; i++) {
                if (a.charAt(i) != a.charAt(end - i)) {
                    return false;
                }
            }
            return true;
        }

//        public boolean isPalindrome(String s,int start,int end)
//        {
//            if(s==""||s.length()==0||start>end||start<0||end>s.length()-1)
//                return false;
//            if(start==end)
//                return true;
//            int i=start;
//            int j=end;
//            while(i<=j)
//            {
//                if(s.charAt(i)!=s.charAt(j))
//                    return false;
//                else
//                {
//                    i++;
//                    j--;
//                }
//            }
//            return true;
//        }

    }


}
