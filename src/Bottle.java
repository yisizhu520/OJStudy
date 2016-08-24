import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by WangJun on 2016/8/12.
 * 3个空瓶换一瓶水
 */
public class Bottle {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> nums = new ArrayList<Integer>(10);
        while(sc.hasNextLine()){
            Integer num = Integer.parseInt(sc.nextLine());
            if(num != 0){
                nums.add(num);
            }else{
                for (int i = 0; i < nums.size(); i++) {
                    num = nums.get(i);
                    if(num < 4){
                        System.out.println(num/3);
                    }else{
                        System.out.println(num/2);
                    }
                }
            }

        }
    }

}
