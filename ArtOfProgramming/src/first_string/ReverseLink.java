package first_string;

/**
 * Created by WangJun on 2016/9/18.
 * 链表翻转。给出一个链表和一个数k，比如，链表为1→2→3→4→5→6，k=2，则翻转后2→1→6→5→4→3，
 * 若k=3，翻转后3→2→1→6→5→4，若k=4，翻转后4→3→2→1→6→5
 */
public class ReverseLink {

    public static void main(String[] args) {
        Node node = new Node(1).next(2).next(3).next(4).next(5).next(6);
        print(node);
        //Node revNode = reverseNode(node);
        //print(revNode);
        print(reverseNode(node,2));
    }

    static class Node{
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node next(int value) {
            Node last = next;
            if (last == null) {
                next = new Node(value);
                return this;
            }
            while (last.next != null) {
                last = last.next;
            }
            last.next = new Node(value);
            return this;
        }
    }

    static void print(Node node){

        while(node != null){
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();

    }

    /**
     * 如题
     * @param node
     * @param k
     * @return
     */
    static Node reverseNode(Node node,int k){
        Node p = node;
        for (int i = 1; i < k; i++) {
            if(p == null) throw new IllegalArgumentException();
            p = p.next;
        }
        Node other = p.next;
        p.next = null;
        p = reverseNode(node);
        other = reverseNode(other);
        node.next = other;
        return p;
    }

    /**
     * 翻转一条链表
     * @param node
     * @return
     */
    static Node reverseNode(Node node){
        Node p = node;
        Node next;
        Node pre = null;
        while(p != null){
            next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        return pre;
    }



}
