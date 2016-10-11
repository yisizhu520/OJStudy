import java.io.ObjectOutput;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by WangJun on 2016/8/31.
 * 判断单链表是否有环
 */
public class LinkHasLoop {

    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }

    }

    public static void main(String[] args) {

//        Node a = new Node(1);
//        Node a2 = new Node(2);
//        Node a3 = new Node(3);
//        Node a4 = new Node(4);
//        a.next = a2;
//        a2.next = a3;
//        a3.next = a4;
//        a4.next = null;
//        System.out.println(hasLoop(a));
    }

    /**
     *使用HashSet来辅助判断是否有环
     * @param A
     * @return
     */
    static boolean hasLoop(Node A){
        Set<Node> set = new HashSet<>();
        while(A != null){
            if(set.contains(A)){
                return true;
            }
            set.add(A);
            A = A.next;
        }
        return false;
    }

    /**
     * 使用龟兔赛跑的方式来判断是否有环
     * @param A
     * @return
     */
    static boolean hasLoop2(Node A){
        Node tuzi = A,wugui = A;
        while (tuzi != null && tuzi.next != null){
            tuzi = tuzi.next.next;
            wugui = wugui.next;
            if(tuzi == wugui){
                return true;
            }
        }
        return false;
    }


}
