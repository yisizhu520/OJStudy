import java.util.Hashtable;

/**
 * Created by WangJun on 2016/9/19.
 *
 */
public class recursion {

    public void test(String testValue){
        Hashtable tempTable = new Hashtable();
        tempTable.put("test",testValue);
    }

    public static void main(String[] args) {
//        for (int i = Integer.MIN_VALUE; i < Integer.MAX_VALUE; i++) {
//            boolean isOdd = isO(i);
//            System.out.println(String.format("i=%d,是否是技术 %b",i,isOdd));
//        }
        //F f= new X();
        int a = 1;
    }

    public static boolean isO(int i){
        return i%2==1;
    }


}

class F{
    static{
        System.out.println("1");
    }


}

class X extends F{
    static {
        System.out.println("2");
    }
}
