import java.util.Stack;

/**
 * Created by WangJun on 2016/8/31.
 * 二叉树的多种遍历实现，包括递归和非递归实现，主要是非递归的实现
 */
public class BinaryTreeTraversal {


    public static void main(String[] args) {
        Node n8 = new Node(8, null, null);
        Node n7 = new Node(7, null, null);
        Node n5 = new Node(5, n7, n8);
        Node n4 = new Node(4, null, null);
        Node n2 = new Node(2, n4, n5);
        Node n6 = new Node(6, null, null);
        Node n3 = new Node(3, n6, null);
        Node n1 = new Node(1, n2, n3);

        preOrder(n1);
        System.out.println();
        inOrder(n1);
        System.out.println();
        postOrder(n1);
        System.out.println();
        postOrder2(n1);
    }

    private static class Node {
        Integer value;
        Node left;
        Node right;

        public Node(Integer value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 前序遍历非递归实现
     *
     * @param root
     */
    static void preOrder(Node root) {
        Stack<Node> stack = new Stack<>();
        Node p = root;
        while (p != null || !stack.isEmpty()) {

            while (p != null) {
                System.out.print(p.value + " ");
                stack.push(p);
                p = p.left;
            }

            if (!stack.isEmpty()) {
                p = stack.pop();
                p = p.right;
            }
        }

    }

    /**
     * 中序遍历非递归实现
     *
     * @param root
     */
    static void inOrder(Node root) {
        Stack<Node> stack = new Stack<>();
        Node p = root;
        while (p != null || !stack.isEmpty()) {

            while (p != null) {
                stack.push(p);
                p = p.left;
            }

            if (!stack.isEmpty()) {
                p = stack.pop();
                System.out.print(p.value + " ");
                p = p.right;
            }
        }
    }

    /**
     * 后遍历非递归实现
     * 如果左孩子和右孩子都为空，则直接访问当前节点；
     * 如果自己的左孩子或右孩子被访问过了，则也直接访问当前节点；
     * 否则将右孩子和左孩子依次入栈
     *
     * @param root
     */
    static void postOrder(Node root) {
        Stack<Node> stack = new Stack<>();
        Node p = root;
        if (p == null) return;
        Node old = null;
        stack.push(p);
        while (!stack.isEmpty()) {
            p = stack.peek();
            if ((p.left == null && p.right == null)
                    || (old != null && (old == p.left || old == p.right))) {
                System.out.print(p.value + " ");
                stack.pop();
                old = p;
            } else {
                if (p.right != null)
                    stack.push(p.right);
                if (p.left != null)
                    stack.push(p.left);
            }
        }
    }

    /**
     * 后序递归的第二种思路：
     * 跟前序和中序格式保持一致，不过这里需要一个额外的栈来保存遍历节点的值。
     * 沿着一个节点的右孩子一直往下搜索，将遇到的节点的值压入栈。
     * 再按照同样的规则访问其左子树
     *
     * @param root
     */
    static void postOrder2(Node root) {
        Stack<Node> stack = new Stack<>();
        Stack<Integer> values = new Stack<>();
        Node p = root;
        while (p != null || !stack.isEmpty()) {
            while(p!=null){
                values.push(p.value);
                stack.push(p);
                p = p.right;
            }
            p = stack.pop();
            p = p.left;
        }
        while(!values.isEmpty()){
            System.out.print(values.pop()+" ");
        }


    }


}
