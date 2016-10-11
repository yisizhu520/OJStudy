package first_string;

import java.util.Arrays;

/**
 * Created by WangJun on 2016/9/18.
 * <p>
 * 给定两个分别由字母组成的字符串A和字符串B，字符串B的长度比字符串A短。请问，如何最快地判断字符串B中所有字母是否都在字符串A里？<br/>
 * <pre>
 *          比如，如果是下面两个字符串：
 * String 1：ABCD
 * String 2：BAD
 * 答案是true，即String2里的字母在String1里也都有，或者说String2是String1的真子集。
 * 如果是下面两个字符串：
 * String 1：ABCD
 * String 2：BCE
 * 答案是false，因为字符串String2里的E字母不在字符串String1里。+
 * 同时，如果string1：ABCD，string 2：AA，同样返回true。
 *      </pre>
 *
 * </p>
 */
public class ContainString {


    public static void main(String[] args) {
        int countx = 0;
        int x = 254;
        while(x != 0){
            countx++;
            x=x&(x-1);
        }
        System.out.println(countx);
    }

    static boolean contain(String A, String B) {
        //暴力法，时间复杂度是O(B.length()*A.length())
        return false;
    }

    /**
     * 可以先排序，再暴力搜索
     *
     * @param A
     * @param B
     * @return
     */
    static boolean containSort(String A, String B) {
        int alength = A.length();
        int blength = B.length();
        char[] achars = A.toCharArray();
        char[] bchars = B.toCharArray();
        Arrays.sort(achars);//ABCD
        Arrays.sort(bchars);//BBCE

        for (int i = 0, j = 0; j < blength; ) {
            while (i < alength && bchars[j] > achars[i]) {
                i++;
            }
            if (i >= alength || bchars[j] < achars[i]) {
                return false;
            }
            j++;
        }

        return true;

    }

    /**
     * 通过hashmap来实现，将A里的所有字符插入到一个map里，再遍历B中字符查找是否都在map中
     *
     * @param A
     * @param B
     * @return
     */
    static boolean containHash(String A, String B) {
        return true;
    }

    /**
     * 类似hashmap，这里通过位运算将每个字符存放到一个hash数里<br/>
     * 不过这里的局限性在于字符范围不能太大，不然不好存放
     *
     * @param A
     * @param B
     * @return
     */
    static boolean containBit(String A, String B) {
        int alength = A.length();
        int blength = B.length();
        char[] achars = A.toCharArray();
        char[] bchars = B.toCharArray();
        int hash = 0;
        for (int i = 0; i < alength; i++) {
            hash |= 1 << (achars[i] - 'A');
        }
        for (int i = 0; i < blength; i++) {
            if ((hash & (1 << (bchars[i] - 'A'))) == 0) {
                return false;
            }
        }
        return true;
    }


}
