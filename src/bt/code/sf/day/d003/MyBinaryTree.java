package bt.code.sf.day.d003;

import java.util.LinkedList;
import java.util.Queue;

//二叉树的一些操作
//定义树
//插入、
public class MyBinaryTree {

    private  TreeNode root ;

    public MyBinaryTree(){
        this.root = null ;
    }

    public void insert(int value){
        //暂时留在这里吧
         root = insertRec(root,value);
    }

    private TreeNode insertRec(TreeNode root ,int value){
        if(root == null){
            root = new TreeNode(value);
            return  root ;
        }
        if(value<root.val){
            root.left = insertRec(root.left,value);
        }else if( value>root.val){
            root.right = insertRec(root.right,value);
        }
        return  root;
    }

    //前序遍历
    public void preoderTraversal(){
      preOderRec(root);

    }
    //前序遍历的配套方法
    private void  preOderRec(TreeNode node){
        if(node!=null){
            System.out.print(node.val+" ");
            preOderRec(node.left);
            preOderRec(node.right);
        }
    }

    //中序遍历
    public void inOrderTraversal(){
         inOrderRec(root);
    }

    private void  inOrderRec(TreeNode node){
        if(node!=null){
            inOrderRec(node.left);
            System.out.print(node.val+" ");
            inOrderRec(node.right);
        }
    }

    //后序遍历
    public void postOrderTraversal(){
        postorderRec(root);
    }
    private void postorderRec(TreeNode node){
        if(node!=null){
            postorderRec(node.left);
            postorderRec(node.right);
            System.out.print(node.val+" ");
        }
    }

    //层级遍历
    public void levelOrderTraversal() {
        levelOrderRec(root);
    }

    private void levelOrderRec(TreeNode root){
      if(root == null)  return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.print(node.val+" ");
            if(node.left!=null) queue.add(node.left);
            if(node.right!=null) queue.add(node.right);
        }
    }

    public static void main(String[] args) {
        //构建一个树
        TreeNode root = new TreeNode();
        MyBinaryTree  myTree = new MyBinaryTree();

        myTree.insert(12);
        myTree.insert(11);

        for (int i = 1; i <=10 ; i++) {
            myTree.insert(i);
        }
        myTree.insert(13);


        myTree.levelOrderTraversal();
        System.out.println(" ");
        myTree.inOrderTraversal();
        System.out.println(" ");
        myTree.preoderTraversal();
        System.out.println(" ");
        myTree.postOrderTraversal();

    }
}
