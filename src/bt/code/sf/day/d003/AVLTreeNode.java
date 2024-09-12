package bt.code.sf.day.d003;

public class AVLTreeNode {
    int key ,heght;
    AVLTreeNode left,right ;

    public AVLTreeNode(int d){
        this.key = d ;
        heght = 1 ; //新节点默认高度为1
    }
}
