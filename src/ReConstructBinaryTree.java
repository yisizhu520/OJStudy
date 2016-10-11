/**
 * Created by WangJun on 2016/8/25.
 */
public class ReConstructBinaryTree {

    public static void main(String[] args) {
        int[] pre = {2,3,4,5,6,1,7};
        int[] in = {4,3,6,1,5,7,2};
        TreeNode root = reConstructBinaryTree(pre,in);
        System.out.println(root.val);
        last(root);
    }

    static void last(TreeNode node){
        if(node == null) return;
        last(node.left);
        last(node.right);
        System.out.print(node.val);
    }

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    /**
     * 给定二叉树的前序和中序遍历数组，且无重复元素，构建粗这棵二叉树
     * 虽然我想到了用递归来构建，但是思路有些混乱，找不到边界索引参数，
     * 所以就额外的创建新的数组了，肯定是性能上有问题的
     * @param pre
     * @param in
     * @return
     */
    static TreeNode reConstructBinaryTree(int[] pre,int[] in){

        if(pre.length == 0 || in.length == 0){
            return null;
        }
        int rootValue = pre[0];
        TreeNode root = new TreeNode(rootValue);

        if(pre.length == 1) return root;

        //找到左子树的根节点的索引
        int gap = 0;
        for (int i = 0; i < in.length; i++) {
            if(in[i] == rootValue){
                gap = i;
                break;
            }
        }


        int[] leftPre = new int[gap];
        for (int i = 0; i < leftPre.length; i++) {
            leftPre[i] = pre[i+1];
        }

        int[] leftIn = new int[gap];
        for (int i = 0; i < leftIn.length; i++) {
            leftIn[i] = in[i];
        }

        TreeNode left = reConstructBinaryTree(leftPre,leftIn);
        root.left = left;

        int[] rightPre = new int[pre.length-gap-1];
        for (int i = 0; i < rightPre.length; i++) {
            rightPre[i] = pre[i+1+gap];
        }

        int[] rightIn = new int[in.length-gap-1];
        for (int i = 0; i < rightIn.length; i++) {
            rightIn[i] = in[i+1+gap];
        }

        TreeNode right = reConstructBinaryTree(rightPre,rightIn);
        root.right = right;

        return root;

    }


    //前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}

    /**
     * 这里很好的找到了两个数组的递归边界值，nice!
     * @param pre
     * @param startPre
     * @param endPre
     * @param in
     * @param startIn
     * @param endIn
     * @return
     */
    private TreeNode reConstructBinaryTree(int [] pre,int startPre,int endPre,int [] in,int startIn,int endIn) {

        if(startPre>endPre||startIn>endIn)
            return null;
        TreeNode root=new TreeNode(pre[startPre]);

        for(int i=startIn;i<=endIn;i++)
            if(in[i]==pre[startPre]){
                root.left=reConstructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
                root.right=reConstructBinaryTree(pre,i-startIn+startPre+1,endPre,in,i+1,endIn);
            }

        return root;
    }



}
