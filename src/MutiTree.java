import java.util.*;

/**
 * Created by WangJun on 2016/9/20.
 * 根据输入构造多叉树并遍历
 */
public class MutiTree {


    public static void main(String[] args) {
        /*
        2 4 6
        4 7 8 9
        6 3 1
        8 5 10 11
         */
        Scanner sc = new Scanner(System.in);
        Node root = null;
        List<Node> nodeList = new ArrayList<>();
        String nextLine;
        while (sc.hasNextLine() && !"".equals(nextLine = sc.nextLine())) {
            String[] strs = nextLine.split(" ");
            Node node = buildTree(strs, nodeList);
            if (root == null) {
                root = node;
            } else {
                //从list里找到节点，变成他的子孩子
                for (int i = 0; i < nodeList.size(); i++) {
                    Node temp = nodeList.get(i);
                    if(temp.value == node.value){
                        temp.children = node.children;
                        break;
                    }
                }
            }
        }
        levelTravesal(root);

    }

    static void levelTravesal(Node root){
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node node = queue.poll();
            System.out.print(node.value);
            for (int i = 0; i < node.children.size(); i++) {
                queue.offer(node.children.get(i));
            }
        }
    }

    static void preTravesal(Node root){
        if(root == null) return;
        System.out.print(root.value + " ");
        for (int i = 0; i < root.children.size(); i++) {
            preTravesal(root.children.get(i));
        }
    }

    static Node buildTree(String[] strs, List<Node> nodeList) {
        Node root = null;
        for (int i = 0; i < strs.length; i++) {
            int value = Integer.parseInt(strs[i]);
            if (i == 0) {
                root = new Node(value);
            } else {
                Node node = new Node(value);
                root.children.add(node);
                nodeList.add(node);
            }

        }
        return root;
    }

    static class Node {

        public Node(int value) {
            this.value = value;
            children = new ArrayList<>();
        }

        int value;
        List<Node> children;
    }


}
