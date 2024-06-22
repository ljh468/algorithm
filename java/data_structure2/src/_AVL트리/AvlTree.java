package _AVL트리;

import lombok.Getter;

public class AvlTree {

  @Getter
  private BinaryTree root;

  public AvlTree() {
    this.root = null;
  }

  // 데이터가 있는 노드를 조회
  public BinaryTree search(int data) {
    BinaryTree currentNode = this.root;
    while (currentNode != null) {
      if (currentNode.getData() == data) {
        return currentNode;
      } else if (currentNode.getData() > data) {
        currentNode = currentNode.getLeftSubTree();
      } else {
        currentNode = currentNode.getRightSubTree();
      }
    }
    return null;
  }

  // 노드의 높이를 조회 (노드가 없다면 높이는 0)
  public int getHeight(BinaryTree node) {
    if (node == null) {
      return 0;
    }
    return node.getHeight();
  }

  // 노드의 높이를 새로 계산
  public void updateHeight(BinaryTree node) {
    int leftChildHeight = this.getHeight(node.getLeftSubTree());
    int rightChildHeight = this.getHeight(node.getRightSubTree());
    node.setHeight(Math.max(leftChildHeight, rightChildHeight) + 1);
  }

  // 해당 노드가 균형을 잃었는지 조회
  public int getBalanceFactor(BinaryTree node) {
    // 왼쪽노드의 높이에서 오른쪽 노드의 높이를 뺀 값 (왼쪽이 높으면 양수, 오른쪽이 높으면 음수)
    return this.getHeight(node.getLeftSubTree()) - this.getHeight(node.getRightSubTree());
  }

  // LL 회전 (오른쪽으로 쭉 뻗어있는 구조)
  public BinaryTree rotateLeft(BinaryTree node) {
    BinaryTree childNode = node.getRightSubTree();
    // 해당 노드를 오른쪽 자식노드의 왼쪽 자식노드로 변경해야함
    // 그러나, 오른쪽 자식노드에 왼쪽 자식노드가 있다면? 왼쪽 자식노드를 회전하려는 노드의 오른쪽 자식노드로 연결하면됨 (오른쪽 노드는 항상큼)
    node.setRightSubTree(childNode.getLeftSubTree());
    childNode.setLeftSubTree(node);

    // 높이를 새로계산
    updateHeight(node);
    updateHeight(childNode);
    return childNode;
  }

  // RR 회전 (왼쪽으로 쭉 뻗어있는 구조)
  public BinaryTree rotateRight(BinaryTree node) {
    BinaryTree childNode = node.getLeftSubTree();
    node.setLeftSubTree(childNode.getRightSubTree());
    childNode.setRightSubTree(node);

    updateHeight(node);
    updateHeight(childNode);
    return childNode;
  }

  // 실제로 LL, RR, LR, RL 회전시키는 함수
  // targetNode: 회전시킬 노드, data: 균형을 무너뜨린 데이터
  public BinaryTree rotation(BinaryTree targetNode, int data) {
    // 루트 노드가 회전하는지 확인
    boolean isRootNode = targetNode == this.root;

    // 1. LL회전이 필요한 경우 (오른쪽으로 뻗어있는 구조)
    if ((getBalanceFactor(targetNode) < -1) && data > targetNode.getRightSubTree().getData()) {
      targetNode = rotateLeft(targetNode);
    }
    // 2. RR회전이 필요한 경우 (왼쪽으로 뻗어 있는 구조)
    else if ((getBalanceFactor(targetNode) > 1) && data < targetNode.getLeftSubTree().getData()) {
      targetNode = rotateRight(targetNode);
    }
    // 3. RL회전이 필요한 경우 (오른쪽으로 볼록한 구조)
    else if ((getBalanceFactor(targetNode) < -1) && data < targetNode.getRightSubTree().getData()) {
      // 3-1. 타겟노드의 오른쪽 자식노드를 RR회전, RR회전된 서브트리의 루트노드를 타겟노드의 오른쪽 자식노드에 연결
      targetNode.setRightSubTree(rotateRight(targetNode.getRightSubTree()));
      // 3-2. 변경된 타겟노드를 LL회전
      targetNode = rotateLeft(targetNode);
    }
    // 4. LR회전이 필요한 경우 (왼쪽으로 볼록한 구조)
    else if ((getBalanceFactor(targetNode) > 1) && data > targetNode.getLeftSubTree().getData()) {
      // 4-1. 타겟노드의 왼쪽자식노드를 LL회전, LL회전된 서브트리의 루트노드를 타겟노드의 왼쪽노드에 연결
      targetNode.setLeftSubTree(rotateLeft(targetNode.getLeftSubTree()));
      // 4-2. 변경된 타겟노드를 RR회전
      targetNode = rotateRight(targetNode);
    }

    // 5. AVL트리의 루트노드가 변경되었다면, 새로바뀐 루트노드를 AVL루트노드로 설정
    if (isRootNode) {
      this.root = targetNode;
    }
    return targetNode;
  }

  public BinaryTree getUnBalanceNode(BinaryTree targetRootNode, BinaryTree unBalanceNode) {
    // 기저조건
    // 해당 노드의 자식노드가 하나도 없을때 함수 종료 (터미널 노드)
    if (targetRootNode.getLeftSubTree() == null && targetRootNode.getRightSubTree() == null) {
      unBalanceNode = targetRootNode;
      return unBalanceNode;
    }

    // 타겟루트 노드가 균형을 잃었는지 확인 (양수면 왼쪽이 더 높고 음수면 오른쪽이 더 높음)
    int balanceFactor = getBalanceFactor(targetRootNode);
    // 왼쪽이 더 높다면 왼쪽으로 재귀
    if (balanceFactor > 0) {
      unBalanceNode = getUnBalanceNode(targetRootNode.getLeftSubTree(), unBalanceNode);
    }
    // 오른쪽이 더 높다면 오른쪽으로 재귀
    else if (balanceFactor < 0) {
      unBalanceNode = getUnBalanceNode(targetRootNode.getRightSubTree(), unBalanceNode);
    }
    // 높이가 같다면, 오른쪽 자식노드를 선택
    // 회전을 하고 대체할 노드도 왼쪽 자식노드의 오른쪽 끝에 있는 자식노드로 함
    // 즉, 가장 큰값의 노드를 선택했기때문에 오른쪽으로 설정
    else {
      unBalanceNode = targetRootNode.getRightSubTree();
    }
    return unBalanceNode;
  }

}
