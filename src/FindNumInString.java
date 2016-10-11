import java.util.*;

/**
 * Created by WangJun on 2016/9/7.
 */
public class FindNumInString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        sc.close();
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch >= 48 && ch <= 57) {
                nums.add(ch-48);
            }
        }
        Collections.sort(nums);
        for (int i = 0; i < nums.size(); i++) {
            System.out.print(nums.get(i));
        }

    }


}
