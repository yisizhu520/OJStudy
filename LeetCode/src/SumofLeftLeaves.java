import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by WangJun on 2016/10/13.
 * <pre>
 *     Find the sum of all left leaves in a given binary tree.
 *
 * Example:
 *
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 *
 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 * </pre>
 */
public class SumofLeftLeaves {


    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class Solution {

        /**
         * 如何找到所有的左叶子节点？递归？
         *
         * @param root
         * @return
         */
        public int sumOfLeftLeaves(TreeNode root) {
            if (root == null) return 0;
            int left, right;
            if (root.left != null && root.left.left == null && root.left.right == null) {
                left = root.left.val;
            } else {
                left = sumOfLeftLeaves(root.left);
            }
            right = sumOfLeftLeaves(root.right);
            return left + right;
        }

        /**
         * 上一种做法的简写
         *
         * @param root
         * @return
         */
        public int sumOfLeftLeaves2(TreeNode root) {
            if (root == null) return 0;
            if (root.left != null && root.left.left == null && root.left.right == null) {
                return root.left.val + sumOfLeftLeaves2(root.right);
            }
            return sumOfLeftLeaves2(root.left) + sumOfLeftLeaves2(root.right);
        }

        /**
         * 既然有递归做法，肯定也有相应的迭代做法
         * 先序遍历的迭代方式，需要借助栈
         *
         * @param root
         * @return
         */
        public int sumOfLeftLeaves3(TreeNode root) {
            TreeNode node = root;
            Stack<TreeNode> stack = new Stack<>();
            int sum = 0;
            while (node != null || !stack.isEmpty()) {

                while (node != null) {
                    stack.push(node);
                    if (node.left != null && node.left.left == null && node.left.right == null) {
                        sum += node.left.val;
                    }
                    node = node.left;
                }

                if (!stack.isEmpty()) {
                    node = stack.pop().right;
                }
            }
            return sum;
        }

        /**
         * 既然有递归做法，肯定也有相应的迭代做法
         * 层级遍历迭代方式，需要借助队列
         *
         * @param root
         * @return
         */
        public int sumOfLeftLeaves4(TreeNode root) {
            if (root == null) return 0;
            Queue<TreeNode> queue = new ArrayDeque<>();
            int sum = 0;
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.left != null && node.left.left == null && node.left.right == null) {
                    sum += node.left.val;
                }
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            return sum;
        }


    }


}
