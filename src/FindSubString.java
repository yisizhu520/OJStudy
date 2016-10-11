/**
 * Created by WangJun on 2016/9/26.
 * 子字符串匹配
 */
public class FindSubString {

    public static void main(String[] args) {
        String A = "aaceaaceaaab";
        String B = "aaceaaa";
        int result = findSubKMP(A, B);
        System.out.println(result);
//        int[] next = getNext("ABADAB");
//        for (int i = 0; i < next.length; i++) {
//            System.out.println(next[i]);
//        }
    }

    /**
     * 从A里寻找B，暴力算法
     * 时间复杂度O(mn)
     *
     * @param A
     * @param B
     * @return
     */
    static int findSub(String A, String B) {
        //ABCDAADABCDABDD，ABCDAB
        int i = 0, j = 0, k = 0;
        while (k + B.length() <= A.length() && j < B.length()) {
            if (B.charAt(j) == A.charAt(i + k)) {
                if (j == B.length() - 1) {
                    return k;
                }
                j++;
                i++;
            } else {
                k++;
                i = 0;
                j = 0;
            }
        }
        return -1;
    }

    static int findSubKMP(String A, String B) {
        int i = 0, j = 0, k = 0;
        int[] next = getNext(B);
        while (k + B.length() <= A.length() && j < B.length()) {
            if (B.charAt(j) == A.charAt(i + k)) {
                if (j == B.length() - 1) {
                    return k;
                }
                j++;
                i++;
            } else {
                if(j == 0) j=1;//语义不好
                k += j - next[j - 1];
                i = next[j - 1];
                j = next[j - 1];
            }
        }
        return -1;
    }

    /**
     * 求出next数组：也就是帮助确定当字符不匹配的时候该移动多少位的数组
     * next[i] = 0,sub[next[i-1]+1]!=sub[i];sub[0]!=sub[i]
     * next[i] = 1,sub[next[i-1]+1]!=sub[i],sub[0]==sub[i]
     * next[i] = next[i-1]+1;sub[next[i-1]+1]=sub[i]
     *
     * @param sub
     * @return
     */
    static int[] getNext(String sub) {
        int[] next = new int[sub.length()+1];
        next[1] = 0;
        //next[i]代表前i-1个字符的匹配值
        for (int i = 2; i < sub.length(); i++) {
            if (sub.charAt(next[i - 1]) != sub.charAt(i-1)) {
                if (sub.charAt(0) != sub.charAt(i-1)) {
                    next[i] = 0;
                } else {
                    next[i] = 1;
                }
            } else {
                next[i] = next[i - 1] + 1;
            }
        }
        return next;
    }

}
