/**
 * Created by WangJun on 2016/8/31.
 * 合并两个有序链表
 */
public class MergeSortLink {

    public static void main(String[] args) {
        //a:13569 b:2458
        Node a = new Node(1).next(3).next(5).next(6).next(9);
        Node b = new Node(2).next(4).next(5).next(8).next(9);
        print(a);
        print(b);
        //Node merge = mergeSortLink(a,b);
        Node mergeDigui = mergeSortLinkDigui(a,b);
        //print(merge);
        print(mergeDigui);

    }

    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node next(int value){
            Node last = next;
            if(last == null){
                next = new Node(value);
                return this;
            }
            while(last.next != null){
                last = last.next;
            }
            last.next = new Node(value);
            return this;
        }
    }

    static Node mergeSortLink(Node A, Node B) {
        Node first = null;
        Node last = null;
        Node a = A;
        Node b = B;
        if (a == null && b == null) {
            return null;
        } else if (a == null) {
            last = b;
            first = last;
            b = b.next;
        } else if (b == null) {
            last = a;
            first = last;
            a = a.next;
        } else if (a.value <= b.value) {
            last = a;
            first = last;
            a = a.next;
        } else {
            last = b;
            first = last;
            b = b.next;
        }
        while (a != null || b != null) {
            if (a == null) {
                while (b != null) {
                    last.next = b;
                    last = last.next;
                    b = b.next;
                }
            } else if (b == null) {
                while (a != null) {
                    last.next = a;
                    last = last.next;
                    a = a.next;
                }
            } else if (a.value <= b.value) {
                last.next = a;
                last = last.next;
                a = a.next;
            } else {
                last.next = b;
                last = last.next;
                b = b.next;
            }
        }
        return first;
    }

    /**
     * MARK 递归合并，思路更清晰，代码更简洁
     * @param A
     * @param B
     * @return
     */
    static Node mergeSortLinkDigui(Node A, Node B){
        if(A == null){
            return B;
        }
        if(B == null){
            return A;
        }
        Node result;
        if(A.value <= B.value){
            result = A;
            result.next = mergeSortLinkDigui(A.next,B);
        }else{
            result = B;
            result.next = mergeSortLinkDigui(A,B.next);
        }
        return result;
    }

    static void print(Node node){
        while(node != null){
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();

    }


}
