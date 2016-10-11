import java.util.ArrayList;

public class ES {
    static final int n=39;
    static ArrayList<Integer> selectedLayers=new ArrayList<Integer>();//反向存储最坏情况下所有选择检查的楼层
    static int count=0;//最坏情况下检查的次数  
    public static void main(String[] args) {
        EasyWay();
    }
    static void EasyWay(){
        int m=n;
        for(int i=0;m>0;i++,m-=i){
            selectedLayers.add(m);
            count++;
        }
        print();
    }
    static void print(){
        //打印最优方案  
        System.out.println("最优方法在最差情况下需要检查"+count+"次。");
        System.out.println("最佳方法在最坏情况下的检查顺序为：");
        for(int i=selectedLayers.size()-1;i>=0;i--){
            System.out.println("=>检查第"+selectedLayers.get(i)+"层");
        }
    }
}
