import java.util.Random;

/**
 * Created by WangJun on 2016/9/7.
 * 八皇后问题：8*8的格子里，摆放8个皇后，任意两个皇后都不在同一行，同一列，同一斜线上。
 */
public class EightQueue {

    static int oktimes;

    public static void main(String[] args) {
        placeQueue(0);
        System.out.println("\n\n\n八皇后共有" + oktimes + "个解法");
    }

    static int columnForRow[] = new int[8];

    static boolean check(int row) {
        for (int i = 0; i < row; i++) {
            int diff = Math.abs(columnForRow[i] - columnForRow[row]);
            //如果在同一列，或者是同一斜线上
            if (diff == 0 || diff == (row - i)) {
                return false;
            }
        }
        return true;
    }


    static void placeQueue(int row) {
        if (row == 7) {
            printBoard();
            return;
        }
        for (int i = 0; i < 8; i++) {
            columnForRow[i] = i;
            if (check(row)) {
                placeQueue(row + 1);
            }
        }
    }

    static void printBoard() {
        for (int i = 0; i < 8; i++) {
            printRow(columnForRow[i]);
        }
    }

    static void printRow(int column) {
        for (int i = 1; i < column; i++) {
            System.out.print("_");
        }
        System.out.print("*");
        for (int i = column; i < 8; i++) {
            System.out.print("_");
        }
        System.out.println();
    }


}

class Queen_Java {

    int QUEEN_COUNT = 8;    //是多少皇后
    static final int EMPTY = 0;
    int[][] count = new int[QUEEN_COUNT][QUEEN_COUNT];
    int[] QueenIndex = new int[QUEEN_COUNT];
    int resultCount = 0;
    long time = System.currentTimeMillis();

    public void putQueenIndex(int row) {
        for (int col = 0; col < QUEEN_COUNT; col++) {
            if (count[row][col] == EMPTY) {

                for (int iRow = row + 1; iRow < QUEEN_COUNT; iRow++) {
                    //这一行的这一列、这一斜线全部标识为不能放皇后
                    count[iRow][col]++;
                    if ((col - iRow + row) >= 0) {
                        count[iRow][col - iRow + row]++;
                    }
                    if ((col + iRow - row) < QUEEN_COUNT) {
                        count[iRow][col + iRow - row]++;
                    }
                }
                QueenIndex[row] = col;
                if (row == QUEEN_COUNT - 1) {
                    print(++resultCount);
                } else {
                    putQueenIndex(row + 1);
                }
                //标识回来，这是为了重用count数组，也可以声明一个局部数组，只不过效率不好
                for (int iRow = row + 1; iRow < QUEEN_COUNT; iRow++) {
                    count[iRow][col]--;
                    if ((col - iRow + row) >= 0) {
                        count[iRow][col - iRow + row]--;
                    }
                    if ((col + iRow - row) < QUEEN_COUNT) {
                        count[iRow][col + iRow - row]--;
                    }
                }
            }
        }
        if (row == 0) {
            System.out.println(QUEEN_COUNT + "皇后共有 " + resultCount + " 个解\n"
                    + (System.currentTimeMillis() - time) + "毫秒");
        }
    }

    public void print(int n) {
        System.out.println(QUEEN_COUNT + "皇后的第 " + n + " 个解：");
        for (int i = 0; i < QUEEN_COUNT; i++) {
            for (int j = 0; j < QUEEN_COUNT; j++) {
                System.out.print(QueenIndex[i] == j ? " * " : " - ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        new Queen_Java().putQueenIndex(0);
    }
}

//http://blog.csdn.net/zhong317/article/details/4586131
class Queen8 {
    public static int num = 0; //累计方案总数
    public static final int MAXQUEEN = 8;//皇后个数，同时也是棋盘行列总数
    public static int[] cols = new int[MAXQUEEN]; //定义cols数组，表示8列棋子摆放情况
    public Queen8() {
        //核心函数
        getArrangement(0);
        System.out.print("\n");
        System.out.println(MAXQUEEN+"皇后问题有"+num+"种摆放方法。");
    }

    public void  getArrangement(int n){
        //遍历该列所有不合法的行，并用rows数组记录，不合法即rows[i]=true
        boolean[] rows = new boolean[MAXQUEEN];
        for(int i=0;i<n;i++){
            rows[cols[i]]=true;
            int d = n-i;
            if(cols[i]-d >= 0)rows[cols[i]-d]=true;
            if(cols[i]+d <= MAXQUEEN-1)rows[cols[i]+d]=true;

        }
        for(int i=0;i<MAXQUEEN;i++){
            //判断该行是否合法
            if(rows[i])continue;
            //设置当前列合法棋子所在行数
            cols[n] = i;
            //当前列不为最后一列时
            if(n<MAXQUEEN-1){
                getArrangement(n+1);
            }else{

                //累计方案个数
                num++;
                //打印棋盘信息
                printChessBoard();
            }


        }

    }
    public void printChessBoard(){

        System.out.print("第"+num+"种走法 \n");

        for(int i=0;i<MAXQUEEN;i++){
            for(int j=0;j<MAXQUEEN;j++){
                if(i==cols[j]){
                    System.out.print("0 ");
                }else
                    System.out.print("+ ");
            }
            System.out.print("\n");
        }

    }
    public static void main(String args[]){
        Queen8 queen = new Queen8();
    }

}
