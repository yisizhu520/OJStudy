import java.util.Scanner;

public class Main2 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            reverseColor(sc.next());
        }
    }

    static void reverseColor(String str){

        String r = str.substring(1,3);
        String g = str.substring(3,5);
        String b = str.substring(5,7);
        String nr = getHex(r);
        String ng = getHex(g);
        String nb = getHex(b);
        System.out.println("#"+nr+ng+nb);


    }

    static String getHex(String str){
        String s = Integer.toHexString(255-Integer.parseInt(str,16));
        if(s.length() == 1){
            s = "0"+s;
        }
        return s.toUpperCase();
    }



}
