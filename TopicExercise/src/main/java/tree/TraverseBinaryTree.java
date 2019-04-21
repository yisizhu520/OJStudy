package tree;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class TraverseBinaryTree {

    private class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    /**
     * 横向，层级遍历,广度优先遍历
     */
    private List<Node> horizonOrder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        List<Node> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            result.add(node);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return result;
    }

    // FIXME 通过层次遍历的方式来求高度
    private int getTreeHeight(Node root) {
        int height = 0;
        if (root == null) {
            return 0;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int width = queue.size();
            height++;
            for (int i = 0; i < width; i++) {
                Node node = queue.remove();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

        }
        return height;
    }

    @Test
    public void testHorizonOrder() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.right = node5;
        node5.left = node6;
        node5.right = node7;
        List<Node> nodes = horizonOrder(node1);
        assertThat(nodes, equalTo(Arrays.asList(node1, node2, node3, node4, node5, node6, node7)));
    }

    @Test
    public void testGetTreeHeight() {
        Node node1 = getTree();
        int height = getTreeHeight(node1);
        assertThat(height, equalTo(4));
    }

    private Node getTree() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.right = node5;
        node5.left = node6;
        node5.right = node7;
        return node1;
    }


}
