package bt.code.sf.day.d003;

/**
 * BTreeNode 类是表示树中的每个节点。
 * 节点应该包含一个健值数组来存储键值，一个子节点数组来存储指向子节点的引用
 * ，以及一些元数据，如节点是否为叶子节点。
 */
public class BTreeNode {

    //存储键值
    int[] keys ;
    //存储子节点引用
    BTreeNode [] children ;
    //是否为叶子节点
    boolean isLeaf ;
    //最大键的数量
    int t ;

    public BTreeNode(int t ,boolean isLeaf){
        this.t = t ;
        this.isLeaf = isLeaf ;
        keys = new int[2*t-1];
        children = new BTreeNode[2*t];
    }
}
