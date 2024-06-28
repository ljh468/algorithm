package _RED_BLACK_트리;


import static _RED_BLACK_트리.BinaryTree.BLACK;
import static _RED_BLACK_트리.BinaryTree.RED;

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

  // LL 회전 (회전할 노드와 자식노드, 손자노드가 오른쪽으로 쭉 뻗은 구조)
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

  // RR 회전 (회전할 노드와 자식노드, 손자노드가 왼쪽으로 쭉 뻗은 구조)
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

  // parent가 자식으로 가리키던 oldChild를 newChild로 변경하는 함수
  public void replaceParentsChild(BinaryTree parent, BinaryTree oldChild, BinaryTree newChild) {
    // 해당 노드가 루트노드인 경우
    if (parent == null) {
      this.root = newChild;
    }
    // parent의 왼쪽 자식노드에 oldChild가 연결되어있다면? 왼쪽 자식노드에 새로운 노드 연결
    else if (parent.getLeftSubTree() == oldChild) {
      parent.setLeftSubTree(newChild);
    }
    // parent의 오른쪽 자식노드에 oldChild가 연결되어있다면? 오른쪽 자식노드에 새로운 노드 연결
    else if (parent.getRightSubTree() == oldChild) {
      parent.setRightSubTree(newChild);
    }
    // 양방향 연결
    if (newChild != null) {
      newChild.setParentTree(parent);
    }
  }

  public void insert(int data) {
    BinaryTree current = this.root;
    BinaryTree parent = null;
    while (current != null) {
      parent = current;
      if (data < current.getData()) {
        current = current.getLeftSubTree();
      } else if (data > current.getData()) {
        current = current.getRightSubTree();
      } else {
        return;
      }
    }

    BinaryTree newNode = new BinaryTree(data);
    if (parent == null) {
      this.root = newNode;
    } else if (data < parent.getData()) {
      parent.setLeftSubTree(newNode);
    } else if (data > parent.getData()) {
      parent.setRightSubTree(newNode);
    }
    newNode.setParentTree(parent);
    this.rebalanceAfterInsertion(newNode);
  }

  // 데이터 삽입후 4가지를 나눠서 Recoloring과 회전을 해서 균형을 맞춰주는 함수
  void rebalanceAfterInsertion(BinaryTree node) {
    // 1. 새로운 노드가 루트노드인 경우
    BinaryTree parent = node.getParentTree();
    if (parent == null) {
      node.setColor(BLACK);
      return;
    }

    // 2. 부모노드와 삼촌노드가 빨간색인 경우
    if (parent.isColor() == BLACK) {
      return;
    }
    BinaryTree uncle = getUncle(parent);
    BinaryTree grandParent = parent.getParentTree();
    if (uncle != null && uncle.isColor() == RED) {
      // 부모노드와 삼촌노드를 검은색으로
      parent.setColor(BLACK);
      uncle.setColor(BLACK);
      grandParent.setColor(RED); // 4번 규칙 위반 가능 (연속해서 빨간색 노드가 올 수 없음)
      // 할아버지 노드를 대상으로 재귀 호출
      this.rebalanceAfterInsertion(grandParent);
    }

    // 3. 부모노드는 빨간색이고 삼촌노드는 검은색, 새로운 노드는 안쪽 손자인 경우
    // 삼촌노드가 검은색인 경우는 노드의 color가 검은색인 경우도 있지만, NilNode인 경우가 있을 수 있음
    // NilNode는 null로 처리하기 때문에 color 프로퍼티에 접근할 수 없음 (한번에 체크하는 함수 필요)
    else if (this.isBlack(uncle)) {
      // 오른쪽 뻗은 트리의 안쪽 손자 (오른쪽 볼록)
      // 먼저 할아버지노드의 오른쪽 자식노드가 부모노드이고,
      if (grandParent.getRightSubTree() == parent && parent.getLeftSubTree() == node) {
        // 부모노드를 삽입된 노드의 반대반향으로 회전해줘야함 (RR회전)
        // 삽입된 노드는 왼쪽이기때문에 오른쪽으로 회전
        rotateRight(parent);
        // 할아버지 노드를 부모노드가 회전했던 반대방향으로 회전
        rotateLeft(grandParent);
        // 그리고 삽입한 노드를 검은색, 할아버지 노드를 빨간색
        node.setColor(BLACK);
        grandParent.setColor(RED);
      }
      // 왼쪽으로 뻗은 트리의 안쪽 손자 (왼쪽 볼록)
      else if (grandParent.getLeftSubTree() == parent && parent.getRightSubTree() == node) {
        rotateLeft(parent);
        rotateRight(grandParent);
        node.setColor(BLACK);
        grandParent.setColor(RED);
      }
      // 4. 부모노드는 빨간색이고 삼촌노드는 검은색이고 새로운 노드는 바깥쪽 손자인 경우 (손자 노드가 바깥쪽인지만 알면됨)
      // 할아버지 노드부터 손자 노드까지 오른쪽 뻗은 트리
      else if (grandParent.getRightSubTree() == parent && parent.getRightSubTree() == node) {
        // 할아버지 노드를 새로운 노드가 삽입된 반대방향으로 회전
        rotateLeft(grandParent);
        // 부노노드를 검은색으로, 할아버지 노드는 빨간색
        parent.setColor(BLACK);
        grandParent.setColor(RED);
      }
      // 할아버지 노드부터 손자 노드까지 왼쪽 뻗은 트리
      else if (grandParent.getLeftSubTree() == parent && parent.getLeftSubTree() == node) {
        // 할아버지 노드를 삽입된 노드의 반대방향으로 회전
        rotateRight(grandParent);
        // 부노노드를 검은색으로, 할아버지 노드는 빨간색
        parent.setColor(BLACK);
        grandParent.setColor(RED);
      }

    }

  }

  // 삼촌노드를 구하는 구하는 함수 (부모노드의 형제노드)
  BinaryTree getUncle(BinaryTree parent) {
    BinaryTree grandParent = parent.getParentTree();
    if (grandParent.getLeftSubTree() == parent) {
      return grandParent.getRightSubTree();
    } else if (grandParent.getRightSubTree() == parent) {
      return grandParent.getLeftSubTree();
    }

    return null;
  }

  // 검은색 노드인지 확인하는 함수
  boolean isBlack(BinaryTree node) {
    return node == null || node.isColor() == BLACK;
  }

  public static void main(String[] args) {
    RedBlackTree redBlackTree = new RedBlackTree();

    System.out.println("========== insert ==========");
    redBlackTree.insert(17);
    redBlackTree.insert(9);
    redBlackTree.insert(19);
    redBlackTree.insert(75);
    redBlackTree.insert(85);

    System.out.println("ROOT NODE = " + redBlackTree.getRoot());
    System.out.println("9 NODE = " + redBlackTree.search(9));
    System.out.println("19 NODE = " + redBlackTree.search(19));
    System.out.println("75 NODE = " + redBlackTree.search(75));
    System.out.println("85 NODE = " + redBlackTree.search(85));
    System.out.println("========== 중위순회 ==========");
    redBlackTree.getRoot().inOrderTraversal(redBlackTree.getRoot());
  }

}