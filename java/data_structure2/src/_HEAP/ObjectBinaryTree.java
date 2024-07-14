package _HEAP;

public class ObjectBinaryTree<T> {

  private T data;

  private ObjectBinaryTree<T> leftSubTree;

  private ObjectBinaryTree<T> rightSubTree;

  private ObjectBinaryTree<T> parentTree;

  public ObjectBinaryTree(T data) {
    this.data = data;
    this.leftSubTree = null;
    this.rightSubTree = null;
    this.parentTree = null;
  }

  void preOrderTraversal(ObjectBinaryTree<T> tree) {
    if (tree == null) return;
    System.out.println(tree.getData());
    preOrderTraversal(tree.getLeftSubTree());
    preOrderTraversal(tree.getRightSubTree());
  }

  void inOrderTraversal(ObjectBinaryTree<T> tree) {
    if (tree == null) return;
    inOrderTraversal(tree.getLeftSubTree());
    System.out.println(tree.getData());
    inOrderTraversal(tree.getRightSubTree());
  }

  void postOrderTraversal(ObjectBinaryTree<T> tree) {
    if (tree == null) return;
    postOrderTraversal(tree.getLeftSubTree());
    postOrderTraversal(tree.getRightSubTree());
    System.out.println(tree.getData());
  }

  ObjectBinaryTree<T> removeLeftSubTree() {
    ObjectBinaryTree<T> deletingNode = this.getLeftSubTree();
    this.setLeftSubTree(null);
    return deletingNode;
  }

  ObjectBinaryTree<T> removeRightSubTree() {
    ObjectBinaryTree<T> deletingNode = this.getRightSubTree();
    this.setRightSubTree(null);
    return deletingNode;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public ObjectBinaryTree<T> getLeftSubTree() {
    return leftSubTree;
  }

  public void setLeftSubTree(ObjectBinaryTree<T> leftSubTree) {
    this.leftSubTree = leftSubTree;
  }

  public ObjectBinaryTree<T> getRightSubTree() {
    return rightSubTree;
  }

  public void setRightSubTree(ObjectBinaryTree<T> rightSubTree) {
    this.rightSubTree = rightSubTree;
  }

  public ObjectBinaryTree<T> getParentTree() {
    return parentTree;
  }

  public void setParentTree(ObjectBinaryTree<T> parentTree) {
    this.parentTree = parentTree;
  }

  @Override
  public String toString() {
    return "BinaryTree{" +
        "data=" + data +
        '}';
  }
}