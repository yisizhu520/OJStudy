/**
 * Created by WangJun on 2016/9/20.
 * 求n的阶乘末尾有多少个0
 */
public class FactorialZero {


    public static void main(String[] args) {
        //factorialZero(2014);
        factorialZero2(2014);
    }


    static void factorialZero(long n){
        long sum = 1;
        while(n != 0){
            sum *= n;
            n--;
        }
        System.out.println(sum);
        int count = 0;
        while(sum % 10 == 0){
            sum /= 10;
            count++;
        }
        System.out.println(count);
    }

    static void factorialZero2(int n){
        int sum = 0;
        for (int i = n; i > 0 ; i = i/5) {
            sum += i/5;
        }
        System.out.println(sum);
    }



}
