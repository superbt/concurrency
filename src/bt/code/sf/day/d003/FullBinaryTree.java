package bt.code.sf.day.d003;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 满二叉树类
 */
public class FullBinaryTree {

    private TreeNode root;

    public FullBinaryTree(){
        this.root = null;
    }

    public void buildFullBinaryTree(int height){
        root = buildFullBinaryTreeRec(null,height,1);
    }
    private TreeNode buildFullBinaryTreeRec(TreeNode parent, int height ,int curentLevel){
        if(curentLevel>height){
            return  null ;
        }
        TreeNode newNode = new TreeNode(parent==null?1: parent.val*2);
        newNode.left = buildFullBinaryTreeRec(newNode,height,curentLevel+1);
        newNode.right = buildFullBinaryTreeRec(newNode,height,curentLevel+1);
        return  newNode ;
    }

    //这里没有什么实际意义，就是简单练习一下
    //前序遍历
    public void preOrderTraversal(){
        preOrderRec(root);
    }
    private void preOrderRec(TreeNode root){
        if(root!=null){
            System.out.print(root.val+" ");
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }
    //中序遍历
    public void inOrderTraversal(){
        inOrderRec(root);
    }
    private void inOrderRec(TreeNode root){
        if(root!=null){
            inOrderRec(root.left);
            System.out.print(root.val+" ");
            inOrderRec(root.right);
        }
    }
    //后序遍历
    public void postOrderTraversal(){
        postOrderRec(root);
    }
    private void postOrderRec(TreeNode root){
        if(root!=null){
            postOrderRec(root.left);
            postOrderRec(root.right);
            System.out.print(root.val+" ");
        }
    }
    //层级遍历
    public void levelOrderTraversal(){
        if(root==null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.print( node.val+" ");
            if (node.left!=null) queue.add(node.left);
            if(node.right!=null) queue.add(node.right);
        }
    }

    public static void main(String[] args) {
        FullBinaryTree tree = new FullBinaryTree();
        tree.buildFullBinaryTree(3);

        tree.levelOrderTraversal();
        System.out.println("层级遍历");

        tree.preOrderTraversal();
        System.out.println("前序遍历");

        tree.inOrderTraversal();
        System.out.println("中序遍历");

        tree.postOrderTraversal();
        System.out.println("后序遍历");
    }
}
