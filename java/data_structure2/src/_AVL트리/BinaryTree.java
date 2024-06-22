package _AVL트리;

public class BinaryTree {

  private int data;

  private BinaryTree leftSubTree;

  private BinaryTree rightSubTree;

  private int height;

  public BinaryTree(int data) {
    this.data = data;
    this.leftSubTree = null;
    this.rightSubTree = null;
    this.height = 1;
  }

  int getData() {
    return this.data;
  }

  void setData(int data) {
    this.data = data;
  }

  BinaryTree getLeftSubTree() {
    return this.leftSubTree;
  }

  BinaryTree getRightSubTree() {
    return this.rightSubTree;
  }

  int getHeight() {
    return this.height;
  }

  void setHeight(int height) {
    this.height = height;
  }

  void setLeftSubTree(BinaryTree tree) {
    this.leftSubTree = tree;
  }

  void setRightSubTree(BinaryTree tree) {
    this.rightSubTree = tree;
  }

  void preOrderTraversal(BinaryTree tree) {
    if (tree == null) return;
    System.out.println(tree.getData());
    preOrderTraversal(tree.getLeftSubTree());
    preOrderTraversal(tree.getRightSubTree());
  }

  void inOrderTraversal(BinaryTree tree) {
    if (tree == null) return;
    inOrderTraversal(tree.getLeftSubTree());
    System.out.println(tree.getData());
    inOrderTraversal(tree.getRightSubTree());
  }

  void postOrderTraversal(BinaryTree tree) {
    if (tree == null) return;
    postOrderTraversal(tree.getLeftSubTree());
    postOrderTraversal(tree.getRightSubTree());
    System.out.println(tree.getData());
  }

  BinaryTree removeLeftSubTree() {
    BinaryTree deletingNode = this.getLeftSubTree();
    this.setLeftSubTree(null);
    return deletingNode;
  }

  BinaryTree removeRightSubTree() {
    BinaryTree deletingNode = this.getLeftSubTree();
    this.setRightSubTree(null);
    return deletingNode;
  }

  @Override
  public String toString() {
    return "BinaryTree{" +
        "data=" + data +
        ", leftSubTree=" + leftSubTree +
        ", rightSubTree=" + rightSubTree +
        ", height=" + height +
        '}';
  }
}
