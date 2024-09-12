package bt.code.sf.day.d003;

import java.util.Arrays;

/***
 * 定义树的 增、删、修改、查找方法
 */
public class BTree {

    //根节点
    private BTreeNode root ;
    //最小度数
    private int t ;

    public BTree( int t){
        this.t = t ;
        root = new BTreeNode(t,true);
        //初始时，根是一个空的叶子节点
    }

    //插入键值
    public void insert(int k){
        //如果树已经满了，创建一个新的根节点
        if(root.keys.length ==(2*t-1)){
            BTreeNode s = root ;
            root = new BTreeNode(t,false);
            root.children[0] = s ;
            splitChild(root,0);
            insertNonFunll(root ,k );
        }else{
            insertNonFunll(root,k);
        }
    }

    //在非满节点中插入键值
    private void insertNonFunll(BTreeNode x ,int k){
        //插入点索引下标
        int i = x.keys.length - 1 ;
        //如果是叶子节点
        if(x.isLeaf){
            x.keys = Arrays.copyOf(x.keys,x.keys.length+1);
            //这里的条件是嘛意思呢
            while(i>=0&&k<x.keys[i]){
               x.keys[i+1] = x.keys[i];
               i-- ;
            }
            x.keys[i+1] = k ;
        }else{
            //不是叶子节点插入
            while(i>=0&&k<x.keys[i]){
                i-- ;
            }
            i++ ;
            if(x.children[i].keys.length==(2*t-1)){
                //这里应该是超过节点了，要反转了
                /***/
                splitChild(x,i);
                if(k>x.keys[i]){
                    i++ ;
                }
            }
            //递归操作
            insertNonFunll(x.children[i],k);
        }
    }

    //分裂节点
    //里面很多没有 精力去看懂啊！
    private void splitChild(BTreeNode x ,int i){
        BTreeNode y = x.children[i];
        BTreeNode z= new BTreeNode(y.t ,y.isLeaf);
        z.keys = Arrays.copyOfRange(y.keys ,y.t ,y.keys.length);
        if(!y.isLeaf){
            z.children = Arrays.copyOfRange(y.children,y.t,y.children.length);
        }
        y.keys = Arrays.copyOf(y.keys,y.t);
        for(int j = x.children.length-1 ;j>i ;j--){
            x.children[j+1] = x.children[j];
        }
        x.children[i+1] = z ;
        for(int j= x.keys.length-1 ;j>=0 ;j--){
            x.keys[j+1] = x.keys[j];
        }
        x.keys[i] = y.keys[y.t-1];
        x.keys = Arrays.copyOf(x.keys ,x.keys.length+1);
    }
}
