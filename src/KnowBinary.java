/**
 * Created by WangJun on 2016/8/24.
 * <p>
 * 描述：
 * 世界上有10种人，一种懂二进制，一种不懂。
 * 那么你知道两个int32整数m和n的二进制表达，有多少个位(bit)不同么？
 */
public class KnowBinary {

    public static void main(String[] args) {
        int n = countBitDiff2(1999, 2299);
        System.out.println(n);
    }

    /**
     * 获得两个整形二进制表达位数不同的数量
     * <p>
     * 思路：将两个int整数转化成二进制字符串，再逐一比较字符串每一个字符是否相同
     * </p>
     *
     * @param m 整数m
     * @param n 整数n
     * @return 整型
     */
    public static int countBitDiff(int m, int n) {
        String mBinary = Integer.toBinaryString(m);
        String nBinary = Integer.toBinaryString(n);
        int sum = 0;
        int length;
        int gap;
        String longer, shorter;
        if (mBinary.length() >= nBinary.length()) {
            length = mBinary.length();
            gap = mBinary.length() - nBinary.length();
            longer = mBinary;
            shorter = nBinary;
        } else {
            length = nBinary.length();
            gap = nBinary.length() - mBinary.length();
            longer = nBinary;
            shorter = mBinary;
        }
        for (int i = 0; i < length; i++) {
            if (i < gap) {
                if (longer.charAt(i) == '1') {
                    sum++;
                }
            } else {
                if (longer.charAt(i) != shorter.charAt(i - gap)) {
                    sum++;
                }
            }

        }
        return sum;
    }

    /**
     * MARK 这种方式相当漂亮
     * <p>思路：直接对两个int整数进行异或运算，再求1的个数
     *
     * @param m
     * @param n
     * @return
     */
    public static int countBitDiff2(int m, int n) {
        int dif = m ^ n;
        int sum = 0;
        //sum =  Integer.bitCount(dif);
        //MARK 不用jdk自带函数计算二进制1的个数,方式很巧妙！
        while (dif != 0) {
            dif = dif & (dif - 1);
            sum++;
        }
        return sum;
    }

}
