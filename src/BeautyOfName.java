import java.util.Scanner;

/**
 * Created by ai on 2015-09-30.
 * 描述
 * 给出一个名字，该名字有26个字符串组成，定义这个字符串的“漂亮度”是其所有字母“漂亮度”的总和。
 * 每个字母都有一个“漂亮度”，范围在1到26之间。没有任何两个字母拥有相同的“漂亮度”。字母忽略大小写。
 * 给出多个名字，计算每个名字最大可能的“漂亮度”。
 * 知识点	字符串
 * 运行时间限制	0M
 * 内存限制	0
 * 输入
 * 整数N，后续N个名字
 * N个字符串，每个表示一个名字
 * <p>
 * 输出
 * 每个名称可能的最大漂亮程度
 * 样例输入	2 zhangsan lisi
 * 样例输出	192 101
 */
public class BeautyOfName {
    public static void main(String args[]){
        //创建输入对象
        Scanner sc=new Scanner(System.in);
        int count = sc.nextInt();
        System.out.println(count);
        String names = sc.nextLine();
        System.out.println(names);
//        String[] tokens = input.split(" ");
//        System.out.println(tokens[tokens.length-1].length());
    }
}
