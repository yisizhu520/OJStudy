package dp;

/**
 * Created by WangJun on 2016/9/28.
 * <pre>
 *     对于一个字符串，我们想通过添加字符的方式使得新的字符串整体变成回文串，但是只能在原串的结尾添加字符，请返回在结尾添加的最短字符串。
 * 给定原字符串A及它的长度n，请返回添加的字符串。保证原串不是回文串。
 * 测试样例：
 * "ab",2
 * 返回："a"
 * </pre>
 */
public class Palindrome {

    public static void main(String[] args) {
        String A = "aabaabaabaababbaaaaabaababaaabbaabbbbabaa";
        String append = new Palindrome().addToPalindrome(A, A.length());
        System.out.println(append);
    }

    public String addToPalindrome(String A, int n){
        int index = n-1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n-1; i++) {
            if(isPalindrome(A,i,n-1)){
                index = i;
                break;
            }
        }
        for (int i = index-1; i >=0 ; i--) {
            sb.append(A.charAt(i));
        }
        return sb.toString();
    }

    public boolean isPalindrome(String A,int begin,int end){
        while(begin < end){
            if(A.charAt(begin) != A.charAt(end)){
                return false;
            }
            begin++;
            end--;
        }
        return true;
    }

    public String shortestPalindrome(String s) {
        int n = s.length();
        int index = n-1;
        StringBuilder sb = new StringBuilder();
        for (int i = n-1; i >= 0; i--) {
            if(isPalindrome(s,0,i)){
                index = i;
                break;
            }
        }
        for (int i = n-1; i >index ; i--) {
            sb.append(s.charAt(i));
        }
        sb.append(s);
        return sb.toString();
    }


}
