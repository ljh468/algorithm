package _RED_BLACK_트리;


public class RedBlackTree {

  private BinaryTree root;

  public RedBlackTree() {
    this.root = null;
  }

  public BinaryTree getRoot() {
    return root;
  }

  public BinaryTree search(int targetData) {
    BinaryTree currentNode = this.root;

    // targetData를 찾거나, 없을때까지 계속 아래노드로 이동하도록 반복
    while (currentNode != null) {
      // targetData == currentNode.getData()가 같으면 탐색완료
      if (targetData == currentNode.getData()) {
        return currentNode;
      } else if (targetData > currentNode.getData()) { // targetData가 크면 오른쪽
        currentNode = currentNode.getRightSubTree();
      } else if (targetData < currentNode.getData()) { // targetData가 작으면 왼쪽
        currentNode = currentNode.getLeftSubTree();
      }
    }
    // 만약 찾을 데이터가 없으면 null 리턴
    return null;
  }

  // LL 회전, 회전할 노드와 자식노드, 손자노드가 오른쪽으로 쭉 뻗은 구조
  public void rotateLeft(BinaryTree node) {
    // 회전을 하게되면 그 자리에 다른 노드가 들어오기 때문에, 부모노드가 자식노드를 대체한 노드로 연결해줘야함
    BinaryTree parent = node.getParentTree();
    BinaryTree rightChild = node.getRightSubTree(); // LL회전은 오른쪽으로 쭉 뻗어있기 때문에, 오른쪽 자식만 존재

    // 회전하는 노드의 오른쪽 자식노드를 오른쪽 자식노드의 왼쪽 자식노드와 연결 (양방향 처리)
    node.setRightSubTree(rightChild.getLeftSubTree());
    if (rightChild.getLeftSubTree() != null) {
      rightChild.getLeftSubTree().setParentTree(node);
    }

    // 오른쪽 자식노드의 왼쪽 자식노드를 회전할 노드로 변경 (양방향 처리)
    rightChild.setLeftSubTree(node);
    node.setParentTree(rightChild);

    // 부모노드의 자식노드로 회전할 노드의 오른쪽 자식노드로 연결 (양방향 처리) - replaceParentsChild
    this.replaceParentsChild(parent, node, rightChild);
  }

  // parent가 자식으로 가리키던 oldChild를 newChild로 변경하는 함수
  public void replaceParentsChild(BinaryTree parent, BinaryTree oldChild, BinaryTree newChild) {
    // 해당 노드가 루트노드인 경우
    if (parent == null) {
      this.root = newChild;
    }
    // parent의 왼쪽 자식노드에 oldChild가 연결되어있다면?
    else if (parent.getLeftSubTree() == oldChild) {
      parent.setLeftSubTree(newChild);
    } else if (parent.getRightSubTree() == oldChild) {
      parent.setRightSubTree(newChild);
    }
    // 양방향 연결
    if (newChild != null) {
      newChild.setParentTree(parent);
    }
  }

  // RR 회전, 회전할 노드와 자식노드, 손자노드가 왼쪽으로 쭉 뻗은 구조
  public void rotateRight(BinaryTree node) {
    BinaryTree parent = node.getParentTree();
    BinaryTree leftChild = node.getLeftSubTree();

    node.setLeftSubTree(leftChild.getRightSubTree());
    if (leftChild.getRightSubTree() != null) {
      leftChild.getRightSubTree().setParentTree(node);
    }

    leftChild.setRightSubTree(node);
    node.setParentTree(leftChild);

    this.replaceParentsChild(parent, node, leftChild);
  }

  public static void main(String[] args) {
    RedBlackTree redBlackTree = new RedBlackTree();
    System.out.println("redBlackTree = " + redBlackTree);
    System.out.println("redBlackTree.getRoot() = " + redBlackTree.getRoot());
  }

}