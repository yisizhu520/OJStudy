import java.util.HashMap;

/**
 * Created by WangJun on 2016/10/19.
 * <pre>
 *     Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 *
 * Examples:
 *
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode",
 * return 2.
 * Note: You may assume the string contain only lowercase letters.
 * </pre>
 */
public class FirstUniqueCharacterinaString {

    public class Solution {

        public int firstUniqChar(String s) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                Integer count = map.get(s.charAt(i));
                if (count == null) {
                    map.put(s.charAt(i), 1);
                }else{
                    map.put(s.charAt(i), count + 1);
                }
            }
            for (int i = 0; i < s.length(); i++) {
                if (map.get(s.charAt(i)) == 1) {
                    return i;
                }
            }
            return -1;
        }
    }

}
