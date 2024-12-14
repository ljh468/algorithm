package _HEAP;

public class Heap {

  private BinaryTree root;

  private BinaryTree lastInsertedNode;

  public Heap() {
    this.root = null;
    this.lastInsertedNode = null;
  }

  public BinaryTree getRoot() {
    return root;
  }

  public void setRoot(BinaryTree root) {
    this.root = root;
  }

  public BinaryTree getLastInsertedNode() {
    return lastInsertedNode;
  }

  public void setLastInsertedNode(BinaryTree lastInsertedNode) {
    this.lastInsertedNode = lastInsertedNode;
  }

  public void insert(int data) {
    // 데이터를 최초로 삽입하는 경우
    if (this.lastInsertedNode == null) {
      this.lastInsertedNode = new BinaryTree(data);
      this.root = this.lastInsertedNode;
      return;
    }

    // 데이터를 처음 삽입하지 않는 경우
    // 마지막에 삽입된 노드의 다음위치를 찾는 것은 복잡함

    // 새로 데이터가 삽입될 노드위치의 부모노드를 리턴
    BinaryTree insertingParent = getInsertingParent();

    // 새로운 노드 삽입
    BinaryTree newNode = new BinaryTree(data);
    if (insertingParent.getLeftSubTree() == null) {
      insertingParent.setLeftSubTree(newNode);
    } else if (insertingParent.getRightSubTree() == null) {
      insertingParent.setRightSubTree(newNode);
    }
    newNode.setParentTree(insertingParent);
    this.lastInsertedNode = newNode;

    // 새로 삽입된 데이터를 부모노드와 비교하면서, 우선순위에 맞게 위치를 찾음
    while (newNode.getParentTree() != null) {
      // 새로 삽입된 노드가 부모노드보다 우선순위가 높다면 자리 변경
      if (this.isBigPriority(newNode.getData(),
                             newNode.getParentTree().getData())) {
        int tempData = newNode.getParentTree().getData(); // 부모노드 데이터 저장
        newNode.getParentTree().setData(newNode.getData());
        newNode.setData(tempData);
        newNode = newNode.getParentTree();
      }
      // 새로 삽입된 노드가 부모노드보다 우선 순위가 낮다면 더이상 위치를 변경하지 않음
      else {
        break;
      }
    }

  }

  boolean isBigPriority(int first, int second) {
    // 최소힙에서 작은값이 우선순위가 높음
    return (first < second);
  }

  // 새로 삽입될 위치의 부모노드를 찾는 함수
  private BinaryTree getInsertingParent() {
    // 1. 마지막에 삽입된 노드가 루트노드인 경우
    if (this.lastInsertedNode.getParentTree() == null) {
      // 루트노드를 리턴
      return this.lastInsertedNode;
    } else {
      // 2. 마지막에 삽입된 노드가 부모노드의 왼쪽 자식인 경우
      if (this.lastInsertedNode == this.lastInsertedNode.getParentTree().getLeftSubTree()) {
        // 마지막에 삽입된 노드의 부모노드를 리턴
        return this.lastInsertedNode.getParentTree();
      }
      // 3. 마지막에 삽입된 노드가 부모노드의 오른쪽 자식인 경우
      else {
        BinaryTree current = this.lastInsertedNode;
        BinaryTree firstRightSibling = null;

        // 마지막에 삽입된 노드의 부모노드중에서 오른쪽 형제노드가 있는지 탐색
        // 최대 루트노드의 자식 노드까지 반복 (부모노드의 부모노드가 null이 아닐때까지)
        while (current.getParentTree().getParentTree() != null) {
          current = current.getParentTree();
          firstRightSibling = getRightSibling(current);

          // 만약 current의 오른쪽 형제노드가 존재한다면,
          if (firstRightSibling != null) {
            break;
          }
        }

        // 3-1. 마지막에 삽입된 노드의 부모노드 중에서 오른쪽 형제노드를 가지는 노드가 존재하는 경우
        if (firstRightSibling != null) {
          // 오른쪽 형제노드의 가장 아래 왼쪽자식이 새로 삽입할 노드의 부모노드가 됨
          while (firstRightSibling.getLeftSubTree() != null) {
            firstRightSibling = firstRightSibling.getLeftSubTree();
          }
          return firstRightSibling;
        }
        // 3-2. 마지막에 삽입된 노드의 부모노드 중에서 오른쪽 형제노드를 가지는 노드가 없는 경우
        else {
          // 루트노드의 가장 아래 왼쪽자식이 새로 삽입할 노드의 부모노드가 됨
          current = this.root;
          while (current.getLeftSubTree() != null) {
            current = current.getLeftSubTree();
          }
          return current;
        }
      }

    }

  }

  BinaryTree getRightSibling(BinaryTree node) {
    // 현재노드가 부모노드의 오른쪽 자식이 아니라면, 왼쪽 자식이라는 말
    if (node.getParentTree().getRightSubTree() != node) {
      return node.getRightSubTree().getRightSubTree();
    }
    // 현재노드가 부모노드의 오른쪽 자식이라면, null을 리턴
    return null;
  }

  BinaryTree getLeftSibling(BinaryTree node) {
    if (node.getParentTree().getLeftSubTree() != node) {
      return node.getParentTree().getLeftSubTree();
    }
    return null;
  }

  public BinaryTree remove() {
    BinaryTree deletedNode = null;
    // 1. 마지막에 삽입된 노드가 루트 노드인 경우
    if (this.lastInsertedNode == this.root) {
      deletedNode = this.root;
      this.root = null;
      lastInsertedNode = null;
      return deletedNode;
    }

    // 2. 데이터가 2개 이상인경우
    // 마지막에 삽입된 노드의 이전에 삽입된 노드를 조회
    BinaryTree prevLastInsertedNode = this.getNewLastInsertedNode();

    // 마지막에 삽입된 노드의 값을 루트노드의 값과 스왑
    int tempData = this.root.getData();
    this.root.setData(lastInsertedNode.getData());
    this.lastInsertedNode.setData(tempData);

    // 마지막에 삽입된 노드를 부모노드와 연결끊기 (루트노드였던 노드)
    if (this.lastInsertedNode.getParentTree().getLeftSubTree() == this.lastInsertedNode) {
      this.lastInsertedNode.getParentTree().setLeftSubTree(null);
    } else {
      this.lastInsertedNode.getParentTree().setRightSubTree(null);
    }
    this.lastInsertedNode.setParentTree(null);
    deletedNode = this.lastInsertedNode; // 제거된 노드를 리턴하기 위해 저장

    // 마지막에 삽입된 노드의 값을 이전에 삽입된 노드의 값으로 갱신
    this.lastInsertedNode = prevLastInsertedNode;

    // 스왑된 루트노드(마지막에 삽입된 노드였던 노드)가 자기 우선순위에 맞도록
    // 두 자식노드중 우선순위가 더 높은 노드와 비교해서 현재노드의 우선순위가 더 낮다면 위치를 바꿈
    BinaryTree current = this.root;
    do {
      // 두 자식노드 중 더 높은 우선순위의 자식노드를 구함
      BinaryTree higherChild = getHigherPriorityChild(current.getLeftSubTree(), current.getRightSubTree());
      // 자식노드가 없다면 do-while 종료
      if (higherChild == null) {break;}
      // 우선순위가 더 높은 자식과 현재노드를 비교해서 자식노드가 우선순위가 더 높다면 자리를 바꿈
      else if (this.isBigPriority(current.getData(), higherChild.getData()) == false) {
        int tempData2 = current.getData();
        current.setData(higherChild.getData());
        higherChild.setData(tempData2);
        current = higherChild; // 현재노드를 아래로 이동
      }
      // 현재노드의 우선순위가 더 높다면 do-while 종료
      else {break;}

      // 자식노드가 없을때 까지 반복
    } while (current.getLeftSubTree() != null || current.getRightSubTree() != null);

    return deletedNode;
  }

  private BinaryTree getNewLastInsertedNode() {
    BinaryTree prevLastInsertedNode = null; // 마지막으로 삽입된 노드가 루트노드인 경우는 처리됨

    // 1. 마지막에 삽입된 노드가 부모노드의 왼쪽 자식노드인 경우
    if (this.lastInsertedNode == this.lastInsertedNode.getParentTree().getLeftSubTree()) {
      // 마지막 삽입위치부터 순회하므로 current를 lastInsertedNode로 초기화
      BinaryTree current = this.lastInsertedNode;
      BinaryTree firstLeftSibling = null;

      // 부모노드 중에서 왼쪽 형제노드가 있는지 없는지 확인 (있다면 firstLeftSibling는 왼쪽 형제노드를 가리킴)
      while (current.getParentTree().getParentTree() != null) {
        current = current.getParentTree();
        firstLeftSibling = this.getLeftSibling(current);
        if (firstLeftSibling != null) {break;}
      }

      // 1-1. 부모노드 중에 왼쪽 형제노드가 존재하는 경우
      // 마지막으로 삽입된 노드의 첫번째 왼쪽 형제노드에서 가장 오른쪽 끝에 있는 자식노드를 선택
      if (firstLeftSibling != null) {
        while (firstLeftSibling.getRightSubTree() != null) {
          firstLeftSibling = firstLeftSibling.getRightSubTree();
        }
        prevLastInsertedNode = firstLeftSibling; // 찾은노드를 이전에 삽입된 노드로 넣어줌
      }

      // 1-2. 부모노드 중에 왼쪽 형제노드가 존재하지 않는 경우
      // 루트노드에서 가장 오른쪽에 있는 자식노드를 선택
      else {
        current = this.root;
        while (current.getRightSubTree() != null) {
          current = current.getRightSubTree();
        }
        prevLastInsertedNode = current; // 찾은노드를 이전에 삽입된 노드로 넣어줌
      }
    }
    // 2. 마지막에 삽입된 노드가 부모노드의 오른쪽 자식노드인 경우
    // 마지막에 삽입된 노드의 부모노드의 왼쪽 자식노드를 선택
    else {
      prevLastInsertedNode = this.lastInsertedNode.getParentTree().getLeftSubTree();
    }

    return prevLastInsertedNode;
  }

  private BinaryTree getHigherPriorityChild(BinaryTree left, BinaryTree right) {
    // 왼쪽 노드가 없다면 오른쪽 노드를 리턴 (왼쪽노드가 없는데 오른쪽 노드가 있는 경우가 있으면 안됨)
    if (left == null) {
      return right;
    }
    // 오른쪽 노드가 없다면 왼쪽노드를 리턴
    else if (right == null) {
      return left;
    }
    // 양쪽 노드가 모두 있고, 왼쪽노드가 우선순위가 더 높다면 왼쪽 노드 리턴
    else if (this.isBigPriority(left.getData(), right.getData())) {
      return left;
    }
    // 양쪽 노드가 모두 있고, 오른쪽 노드가 우선순위가 더 높다면 오른쪽 노드 리턴
    else {
      return right;
    }
  }

  public static void main(String[] args) {
    Heap heap = new Heap();
    System.out.println("4, 2, 5, 7, 1 순서로 데이터 삽입");
    heap.insert(4);
    heap.insert(2);
    heap.insert(5);
    heap.insert(7);
    heap.insert(1);

    System.out.println("==== 중위순회 ====");
    heap.getRoot().inOrderTraversal(heap.getRoot()); // 7 -> 2 -> 4 -> 1 -> 5
    System.out.println("root = " + heap.getRoot());

    System.out.println("==== remove ====");
    System.out.println(heap.remove());

    System.out.println("==== 중위순회 ====");
    heap.getRoot().inOrderTraversal(heap.getRoot()); // 7 -> 4 -> 2 -> 5
    System.out.println("root = " + heap.getRoot());
  }

}
