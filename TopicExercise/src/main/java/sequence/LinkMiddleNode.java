package sequence;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class LinkMiddleNode {


    /**
     * find the middle node in a link
     * return the single middle node if the count of nodes is odd
     * return two middle nodes if the count of nodes is even
     * https://blog.csdn.net/qq_38386316/article/details/81735753
     * @param node
     * @return
     */
    List<Node> LinkMiddleNode(Node node) {
        if (node == null) {
            return new ArrayList<>();
        }
        Node slow = node;
        Node fast = node;
        Node pre = slow;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast == null) { // even
            return Arrays.asList(pre, slow);
        }
        if (fast.next == null) { //odd
            return Arrays.asList(slow);
        }
        return new ArrayList<>();
    }

    // TODO imp with count

    @Test
    public void testLinkMiddleNodeWhenNodeIsNull() {
        Node node = null;
        List<Node> middle = LinkMiddleNode(node);
        assertThat(middle, equalTo(new ArrayList<>()));
    }

    @Test
    public void testLinkMiddleNodeWhenOnlyOneNode() {
        Node<Integer> node = new Node<>(1);
        List<Node> middle = LinkMiddleNode(node);
        assertThat(middle.get(0).value, equalTo(1));
    }

    @Test
    public void testLinkMiddleNodeWhenOnlyTwoNode() {
        Node node = Node.of(1,2);
        List<Node> middle = LinkMiddleNode(node);
        assertThat(middle.get(0).value, equalTo(1));
        assertThat(middle.get(1).value, equalTo(2));
    }

    @Test
    public void testLinkMiddleNodeWhenLinkNumberIsOdd() {
        Node node = Node.of(1,2,3);
        List<Node> middle = LinkMiddleNode(node);
        assertThat(middle.get(0).value, equalTo(2));
    }

    @Test
    public void testLinkMiddleNodeWhenLinkNumberIsEven() {
        Node node = Node.of(1,2,3,4);
        List<Node> middle = LinkMiddleNode(node);
        assertThat(middle.get(0).value, equalTo(2));
        assertThat(middle.get(1).value, equalTo(3));
    }


}
