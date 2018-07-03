package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 哈夫曼编码算法
 * 通常的编码方法有固定长度编码和不等长度编码两种。这是一个设计最优编码方案的问题，目的是使总码长度最短。
 * 这个问题利用字符的使用频率来编码，是不等长编码方法，使得经常使用的字符编码较短，不常使用的字符编码较长。
 * 频率越高，编码越短。
 * 任何一个字符的编码不能是另一个字符编码的前缀
 */
public class HuffmanCode {

    public static void main(String[] args) {
        Map<Character, Integer> input = new HashMap<>();
        input.put('a', 5);
        input.put('b', 32);
        input.put('c', 18);
        input.put('d', 7);
        input.put('e', 25);
        input.put('f', 13);
        List<HuffmanNode> treeList = input.entrySet()
                .stream()
                .map(entry -> buildSingNodeTree(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
        buildHuffmanTree(treeList);
        for (HuffmanNode node : treeList) {
            HuffmanNode head = node;
            StringBuilder sb = new StringBuilder();
            while (head.parent != null) {
                sb.insert(0, head.isLeft ? 0 : 1);
                head = head.parent;
            }
            System.out.println(node.value + "------" + sb.toString());
        }
    }

    /**
     * 构造哈夫曼树
     *
     * @param treeList
     * @return
     */
    private static HuffmanNode buildHuffmanTree(List<HuffmanNode> treeList) {
        // 选权重最小的两个构造出新的树，然后循环这般操作
        List<HuffmanNode> nodes = new ArrayList<>(treeList);
        while (nodes.size() != 1) {
            Collections.sort(nodes);
            HuffmanNode node1 = nodes.get(0);
            HuffmanNode node2 = nodes.get(1);
            HuffmanNode newNode = new HuffmanNode();
            newNode.weight = node1.weight + node2.weight;
            newNode.leftChild = node1;
            node1.isLeft = true;
            node1.parent = newNode;
            newNode.rightChild = node2;
            node2.isLeft = false;
            node2.parent = newNode;
            nodes.add(newNode);
            nodes.remove(node1);
            nodes.remove(node2);
        }
        return nodes.get(0);
    }

    private static HuffmanNode buildSingNodeTree(char value, int weight) {
        HuffmanNode node = new HuffmanNode();
        node.value = value;
        node.weight = weight;
        return node;
    }

    private static class HuffmanNode implements Comparable<HuffmanNode> {
        int weight;
        HuffmanNode parent;
        HuffmanNode leftChild;
        HuffmanNode rightChild;
        Character value;
        boolean isLeft;

        @Override
        public int compareTo(HuffmanNode o) {
            return this.weight - o.weight;
        }
    }


}
