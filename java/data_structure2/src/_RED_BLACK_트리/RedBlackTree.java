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
      } else if (targetData < currentNode.getData()) { // targetData가 작으면 왼쪽
        currentNode = currentNode.getLeftSubTree();
      } else if (targetData > currentNode.getData()) { // targetData가 크면 오른쪽
        currentNode = currentNode.getRightSubTree();
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

  public void remove(int data) {
    BinaryTree currentNode = this.root;
    // 제거할 노드 탐색
    while (currentNode != null && currentNode.getData() != data) {
      if (data < currentNode.getData()) {
        currentNode = currentNode.getLeftSubTree();
      } else if (data > currentNode.getData()) {
        currentNode = currentNode.getRightSubTree();
      }
    }

    // 제거할 노드를 찾지 못하면 함수 종료
    if (currentNode == null) {
      return;
    }

    BinaryTree replaceNode = null; // 대체할 노드를 담을 변수
    boolean deletedNodeColor = RED; // 제거된 노드의 색을 담을 변수

    // 제거할 노드의 자식노드가 0 ~ 1개일때 처리 (즉, 자식노드가 1개 이하라면)
    if (currentNode.getLeftSubTree() == null || currentNode.getRightSubTree() == null) {
      replaceNode = this.removeWithZeroOneChild(currentNode);
      deletedNodeColor = currentNode.isColor();
    }
    // 제거할 노드의 자식노드가 2개일때 처리
    else {
      // 대체할 노드 탐색 (대체할 노드는 제거하려는 노드의 왼쪽자식노드에서 가장 큰 값)
      BinaryTree successor = getBiggestNode(currentNode.getLeftSubTree());
      // 현재노드를 대체할 노드의 값으로 교체
      currentNode.setData(successor.getData());
      replaceNode = this.removeWithZeroOneChild(successor); // 가장 큰 노드는 자식노드가 1개 이하임
      deletedNodeColor = currentNode.isColor();
    }

    // Red-Black 트리 규칙을 위반했는지 체크하고 처리
    // 제거했을 때 문제가 되는 노드는 제거한 노드가 검은색인 경우
    if (deletedNodeColor == BLACK) {
      // 형제노드를 보면서 5가지 경우를 처리해야함
      this.rebalanceAfterDeletion(replaceNode);
      // 대체한 노드를 처리할때, null대신 임시로 NilNode로 연결해서 처리한 경우에 다시 null로 변경
      if (replaceNode instanceof NilNode) {
        this.replaceParentsChild(replaceNode.getParentTree(), replaceNode, null);
      }
    }


  }

  // 삭제후 균형을 맞춰주는 함수 (대체된 노드를 매개변수로 가짐)
  void rebalanceAfterDeletion(BinaryTree node) {
    // 대체한 노드가 루트노드인 경우
    if (node == this.root) {
      node.setColor(BLACK);
      return;
    }

    BinaryTree sibling = getSibling(node);
    // 1. 형제노드가 빨간색인 경우
    if (sibling.isColor() == RED) {
      this.handleRedSibling(node, sibling);
      // 1번 규칙을 제외한 나머지 규칙을 다시 위반할 수 있음 (회전이 이루어지기 때문)
      // 다음 단계에서 확인할 수 있도록 형제노드를 업데이트
      sibling = this.getSibling(node);
    }

    // 2 ~ 5. 형제노드가 검은색인 경우
    if (this.isBlack(sibling)) {
      // 2 ~ 3. 형제노드의 두자식 노드가 모두 검은색인 경우
      if (isBlack(sibling.getLeftSubTree()) && isBlack(sibling.getRightSubTree())) {
        // 2. 형제노드와 형제노드의 두자식 노드가 모두 검은색이고, 부모노드가 빨간색인 경우
        if (node.getParentTree().isColor() == RED) {
          sibling.setColor(RED); // 형제노드를 빨간색
          node.getParentTree().setColor(BLACK); // 부모노드를 검은색
        }
        // 3. 형제노드와 형제노드의 두자식 노드, 부모노드가 모두 검은색인 경우
        else {
          sibling.setColor(RED); // 형제노드를 빨간색
          // 5번 규칙(모든 경로는 검은색의 갯수가 같음)을 위반하게됨
          // 균형을 맞출수 있도록 부모노드를 대상으로 재귀호출해줌
          this.rebalanceAfterDeletion(node.getParentTree());
        }
      }
      // 4 ~ 5. 형제의 두 자식노드중 하나라도 빨간색인 경우
      else {
        // 4. 형제노드가 검은색이고 형제노드의 두 자식노드 중 하나라도 빨간색 노드가 있고 "바깥쪽 조카 노드"가 검은색인 경우
        // 5. 형제노드가 검은색이고 형제노드의 두 자식노드 중 하나라도 빨간색 노드가 있고 "바깥쪽 조카 노드"가 빨간색인 경우
        this.handleBlackSiblingWithAtLeastOneRedChild(node, sibling);
      }
    }

  }

  BinaryTree removeWithZeroOneChild(BinaryTree node) {
    // 제거할 노드가 왼쪽 자식이 있는 경우
    if (node.getLeftSubTree() != null) {
      this.replaceParentsChild(node.getParentTree(), node, node.getLeftSubTree());
      return node.getLeftSubTree();
    }
    // 제거할 노드가 오른쪽 자식이 있는 경우
    else if (node.getRightSubTree() != null) {
      this.replaceParentsChild(node.getParentTree(), node, node.getRightSubTree());
      return node.getRightSubTree();
    }
    // 자식노드가 모두 Null인 경우
    else {
      // 제거한 노드가 검은색이라면 균형 처리를 해주기위해 NilNode를 연결시켜줌
      BinaryTree newChild = (node.isColor() == BLACK) ? new NilNode() : null;
      this.replaceParentsChild(node.getParentTree(), node, newChild);
      return newChild;
    }
  }

  BinaryTree getBiggestNode(BinaryTree node) {
    while (node.getRightSubTree() != null) {
      node = node.getRightSubTree();
    }
    return node;
  }

  // 형제노드를 구하는 함수
  BinaryTree getSibling(BinaryTree node) {
    BinaryTree parentNode = node.getParentTree();
    if (node == parentNode.getLeftSubTree()) {
      return parentNode.getRightSubTree();
    } else {
      return parentNode.getLeftSubTree();
    }
  }

  // 균형을 잡을때 형제노드가 빨간색인 경우에 처리하는 함수
  void handleRedSibling(BinaryTree node, BinaryTree sibling) {
    sibling.setColor(BLACK); // 형제노드 검은색으로 변경
    node.getParentTree().setColor(RED); // 부모노드 빨간색으로 변경
    // 부모노드를 대체된 노드의 방향으로 회전
    if (node.getParentTree().getLeftSubTree() == node) {
      this.rotateLeft(node.getParentTree());
    } else {
      this.rotateRight(node.getRightSubTree());
    }
  }

  // 균형을 잡을때 형제노드가 검은색이고, 형제의 두 자식노드중 하나라도 빨간색인 경우 처리하는 함수
  void handleBlackSiblingWithAtLeastOneRedChild(BinaryTree node, BinaryTree sibling) {
    // 대체되는 노드가 부모노드의 왼쪽 자식노드인지 체크
    boolean nodeIsLeftChild = (node.getParentTree().getLeftSubTree() == node);

    // 4. 형제노드가 검은색이고 형제노드의 두 자식노드 중 하나라도 빨간색 노드가 있고 "바깥쪽 조카 노드"가 검은색인 경우
    // 4-1. 대체되는 노드가 부모노드의 왼쪽 자식노드이고, 형제노드의 오른쪽 자식노드(null)가 검은색인 조건
    if (nodeIsLeftChild && isBlack(sibling.getRightSubTree())) {
      // 안쪽 조카노드를 검은색으로 변경
      sibling.getLeftSubTree().setColor(BLACK);
      // 형제노드를 빨간색으로 변경, 그리고 형제노드를 RR 회전
      sibling.setColor(RED);
      this.rotateRight(sibling);
      // 오른쪽으로 쭉 뻗은 구조가 됨 (5번 처리 경우이기때문에 형제노드를 업데이트)
      sibling = node.getParentTree().getRightSubTree();
    }
    // 4-2. 대체되는 노드가 부모노드의 오른쪽 자식노드이고, 형제노드의 왼쪽 자식노드(null)가 검은색인 조건
    else if (!nodeIsLeftChild && isBlack(sibling.getLeftSubTree())) {
      sibling.getRightSubTree().setColor(BLACK);
      sibling.setColor(RED);
      this.rotateLeft(sibling);
      sibling = node.getParentTree().getLeftSubTree();
    }

    // 5. 형제노드가 검은색이고 형제노드의 두 자식노드 중 하나라도 빨간색 노드가 있고 "바깥쪽 조카 노드"가 빨간색인 경우
    // (4번 로직이 처리된 이후의 경우에도 해당)

    // 형제노드의 색을 부모노드의 색으로 변경
    sibling.setColor(node.getParentTree().isColor());
    // 부모노드의 색을 검은색으로 변경
    node.getParentTree().setColor(BLACK);
    // 대체되는 노드가 부모노드의 왼쪽 자식노드인 경우 (즉, 오른쪽으로 뻗은 트리)
    if (nodeIsLeftChild) {
      // 형제노드의 오른쪽 자식노드를 검은색으로 변경
      sibling.getRightSubTree().setColor(BLACK);
      // 부모노드를 제거한 노드방향으로 회전 (LL회전)
      rotateLeft(node.getParentTree());
    } else {
      // 형제노드의 왼쪽 자식노드를 검은색으로 변경
      sibling.getLeftSubTree().setColor(BLACK);
      // 부모노드를 제거한 노드방향으로 회전 (RR회전)
      rotateRight(node.getParentTree());
    }
  }

  public static void main(String[] args) {
    RedBlackTree redBlackTree = new RedBlackTree();

    System.out.println("========== insert 17, 9, 19, 75, 85 ==========");
    redBlackTree.insert(17);
    redBlackTree.insert(9);
    redBlackTree.insert(19);
    redBlackTree.insert(75);
    redBlackTree.insert(85);

    System.out.println("ROOT NODE = " + redBlackTree.getRoot());
    System.out.println("17 NODE = " + redBlackTree.search(17));
    System.out.println("9 NODE = " + redBlackTree.search(9));
    System.out.println("19 NODE = " + redBlackTree.search(19));
    System.out.println("75 NODE = " + redBlackTree.search(75));
    System.out.println("85 NODE = " + redBlackTree.search(85));

    System.out.println("========== 중위순회 ==========");
    redBlackTree.getRoot().inOrderTraversal(redBlackTree.getRoot());

    System.out.println("========== remove 19, 75, 85 ==========");
    redBlackTree.remove(19);
    redBlackTree.remove(75);
    redBlackTree.remove(85);
    System.out.println("ROOT NODE = " + redBlackTree.getRoot());
    System.out.println("17 NODE = " + redBlackTree.search(17));
    System.out.println("9 NODE = " + redBlackTree.search(9));
    System.out.println("19 NODE = " + redBlackTree.search(19));
    System.out.println("75 NODE = " + redBlackTree.search(75));
    System.out.println("85 NODE = " + redBlackTree.search(85));

    System.out.println("========== 중위순회 ==========");
    redBlackTree.getRoot().inOrderTraversal(redBlackTree.getRoot());
  }

}