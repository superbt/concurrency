package bt.code.sf.tree;

public class BinarySearchTreeOpts {

    //增加节点
    static  BinarySearchTree root ;

    public static  void insert(int data){
        if(root==null){
            root = new BinarySearchTree(data);
            return;
        }
        BinarySearchTree node = root ;
        while (node!=null){
            if(data< node.getData()){
                if(node.getLeft()==null){
                    node.setLeft(new BinarySearchTree(data));
                    return;
               }
                node = node.getLeft();
            }else{
               if(node.getRight()==null){
                   node.setRight(new BinarySearchTree(data));
                   return;
               }
               node = node.getRight();
            }
        }
    }

    //查找数据
    public static  void find( int data){
        BinarySearchTree node = root ;
        while (node!=null){
            if(data<node.getData()){
                node = node.getLeft();
            }else if(data>node.getData()){
                node = node.getRight();
            }else{
                System.out.println("找到数据了");
                return;
            }
            System.out.println("node nothing");
        }
    }

    //删除节点操作
    public static  void remove(int data){

        BinarySearchTree node = root ;

        BinarySearchTree parent = null ;

        while (node !=null && node.getData()!=data){
            parent = node ;
            if(data< node.getData()){
                node = node.getLeft();
            }else{
                node  = node.getRight();
            }
        }
        if(node==null){
            return;
        }

        //找到了

    }

    /**
     *  1.叶子节点，把对应的父节点指向的指针为null
     *  2.只有一个叶子节点，把对应父节点指向指针指向该节点
     *  3.删除2个子节点的，右子树中找到最小，删除的值置换为该值，并且删除右子树中最小的节点
     */


    //中序遍历
    public static  void mid(BinarySearchTree cur){
        if(cur==null){
            return;
        }
        mid(cur.getLeft());
        System.out.println(cur.getData());
        mid(cur.getRight());
    }
    public static void main(String[] args) {
        int [] datas = new int[]{100,80,200,54,90,150,210};

        for (int i = 0; i <datas.length ; i++) {
         insert(datas[i]);
        }

        System.out.println("中序遍历");

        mid(root);

        find(100);

    }
}
