/**
 * Created by WangJun on 2016/9/19.
 * <pre>
 *     Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.
 *
 * Note:
 * The length of num is less than 10002 and will be ≥ k.
 * The given num does not contain any leading zero.
 * Example 1:
 *
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 * Example 2:
 *
 * Input: num = "10200", k = 1
 * Output: "200"
 * Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
 * Example 3:
 *
 * Input: num = "10", k = 2
 * Output: "0"
 * Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 * </pre>
 */
public class RemoveKDigits {

    public static void main(String[] args) {
        String num = new Solution().removeKdigits2("10203",2);
        System.out.println(num);
    }


    public static class Solution {
        /**
         * 贪心算法的应用，先考虑如何移除1个数字使得原来的数最小
         * 再依次移除K位
         * @param num
         * @param k
         * @return
         */
        public String removeKdigits(String num, int k) {
            //如果是升序，则删除升序的最后一个
            StringBuilder sb = new StringBuilder(num);
            for (int j = 0; j < k; j++) {
                if(sb.length() == 1) return "0";
                while(sb.charAt(0) == '0'){
                    sb.deleteCharAt(0);
                }
                for (int i = 0; i < sb.length() - 1; i++) {
                    if (sb.charAt(i) > sb.charAt(i + 1)) {
                        sb.deleteCharAt(i);
                        break;
                    }else if(i == sb.length()-2){
                        sb.deleteCharAt(sb.length()-1);
                    }
                }
            }
            while(sb.length() != 1 && sb.charAt(0) == '0'){
                sb.deleteCharAt(0);
            }
            return sb.toString();
        }

        /**
         *如果第二位是'0'，则删除掉两位
         * @param num
         * @param k
         * @return
         */
        public String removeKdigits2(String num, int k) {
            //如果是升序，则删除升序的最后一个
            StringBuilder sb = new StringBuilder(num);
            for (int j = 0; j < k; j++) {
                if(sb.length() <= 1) return "0";
                if(sb.length() > 1 && sb.charAt(1) == '0'){
                    sb.deleteCharAt(0).deleteCharAt(0);
                }else{
                    for (int i = 0; i < sb.length() - 1; i++) {
                        if (sb.charAt(i) > sb.charAt(i + 1)) {
                            sb.deleteCharAt(i);
                            break;
                        }else if(i == sb.length()-2){
                            sb.deleteCharAt(sb.length()-1);
                        }
                    }
                }

            }
            return sb.toString();
        }
    }


}
