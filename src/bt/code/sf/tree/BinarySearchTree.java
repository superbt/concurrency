package bt.code.sf.tree;

public class BinarySearchTree {
    private int data ;
    private BinarySearchTree left ;
    private  BinarySearchTree right ;

    public BinarySearchTree(int data, BinarySearchTree left, BinarySearchTree right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public BinarySearchTree(int data) {
        this.data = data;
    }

    public BinarySearchTree() {
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BinarySearchTree getLeft() {
        return left;
    }

    public void setLeft(BinarySearchTree left) {
        this.left = left;
    }

    public BinarySearchTree getRight() {
        return right;
    }

    public void setRight(BinarySearchTree right) {
        this.right = right;
    }
}
