import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ai on 2015-09-30.
 * 描述
 * Lily上课时使用字母数字图片教小朋友们学习英语单词，每次都需要把这些图片按照大小（ASCII码值从小到大）排列收好。
 * 请大家给Lily帮忙，通过C语言解决。
 * <p>
 * <p>
 * 知识点	字符串
 * 运行时间限制	0M
 * 内存限制	0
 * 输入
 * Lily使用的图片包括"A"到"Z"、"a"到"z"、"0"到"9"。输入字母或数字个数不超过1024。
 * <p>
 * <p>
 * 输出
 * Lily的所有图片按照从小到大的顺序输出
 * <p>
 * <p>
 * 样例输入	Ihave1nose2hands10fingers
 * 样例输出	0112Iaadeeefghhinnnorsssv
 */
public class ImageArrange {

    public static void main(String args[]){
        System.out.print("请输入任意字符串: ");
        //创建输入对象
        Scanner sc=new Scanner(System.in);
        String input = sc.nextLine();
        char[] chars = input.toCharArray();
        Arrays.sort(chars);
        System.out.print(String.valueOf(chars));
    }

}
