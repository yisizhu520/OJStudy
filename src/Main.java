import com.sun.glass.ui.Size;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println(fun(3, 8));
    }

    static int fun(int a ,int b){
        if(a>=b){
            return a==b?a:b;
        }else{
            return a+b+fun(a + 2, b - 1);
        }
    }

    static void printDistanceSum(int[] array) {
        int[] distance = new int[array.length - 1];
        for (int i = 0; i < array.length - 1; i++) {
            distance[i] = getDistance(array[i], array[i + 1]);
        }
        int sum = 0;
        for (int i = 1; i <= distance.length; i++) {
            sum += getStepSum(distance,i);
        }
        System.out.print(sum);
    }

    static int getStepSum(int[] distance, int step) {
        int sum = 0;
        for (int i = 0; i <= distance.length - step; i++) {
            int temp = distance[i];
            for (int j = 1; j < step; j++) {
                temp += distance[i + j];
            }
            sum += temp;
        }
        return sum;
    }

    static int getDistance(int a, int b) {
        int sum = 0;
        for (int i = a + 1; i < b; i++) {
            if (isPrime(i)) {
                sum++;
            }
        }
        return sum;
    }


    static boolean isPrime(int a) {
        boolean flag = true;
        if (a < 2) {
            return false;
        } else {
            for (int i = 2; i <= Math.sqrt(a); i++) {
                if (a % i == 0) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

}
