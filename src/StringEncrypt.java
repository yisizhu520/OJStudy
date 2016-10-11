import java.util.*;

/**
 * Created by WangJun on 2016/9/2.
 */
public class StringEncrypt {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String key = sc.nextLine();
        String src =  sc.nextLine();
        sc.close();
        System.out.print(encrypt(key,src));
//        String[] input = string.split(" ");
//        String src = input[1];
//        for (int i = 2; i < input.length; i++) {
//            src = src+" "+input[i];
//        }
//        System.out.print(encrypt(input[0],src));
    }

    static String encrypt(String key, String src) {
        //删掉key里的重复字符
        key = deleteDuplicate(key);
        key = key.toUpperCase();
        //构建字符映射表
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < key.length(); i++) {
            list.add(key.charAt(i));
        }
        for (int i = 'A'; i <= 'Z'; i++) {
            boolean flag = false;
            for (int j = 0; j < key.length(); j++) {
                if (i == key.charAt(j)) {
                    flag = true;
                }
            }
            if (!flag) {
                list.add((char) i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < src.length(); i++) {
            char ch = src.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                sb.append(list.get(ch - 'A'));
            } else if (ch >= 'a' && ch <= 'z') {
                sb.append((char)((list.get(ch - 'a'))+'a'-'A'));
            }else{
                sb.append(ch);
            }
        }
        return sb.toString();

    }

    static String deleteDuplicate(String key) {
        StringBuilder sb = new StringBuilder();
        HashSet<Character> set = new HashSet<>(key.length());
        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);
            if (!set.contains(ch)) {
                sb.append(ch);
                set.add(ch);
            }
        }
        return sb.toString();
    }


}
