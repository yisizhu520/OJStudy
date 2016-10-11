import java.util.Collections;
import java.util.LinkedList;

/**
 * Created by WangJun on 2016/9/2.
 * 单链表的一些算法
 */
public class SingleLink {

    class Node {
        Integer value;
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

    /**
     * 删除链表里重复的元素
     *
     * @param head
     */
    public void delteDuplicate(Node head) {
        /*
        1.使用一个hashSet来保存访问过的元素，判断当前访问的节点的值是否已存在。时间复杂度低O(n)，需要额外空间
        2.暴力遍历法。双重遍历找出重复的删除。时间复杂度很高O(n2)
        3.稍微优化的遍历。内循环从链表头开始遍历到当前节点，遇到值重复的节点就删除，然后就退出内循环。
         */
    }

    /**
     * 链表反转-遍历实现
     *
     * @param head
     */
    public Node reverseLink(Node head) {
        Node p = head;
        Node pre = null;
        while (p != null) {
            Node next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        return pre;
    }

    public Node reverseLinkTraversal(Node head) {
       if(head==null || head.next == null) return head;
        Node node = reverseLinkTraversal(head.next);
        Node p = node;
        while(p.next !=null){
            p = p.next;
        }
        p.next = head;
        head.next = null;
        return node;
    }


    public static void main(String[] args) {
        SingleLink link = new SingleLink();
        Node n = link.new Node(1).next(2).next(3);
        //n = link.reverseLink(n);
        n = link.reverseLinkTraversal(n);
        print(n);
    }

    static void print(Node node){
        while(node != null){
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();

    }


}
