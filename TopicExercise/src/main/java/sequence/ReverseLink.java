package sequence;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * 倒序一个单链表
 */
public class ReverseLink {

    class Node {

        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    Node reverseLink(Node node) {
        Node now = node;
        Node pre = null;
        while (now != null) {
            Node next = now.next;
            now.next = pre;
            pre = now;
            now = next;
        }
        return pre;
    }

    @Test
    public void testReverseLinkWhenNodeIsNull() {
        Node node = null;
        Node reverse = reverseLink(node);
        assertThat(reverse, equalTo(null));
    }

    @Test
    public void testReverseLinkWhenOnlyOneNode() {
        Node node = new Node(1);
        Node reverse = reverseLink(node);
        assertThat(node, equalTo(reverse));
    }

    @Test
    public void testReverseLinkWhenOnlyTwoNode() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        node1.next = node2;
        Node reverse = reverseLink(node1);
        assertThat(reverse.value, equalTo(2));
        assertThat(reverse.next.value, equalTo(1));
    }

    @Test
    public void testReverseLinkInNormalCase() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.next = node2;
        node2.next = node3;
        Node reverse = reverseLink(node1);
        assertThat(reverse.value, equalTo(3));
        assertThat(reverse.next.value, equalTo(2));
        assertThat(reverse.next.next.value, equalTo(1));
    }



}
