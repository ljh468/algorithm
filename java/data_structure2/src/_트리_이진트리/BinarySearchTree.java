package _트리_이진트리;

public class BinarySearchTree {

  private BinaryTree root;

  public BinarySearchTree() {
    this.root = null;
  }

  public BinaryTree getRoot() {
    return root;
  }

  public void insert(int data) {
    // 루트 노드가 없는경우
    if (this.root == null) {
      this.root = new BinaryTree(data);
      return;
    }

    // 루트 노드가 있다면, 데이터를 추가할 위치를 찾아야 함
    BinaryTree currentNode = this.root;
    BinaryTree parentNode = null; // 삽입할 위치의 부모 노드를 가리킬 임시변수

    // currentNode가 없을때 까지 반복해서 추가할 위치를 탐색
    while (currentNode != null) {
      parentNode = currentNode;
      if (data > currentNode.getData()) {
        currentNode = currentNode.getRightSubTree();
      } else if (data < currentNode.getData()) {
        currentNode = currentNode.getLeftSubTree();
      } else { // 중복된 값이 존재하면 while문 종료
        return;
      }
    }

    // 새로운 노드 추가
    BinaryTree newNode = new BinaryTree(data);
    // 데이터가 부모노드보다 크다면, 오른쪽에 노드추가
    if (data > parentNode.getData()) {
      parentNode.setRightSubTree(newNode);
    } else { // 데이터가 부모노드보다 작다면, 왼쪽에 노드추가
      parentNode.setLeftSubTree(newNode);
    }
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

  /**
   * 이진 탐색트리의 제거
   * 첫번째 상황 : 터미널 노드(자식이 없는 최하위 노드) 제거
   * - 단순히 부모노드와 연결만 끊어주면 간단히 제거됨
   * <p>
   * 두번째 상황 : 자식노드가 1개인 노드 제거
   * - 제거할 노드와 부모노드의 연결을 끊고, 부모노드와 제거할 노드의 자식노드를 연결해야함
   * <p>
   * 세번째 상황 : 자식노드가 2개인 노드 제거
   * - 왼쪽 자식 노드(트리)와 오른쪽 자식 노드(트리)를 모두 잃어버리게 됨
   * - 자식노드 중에 누군가가 대신해야 함 (이진 탐색트리의 조건을 무너뜨리지 않는 노드가 와야함)
   * - 제거될 노드의 왼쪽 자식 노드는 작은값들만 존재, 오른쪽 자식 노드는 큰값들만 존재
   * - 제거될 노드를 대신한다면, 왼쪽 자식 노드의 가장 큰값 or 오른쪽 자식 노드의 가장 작은값으로 할 수 있음
   * - 제거될 노드의 왼쪽 자식 노드의 가장 큰값을 구하려면?
   * - 1. 제거할 노드의 왼쪽 자식 노드로 이동 -> 오른쪽 자식노드가 없을때까지 계속 이동
   * - 2. 값이 있는 마지막 오른쪽 자식노드를 제거할 노드로 교체
   * - 3. 마지막 오른쪽 자식노드는 왼쪽 자식노드로 교체 (왼쪽 노드가 없으면 그냥 없앰)
   */
  public BinaryTree remove(int targetData) {
    // 루트노드를 제거할 때 사용하기 위한 페이크 노드 (루트노드의 임시 부모노드)
    BinaryTree fakeParentRootNode = new BinaryTree(0);
    BinaryTree parentNode = fakeParentRootNode;
    BinaryTree currentNode = this.root;
    BinaryTree deletingNode = null; // 제거할 노드

    // fakeParentRootNode의 자식으로 루트노드를 연결 (왼쪽, 오른쪽 상관없음)
    fakeParentRootNode.setRightSubTree(this.root);

    // 현재노드가 존재하고, 제거할 노드를 찾지 못할때 까지 반본
    while (currentNode != null && currentNode.getData() != targetData) {
      parentNode = currentNode;
      if (targetData < currentNode.getData()) {
        currentNode = currentNode.getLeftSubTree();
      } else {
        currentNode = currentNode.getRightSubTree();
      }
    }

    // 제거할 노드를 찾지 못한 경우 currentNode는 null을 가리킴, 함수 종료
    if (currentNode == null) {
      return null;
    }
    // 제거할 노드를 찾은경우 currentNode는 제거할 노드를 가리킴
    deletingNode = currentNode;

    // 1. 터미널 노드(자식이 없는 최하위 노드) 제거하려는 경우
    if (deletingNode.getLeftSubTree() == null && deletingNode.getRightSubTree() == null) {
      // 부모 노드와 연결끊기
      if (parentNode.getLeftSubTree() != null && parentNode.getLeftSubTree() == deletingNode) {
        parentNode.removeLeftSubTree();
      } else {
        parentNode.removeRightSubTree();
      }
    }
    // 2. 자식노드가 1개인 노드를 제거하려는 경우
    else if (deletingNode.getLeftSubTree() == null || deletingNode.getRightSubTree() == null) {
      // 제거할 노드의 자식노드 임시 저장
      BinaryTree deletingNodeChild;
      if (deletingNode.getLeftSubTree() != null) {
        deletingNodeChild = deletingNode.getLeftSubTree();
      } else {
        deletingNodeChild = deletingNode.getRightSubTree();
      }

      // 제거할 노드의 자식노드를 제거할 노드의 부모노드와 연결
      if (parentNode.getLeftSubTree() != null && parentNode.getLeftSubTree() == deletingNode) {
        parentNode.setLeftSubTree(deletingNodeChild);
      } else {
        parentNode.setRightSubTree(deletingNodeChild);
      }
    }
    // 3. 자식노드가 2개인 노드를 제거하려는 경우
    else {
      // 제거할 노드의 왼쪽 자식노드 준비
      BinaryTree replacingNode = deletingNode.getLeftSubTree();
      BinaryTree replacingNodeParent = deletingNode;
      // 왼쪽 자식노드에서 오른쪽으로 계속 이동한 노드 찾기
      while (replacingNode.getRightSubTree() != null) {
        replacingNodeParent = replacingNode;
        replacingNode = replacingNode.getRightSubTree();
      }
      // 제거할 값 저장
      int deletingNodeData = deletingNode.getData();
      // 제거할 노드의 값을 대체할 값으로 덮어씌움
      deletingNode.setData(replacingNode.getData());

      // 대체할 노드의 부모노드의 자식노드를 대체할 노드의 자식노드로 연결 (while문이 하나도 안돌수도 있음)
      // 대체할 노드의 부모노드의 왼쪽 자식이 대체할 노드라면?
      if (replacingNodeParent.getLeftSubTree() != null
          && replacingNodeParent.getLeftSubTree() == replacingNode) {
        // 대체할 노드의 부모노드의 왼쪽 자식노드를 대체할 노드의 왼쪽 자식노드로 설정
        // 대체할 노드가 가장 큰값이기때문에, 대체할 노드의 오른쪽 자식은 존재하지 않음
        replacingNodeParent.setLeftSubTree(replacingNode.getLeftSubTree());
      }
      // 대체할 노드의 부모노드의 오른쪽 자식이 대체할 노드라면?
      else {
        replacingNodeParent.setRightSubTree(replacingNode.getLeftSubTree());
      }

      // 삭제할 노드를 대체할 노드로 변경
      deletingNode = replacingNode;
      deletingNode.setData(deletingNodeData);
    }

    // 특수한 경우를 처리
    // 제거하려는 노드가 루트노드인 경우, 변경된 루트노드를 이 이진탐색트리의 루트노드로 다시 설정해야함
    // 루트 노드가 변경되었다면?
    if (fakeParentRootNode.getRightSubTree() != this.root) {
      this.root = fakeParentRootNode.getRightSubTree();
    }
    return deletingNode;
  }

  public static void main(String[] args) {
    BinarySearchTree binarySearchTree = new BinarySearchTree();
    binarySearchTree.insert(18);
    binarySearchTree.insert(15);
    binarySearchTree.insert(10);
    binarySearchTree.insert(6);
    binarySearchTree.insert(3);
    binarySearchTree.insert(8);
    binarySearchTree.insert(12);
    binarySearchTree.insert(11);
    binarySearchTree.insert(31);
    binarySearchTree.insert(27);
    binarySearchTree.insert(24);
    binarySearchTree.insert(20);
    binarySearchTree.insert(33);
    binarySearchTree.insert(35);
    binarySearchTree.insert(37);

    binarySearchTree.getRoot().inOrderTraversal(binarySearchTree.getRoot());

    System.out.println("==== 데이터 6 탐색 ====");
    System.out.println("binarySearchTree.search(6) = " + binarySearchTree.search(6).getData());

    System.out.println("==== 데이터 1 탐색 ====");
    System.out.println("binarySearchTree.search(1) = "
                           + (binarySearchTree.search(1) != null ? binarySearchTree.search(1).getData() : null));

    System.out.println("==== 데이터 10 제거 ====");
    System.out.println("remove(10) = " + binarySearchTree.remove(10));
    binarySearchTree.getRoot().inOrderTraversal(binarySearchTree.getRoot());

    System.out.println("==== 데이터 23 제거(존재하지 않음) ====");
    System.out.println("remove(23) = " + binarySearchTree.remove(23));
    binarySearchTree.getRoot().inOrderTraversal(binarySearchTree.getRoot());

    System.out.println("==== 루트노드 18 제거 ====");
    System.out.println("remove(18) = " + binarySearchTree.remove(18));
    System.out.println("rootNode = " + binarySearchTree.getRoot());
  }

}
