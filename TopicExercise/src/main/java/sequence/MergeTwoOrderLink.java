package sequence;

import org.junit.Test;

/**
 * 合并两个有序链表
 */
public class MergeTwoOrderLink {


    public Node<Integer> mergeWithRecursion(Node<Integer> node1, Node<Integer> node2) {
        if (node1 == null) return node2;
        if (node2 == null) return node1;
        if (node1.value <= node2.value) {
            node1.next = mergeWithRecursion(node1.next, node2);
            return node1;
        } else {
            node2.next = mergeWithRecursion(node1, node2.next);
            return node2;
        }
    }

    @Test
    public void testMergeWithRecursion() {
        Node<Integer> node1 = Node.of(1, 2, 4);
        Node<Integer> node2 = Node.of(3, 5, 6);
        Node<Integer> head = mergeWithRecursion(node1, node2);
        Node.printNode(head);
    }

    @Test
    public void testMergeWithRecursionWhenNodeIsNull() {
        Node<Integer> node1 = null;
        Node<Integer> node2 = Node.of(3, 5, 6);
        Node<Integer> head = mergeWithRecursion(node1, node2);
        Node.printNode(head);
    }

    public Node<Integer> mergeWithIteration(Node<Integer> node1, Node<Integer> node2) {
        Node<Integer> head = new Node<>(Integer.MIN_VALUE);
        Node<Integer> tail = head;
        Node<Integer> head1 = node1;
        Node<Integer> head2 = node2;
        while (head1 != null && head2 != null) {
            if (head1.value <= head2.value) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }
        if (head1 == null) {
            tail.next = head2;
        } else {
            tail.next = head1;
        }
        return head.next;
    }

    @Test
    public void testMergeWithIteration() {
        Node<Integer> node1 = Node.of(1, 2, 4);
        Node<Integer> node2 = Node.of(3, 5, 6);
        Node<Integer> head = mergeWithIteration(node1, node2);
        Node.printNode(head);
    }

    @Test
    public void testMergeWithIterationWhenNodeIsNull() {
        Node<Integer> node1 = null;
        Node<Integer> node2 = Node.of(3, 5, 6);
        Node<Integer> head = mergeWithIteration(node1, node2);
        Node.printNode(head);
    }

}
