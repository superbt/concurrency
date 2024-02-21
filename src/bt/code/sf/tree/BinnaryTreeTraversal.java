package bt.code.sf.tree;

public class BinnaryTreeTraversal {

    //前序遍历
    //当前节点-》左子树-》右子树
    public static  void pre(TreeNode cur){
        if(cur==null){
            return;
        }
        System.out.println(cur.getData());
        pre(cur.getLeft());
        pre(cur.getRight());
    }

    //中序遍历
    //左子树-》当前节点-》右子树
    public static  void mid(TreeNode cur){
        if(cur==null){
            return;
        }
        mid(cur.getLeft());
        System.out.println(cur.getData());
        mid(cur.getRight());
    }

    //后序遍历
    //左子树-》右子树-》当前节点
    public static void post(TreeNode cur){
        if(cur==null){
            return;
        }
        post(cur.getLeft());
        post(cur.getRight());
        System.out.println(cur.getData());
    }
    public static void main(String[] args) {
        TreeNode a = new TreeNode("A");
        TreeNode b = new TreeNode("B");
        TreeNode c = new TreeNode("C");
        TreeNode d = new TreeNode("D");
        TreeNode e = new TreeNode("E");
        TreeNode f = new TreeNode("F");
        TreeNode g = new TreeNode("G");
        TreeNode h = new TreeNode("H");

        a.setLeft(b);
        a.setRight(c);

        b.setLeft(d);
        b.setRight(e);

        d.setLeft(h);

        c.setLeft(f);
        c.setRight(g);

        System.out.println("前序遍历");
        pre(a);
        System.out.println("中序遍历");
        mid(a);
        System.out.println("后序遍历");
        post(a);
    }
}
