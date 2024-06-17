package _트리_이진트리;

/**
 * 이진트리
 * - 자식 노드가 2개 이하인 트리
 */
public class BinaryTree {

  private int data;

  private BinaryTree leftSubTree;

  private BinaryTree rightSubTree;

  public BinaryTree(int data) {
    this.data = data;
    this.leftSubTree = null;
    this.rightSubTree = null;
  }

  // getData() - 해당트리(노드)의 데이터 리턴
  int getData() {
    return this.data;
  }

  // setData(data) - 해당 트리(노드)의 데이터 설정
  void setData(int data) {
    this.data = data;
  }

  // getLeftSubTree() - 해당 트리(노드)의 왼쪽 서브 트리 리턴
  BinaryTree getLeftSubTree() {
    return this.leftSubTree;
  }

  // getRightSubTree() - 해당 트리(노드)의 오른쪽 서브 트리 리턴
  BinaryTree getRightSubTree() {
    return this.rightSubTree;
  }

  // setLeftSubTree(tree) - 해당 트리의 왼쪽 서브 트리를 tree로 설정
  void setLeftSubTree(BinaryTree tree) {
    this.leftSubTree = tree;
  }

  // setRightSubTree(tree) - 해당 트리의 오른쪽 서브 트리를 tree로 설정
  void setRightSubTree(BinaryTree tree) {
    this.rightSubTree = tree;
  }

  // preOrderTraversal()
  // 전위 순회 : (루트 노드를 먼저 방문하고, 그 다음 노드들을 방문하는 것)
  void preOrderTraversal(BinaryTree tree) {
    // 기저조건
    if (tree == null) return;
    // 루트 -> 왼쪽 -> 오른쪽
    System.out.println(tree.getData());
    preOrderTraversal(tree.getLeftSubTree());
    preOrderTraversal(tree.getRightSubTree());
  }

  // inOrderTraversal()
  // 중위 순회 : (왼쪽 노드를 먼저 방문하고, 그다음의 자신의 노드, 그다음 오른쪽 노드를 방문)
  void inOrderTraversal(BinaryTree tree) {
    // 기저조건
    if(tree == null) return;
    // 왼쪽 -> 루트 -> 오른쪽
    inOrderTraversal(tree.getLeftSubTree());
    System.out.println(tree.getData());
    inOrderTraversal(tree.getRightSubTree());
  }

  // postOrderTraversal()
  // 후위 순회 : (자식 노드들을 먼저 방문하고, 자신의 노드를 방문)
  void postOrderTraversal(BinaryTree tree) {
    // 기저조건
    if(tree == null) return;
    // 왼쪽 -> 오른쪽 -> 루트
    postOrderTraversal(tree.getLeftSubTree());
    postOrderTraversal(tree.getRightSubTree());
    System.out.println(tree.getData());
  }

  /**
   * BinarySearchTree에서 노드를 제거하기 위해 필요한 함수
   */
  // 1. removeLeftSubTree() - 왼쪽 자식노드를 제거
  BinaryTree removeLeftSubTree() {
    // 제거할 노드는 반환해야하기 때문에, 변수에 저장
    BinaryTree deletingNode = this.getLeftSubTree();
    // 왼쪽 자식노드 연결 끊기
    this.setLeftSubTree(null);
    return deletingNode;
  }

  // 2. removeRightSubTree() - 오른쪽 자식노드를 제거
  BinaryTree removeRightSubTree() {
    // 제거할 노드는 반환해야하기 때문에, 변수에 저장
    BinaryTree deletingNode = this.getLeftSubTree();
    // 왼쪽 자식노드 연결 끊기
    this.setRightSubTree(null);
    return deletingNode;
  }

  @Override
  public String toString() {
    return "BinaryTree{" +
        "data=" + data +
        ", leftSubTree=" + leftSubTree +
        ", rightSubTree=" + rightSubTree +
        '}';
  }

  public static void main(String[] args) {
    BinaryTree tree1 = new BinaryTree(1);
    BinaryTree tree2 = new BinaryTree(2);
    BinaryTree tree3 = new BinaryTree(3);
    BinaryTree tree4 = new BinaryTree(4);
    BinaryTree tree5 = new BinaryTree(5);
    BinaryTree tree6 = new BinaryTree(6);
    BinaryTree tree7 = new BinaryTree(7);

    tree1.setLeftSubTree(tree2);
    tree1.setRightSubTree(tree3);
    tree2.setLeftSubTree(tree4);
    tree2.setRightSubTree(tree5);
    tree3.setLeftSubTree(tree6);
    tree3.setRightSubTree(tree7);

    System.out.println("루트노드의 오른쪽 자식노드 = " + tree1.getRightSubTree().getData());
    System.out.println("루트노드의 오른쪽 자식노드의 왼쪽 자식노드 = "
                           + tree1.getRightSubTree().getLeftSubTree().getData());

    // 트리를 전체 출력하려면, 재귀를 이용할 수 있음
    System.out.println("전위 순회");
    tree1.preOrderTraversal(tree1);

    System.out.println("중위 순회");
    tree1.inOrderTraversal(tree1);

    System.out.println("후위 순회");
    tree1.postOrderTraversal(tree1);

  }
}
