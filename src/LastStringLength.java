import java.util.Scanner;

/**
 * Created by ai on 2015-09-29.
 * 描述
 * 计算字符串最后一个单词的长度，单词以空格隔开。
 * 知识点	字符串,循环
 * 运行时间限制	0M
 * 内存限制	0
 * 输入
 * 一行字符串，长度小于128。
 * 输出
 * 整数N，最后一个单词的长度。
 * 样例输入	hello world
 * 样例输出	5
 */
public class LastStringLength {

    public static void main(String args[]){
        System.out.print("请输入任意字符串: ");
        //创建输入对象
        Scanner sc=new Scanner(System.in);
        String input = sc.nextLine();
        String[] tokens = input.split(" ");
        System.out.println(tokens[tokens.length-1].length());
    }

}
