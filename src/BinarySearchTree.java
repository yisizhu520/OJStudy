import java.util.Stack;

/**
 * Created by WangJun on 2016/8/17.
 */
public class BinarySearchTree<K extends Comparable<K>, V> {

    int size;
    Node root;

    private class Node {
        K key;
        V value;
        Node left;
        Node right;
        int N;
    }

    public void put(K key, V value) {
        root = put(root, key, value);
    }

    Node put(Node node, K key, V value) {
        if (node == null) {
            Node n = new Node();
            n.key = key;
            n.value = value;
            n.N = 1;
            return n;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else if (cmp > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

    public void putWhile(K key, V value) {
        Node node = root;
        Node last = root;
        while (node != null) {
            last = node;
            int cmp = key.compareTo(node.key);
            if (cmp < 0) node = node.left;
            else if (cmp > 0) node = node.right;
            else {
                node.value = value;
                return;
            }
        }

        Node n = new Node();
        n.key = key;
        n.value = value;
        n.N = 1;
        if(root == null){
            root = n;
            return;
        }
        int cmp = key.compareTo(last.key);
        if (cmp < 0) last.left = n;
        else if (cmp > 0) last.right = n;
        //更新node里的N，使用一个栈，记录路径上的所有节点，将其size+1

    }

    public V get(K key) {
        return get(root, key);
    }

    public V getWhile(K key) {
        Node node = root;
        while (node != null) {
            int cmp = key.compareTo(node.key);
            if (cmp < 0) node = node.left;
            else if (cmp > 0) node = node.right;
            else return node.value;
        }
        return null;
    }

    V get(Node node, K key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0) get(node.left, key);
        else if (cmp > 0) get(node.right, key);
        return node.value;
    }

    public int size() {
        return size(root);
    }

    int size(Node node) {
        if (node == null) return 0;
        return node.N;
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer,Integer> bst = new BinarySearchTree<>();
        bst.put(4,1);
        bst.put(2,1);
        bst.put(6,1);
        bst.put(1,1);
        bst.put(3,1);
        bst.put(5,1);
        bst.put(7,1);
        bst.midTraverse();
    }

    void midTraverse(){
        midTraverse(root);
        System.out.println();
        forwardTraverse(root);
        System.out.println();
        forwardTraverWhile();
        //backTraverse(root);
    }

    private void midTraverse(Node n){
        if(n == null) {
            return;
        }
        midTraverse(n.left);
        System.out.print(n.key + " ");
        midTraverse(n.right);
    }

    void forwardTraverse(){
        forwardTraverse(root);
    }

    private void forwardTraverse(Node n){
        if(n == null) {
            return;
        }
        System.out.print(n.key + " ");
        forwardTraverse(n.left);
        forwardTraverse(n.right);
    }

    void backTraverse(){
        backTraverse(root);
    }

    private void backTraverse(Node n){
        if(n == null) {
            return;
        }
        backTraverse(n.left);
        backTraverse(n.right);
        System.out.print(n.key + " ");
    }

    void forwardTraverWhile(){
        Node node = root;
        Stack<Node> stack = new Stack<>();
        while(node!=null && !stack.isEmpty()){

            while(node!=null){
                stack.push(node);
                node = node.left;
            }
            if(!stack.isEmpty()){
                node = stack.pop();
                System.out.print(node.key + " ");
            }
        }


        stack.push(node);
        while (!stack.isEmpty()){
            node = stack.pop();
            System.out.print(node.key + " ");
            if(node.right != null) stack.push(node.right);
            if(node.left != null) stack.push(node.left);
        }

    }

    void midTraverseWhile(){
        Node node = root;
        while(node != null){
            node = node.left;
        }
    }




}
