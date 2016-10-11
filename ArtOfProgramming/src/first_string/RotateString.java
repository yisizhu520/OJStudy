package first_string;

/**
 * Created by WangJun on 2016/9/18.
 * 旋转字符串
 * <p>
 * 给定一个字符串，要求把字符串前面的若干个字符移动到字符串的尾部，如把字符串“abcdef”<br/>
 * 前面的2个字符'a'和'b'移动到字符串的尾部，使得原字符串变成字符串“cdefab”。请写一个函数完成此功能，<br/>
 * 要求对长度为n的字符串操作的时间复杂度为 O(n)，空间复杂度为 O(1)。
 * </p>
 */
public class RotateString {


    public static void main(String[] args) {
        System.out.println(BaoliRotate("abcdef",2));
        System.out.println(JDKRotate("abcdef",2));
    }

    /**
     * 暴力移位，不过在java语言中对字符串操作想做到空间复杂度为1是不可能的
     * @param s
     * @param k
     * @return
     */
    static String BaoliRotate(String s, int k) {
        int length = s.length();
        char[] chars = s.toCharArray();
        for (int i = 0; i < k; i++) {
            char ch = chars[0];
            for (int j = 0; j < length-1; j++) {
                chars[j] = chars[j+1];
            }
            chars[length-1] = ch;
        }
        return new String(chars);
    }

    /**
     * 通过java内置的String的方法来实现
     * @param s
     * @param k
     * @return
     */
    static String JDKRotate(String s, int k){
        return s.substring(k) + s.substring(0, k);
    }

    /**
     * 三步反转法，可见ArrayShiftK类里的方法
     * @param s
     * @param k
     * @return
     */
    static String ThreeReverseRotate(String s,int k){
        return null;
    }



}
