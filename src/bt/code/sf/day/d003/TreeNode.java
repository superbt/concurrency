package bt.code.sf.day.d003;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    int val ;
    TreeNode left ;
    TreeNode right ;

    TreeNode (){
    }
    TreeNode (int x){
        val = x ;
    }

    //前序打印
    public void preOderPrint(TreeNode node){
      if(node!=null){
          System.out.print(node.val+" ");
          preOderPrint(node.left);
          preOderPrint(node.right);
      }
    }
    //中序打印
    public void inOrderPrint(TreeNode node){
        if(node!=null){
            inOrderPrint(node);
            System.out.print(node.val+" ");
            inOrderPrint(node);
        }
    }
    //后序打印
    public void postOrderPrint(TreeNode node){
        if(node !=null){
            postOrderPrint(node.left);
            postOrderPrint(node.right);
            System.out.print(node.val+" ");
        }
    }
    //层级打印
    //这个比较高级哟
    public void levelOrderPrint(TreeNode node){
        if(node == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            TreeNode node1 = queue.poll();
            System.out.print(node1.val+" ");
            if(node1.left!=null) queue.add(node1.left);
            if(node1.right!=null) queue.add(node1.right);
        }
    }
}
