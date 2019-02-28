package sequence;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class NodeTest {

    @Test
    public void testToLinkString() {
        Node node = Node.of(1, 2, 3);
        assertThat(node.toLinkString(), equalTo("1 -> 2 -> 3"));
    }
}
