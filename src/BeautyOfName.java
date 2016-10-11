//~--- JDK imports ------------------------------------------------------------

import java.util.*;

/**
 * Created by ai on 2015-09-30.
 * 描述
 * 给出一个名字，该名字有26个字符串组成，定义这个字符串的“漂亮度”是其所有字母“漂亮度”的总和。
 * 每个字母都有一个“漂亮度”，范围在1到26之间。没有任何两个字母拥有相同的“漂亮度”。字母忽略大小写。
 * 给出多个名字，计算每个名字最大可能的“漂亮度”。
 * 知识点  字符串
 * 运行时间限制       0M
 * 内存限制 0
 * 输入
 * 整数N，后续N个名字
 * N个字符串，每个表示一个名字
 * <p/>
 * 输出
 * 每个名称可能的最大漂亮程度
 * 样例输入 2 zhangsan lisi
 * 样例输出 192 101
 */
public class BeautyOfName {

    /**
     * Method description
     *
     *
     * @param args
     */
    public static void main(String args[]) {

        // 创建输入对象
        Scanner  sc     = new Scanner(System.in);
        String   input  = sc.nextLine();
        String[] tokens = input.split(" ");

        for (int i = 1; i < tokens.length; i++) {
            int level = getByMap(tokens[i]);

//          int level = getBeautyLevel(tokens[i]);
            System.out.print(level + " ");
        }
    }

    /**
     * 给定字符串，返回其最大漂亮度
     *
     * @param string
     * @return
     */
    static int getBeautyLevel(String string) {
        string = string.toLowerCase();

        char[] chars = string.toCharArray();    // 记得处理大小写！

        Arrays.sort(chars);

        List<Integer> result = new ArrayList<>();
        int           count  = 1;
        char          now    = chars[0];

        for (int i = 1; i < chars.length; i++) {
            if (now == chars[i]) {
                count++;
            } else {
                result.add(count);
                now   = chars[i];
                count = 1;
            }

            // 需要处理最后一个数据
            if (i == chars.length - 1) {
                result.add(count);
            }
        }

        Collections.sort(result);

//      System.out.println(result);
        int sum = 0;

        for (int i = 0; i < result.size(); i++) {
            sum += result.get(i) * (26 + 1 - result.size() + i);
        }

        return sum;
    }

    /**
     * 通过map数据结构来解决
     * @param string
     * @return
     */
    static int getByMap(String string) {
        string = string.toLowerCase();

        char[]                  chars = string.toCharArray();    // 记得处理大小写！
        Map<Character, Integer> map   = new HashMap<>();

        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) == null) {
                map.put(chars[i], 1);
            } else {
                map.put(chars[i], map.get(chars[i]) + 1);
            }
        }

        int[]    result = new int[map.size()];
        Iterator iter   = map.entrySet().iterator();
        int      j      = 0;

        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Integer   val   = (Integer) entry.getValue();

            result[j] = val;
            j++;
        }

        Arrays.sort(result);

        int sum = 0;

        for (int i = 0; i < result.length; i++) {
            sum += result[i] * (26 + 1 - result.length + i);
        }

        return sum;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
