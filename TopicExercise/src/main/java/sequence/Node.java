package sequence;


public class Node<T> {

    public T value;
    public Node<T> next;

    public Node(T t) {
        if (t == null) throw new IllegalArgumentException("can not create empty value node");
        this.value = t;
    }

    public Node append(T t) {
        Node<T> node = new Node<>(t);
        this.getLast().next = node;
        return this;
    }

    public Node next(T t) {
        Node<T> node = new Node<>(t);
        Node<T> temp = this.next;
        this.next = node;
        node.next = temp;
        return this;
    }

    public Node getLast() {
        Node head = this;
        while (head.next != null) {
            head = head.next;
        }
        return head;
    }

    public static <T> Node of(T value) {
        if (value == null) throw new IllegalArgumentException("can not create empty value node");
        return new Node<>(value);
    }

    public static <T> Node<T> of(T first, T... values) {
        if (first == null) throw new IllegalArgumentException("can not create empty value node");
        Node<T> head = new Node<>(first);
        Node temp = head;
        for (T value1 : values) {
            temp.next = new Node<>(value1);
            temp = temp.next;
        }
        return head;
    }



    @Override
    public String toString() {
        return value.toString();
    }

    public String toLinkString() {
        Node head = this;
        StringBuilder stringBuilder = new StringBuilder(head.value.toString());
        while (head.next != null) {
            head = head.next;
            stringBuilder.append(" -> ").append(head.value.toString());
        }
        return stringBuilder.toString();
    }

    public void print() {
        System.out.println(this.toLinkString());
    }

    public static void printNode(Node node) {
        if (node == null) {
            System.out.println("empty node");
        } else {
            System.out.println(node.toLinkString());
        }
    }

}
