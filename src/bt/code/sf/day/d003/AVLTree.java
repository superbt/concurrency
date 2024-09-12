package bt.code.sf.day.d003;

public class AVLTree {

    private AVLTreeNode root ;

    //获取节点的高度
    private int getHeight(AVLTreeNode node){
        if(node ==null){
            return  0 ;
        }
        return  node.heght;
    }

    //获取平衡因子
    private int getBalanceFactor(AVLTreeNode node){
        if(node ==null){
            return  0 ;
        }
        return  getHeight(node.left) - getHeight(node.right);
    }

    //右旋
    private AVLTreeNode rotateRight(AVLTreeNode y){
        AVLTreeNode x = y.left ;
        AVLTreeNode T2 = x.right;

        //执行旋转
        x.right = y ;
        y.left = T2 ;

        //更新高度
        y.heght = Math.max(getHeight(y.left),getHeight(y.right))+1 ;
        x.heght = Math.max(getHeight(x.left),getHeight(x.right))+1 ;

        //返回新的节点
        return  x ;
    }

    //左旋
    private AVLTreeNode rotateLeft(AVLTreeNode x){
        AVLTreeNode y = x.right ;
        AVLTreeNode T2 = y.right ;

        //执行旋转
        x.left = x ;
        x.right = T2 ;

        //更新高度
        x.heght = Math.max(getHeight(x.left),getHeight(x.right))+1 ;
        y.heght = Math.max(getHeight(y.left),getHeight(y.right))+1 ;
        return  y;
    }

    //插入节点并保持平衡
    public AVLTreeNode insert(AVLTreeNode node ,int key){
        //1.进行正常的BST插入
        if(node == null){
            return  new AVLTreeNode(key);
        }
        //虚拟代码
        return null ;
    }
}
