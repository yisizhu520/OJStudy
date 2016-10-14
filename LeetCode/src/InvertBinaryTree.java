import javax.swing.tree.TreeNode;

/**
 * Created by WangJun on 2016/10/11.
 * <pre>
 *     Invert a binary tree.

   4
 /   \
 2     7
 / \   / \
 1   3 6   9
 to
   4
 /   \
 7     2
 / \   / \
 9   6 3   1
 Trivia:
 This problem was inspired by this original tweet by Max Howell:
 Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so fuck off.
 * </pre>
 */
public class InvertBinaryTree {

    //Definition for a binary tree node.
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    public class Solution {

        public TreeNode invertTree(TreeNode root) {
            invertTreeInternal(root);
            return root;
        }

        public void invertTreeInternal(TreeNode root) {
            if(root == null)
                return;
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = temp;
            invertTree(root.left);
            invertTree(root.right);
        }

    }


}
