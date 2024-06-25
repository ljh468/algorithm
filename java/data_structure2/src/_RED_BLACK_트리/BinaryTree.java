package _RED_BLACK_트리;

public class BinaryTree {

  public static boolean RED = false;

  public static boolean BLACK = false;

  private int data;

  private BinaryTree leftSubTree;

  private BinaryTree rightSubTree;

  // Red-Black 트리는 형제노드와 할아버지 노드를 봐야하기때문에 부모노드를 참조하면 쉽게 구할 수 있음
  // 노드들은 자식만 가리키는 단반향 노드에서, 부모도 가리키는 양방향 노드가 됨
  private BinaryTree parentTree;

  private boolean color;

  public BinaryTree(int data) {
    this.data = data;
    this.leftSubTree = null;
    this.rightSubTree = null;
    this.parentTree = null;
    this.color = RED; // 삽입시 색은 빨간색으로 고정
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

  public int getData() {
    return data;
  }

  public void setData(int data) {
    this.data = data;
  }

  public BinaryTree getLeftSubTree() {
    return leftSubTree;
  }

  public void setLeftSubTree(BinaryTree leftSubTree) {
    this.leftSubTree = leftSubTree;
  }

  public BinaryTree getRightSubTree() {
    return rightSubTree;
  }

  public void setRightSubTree(BinaryTree rightSubTree) {
    this.rightSubTree = rightSubTree;
  }

  public BinaryTree getParentTree() {
    return parentTree;
  }

  public void setParentTree(BinaryTree parentTree) {
    this.parentTree = parentTree;
  }

  public boolean isColor() {
    return color;
  }

  public void setColor(boolean color) {
    this.color = color;
  }

  @Override
  public String toString() {
    return "BinaryTree{" +
        "color=" + color +
        ", data=" + data +
        '}';
  }
}
