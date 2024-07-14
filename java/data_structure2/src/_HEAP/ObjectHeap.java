package _HEAP;

public class ObjectHeap<T extends Comparable<T>> {

  private ObjectBinaryTree<T> root;

  private ObjectBinaryTree<T> lastInsertedNode;

  public ObjectHeap() {
    this.root = null;
    this.lastInsertedNode = null;
  }

  public ObjectBinaryTree<T> getRoot() {
    return root;
  }

  public void setRoot(ObjectBinaryTree<T> root) {
    this.root = root;
  }

  public ObjectBinaryTree<T> getLastInsertedNode() {
    return lastInsertedNode;
  }

  public void setLastInsertedNode(ObjectBinaryTree<T> lastInsertedNode) {
    this.lastInsertedNode = lastInsertedNode;
  }

  public void insert(T data) {
    if (this.lastInsertedNode == null) {
      this.lastInsertedNode = new ObjectBinaryTree<>(data);
      this.root = this.lastInsertedNode;
      return;
    }

    ObjectBinaryTree<T> insertingParent = getInsertingParent();
    ObjectBinaryTree<T> newNode = new ObjectBinaryTree<>(data);
    if (insertingParent.getLeftSubTree() == null) {
      insertingParent.setLeftSubTree(newNode);
    } else if (insertingParent.getRightSubTree() == null) {
      insertingParent.setRightSubTree(newNode);
    }
    newNode.setParentTree(insertingParent);
    this.lastInsertedNode = newNode;

    while (newNode.getParentTree() != null) {
      if (this.isBigPriority(newNode.getData(), newNode.getParentTree().getData())) {
        T tempData = newNode.getParentTree().getData();
        newNode.getParentTree().setData(newNode.getData());
        newNode.setData(tempData);
        newNode = newNode.getParentTree();
      } else {
        break;
      }
    }
  }

  public boolean isBigPriority(T first, T second) {
    return first.compareTo(second) < 0;
  }

  private ObjectBinaryTree<T> getInsertingParent() {
    if (this.lastInsertedNode.getParentTree() == null) {
      return this.lastInsertedNode;
    } else {
      if (this.lastInsertedNode == this.lastInsertedNode.getParentTree().getLeftSubTree()) {
        return this.lastInsertedNode.getParentTree();
      } else {
        ObjectBinaryTree<T> current = this.lastInsertedNode;
        ObjectBinaryTree<T> firstRightSibling = null;

        while (current.getParentTree().getParentTree() != null) {
          current = current.getParentTree();
          firstRightSibling = getRightSibling(current);
          if (firstRightSibling != null) {
            break;
          }
        }

        if (firstRightSibling != null) {
          while (firstRightSibling.getLeftSubTree() != null) {
            firstRightSibling = firstRightSibling.getLeftSubTree();
          }
          return firstRightSibling;
        } else {
          current = this.root;
          while (current.getLeftSubTree() != null) {
            current = current.getLeftSubTree();
          }
          return current;
        }
      }
    }
  }

  ObjectBinaryTree<T> getRightSibling(ObjectBinaryTree<T> node) {
    if (node.getParentTree().getRightSubTree() != node) {
      return node.getParentTree().getRightSubTree();
    }
    return null;
  }

  ObjectBinaryTree<T> getLeftSibling(ObjectBinaryTree<T> node) {
    if (node.getParentTree().getLeftSubTree() != node) {
      return node.getParentTree().getLeftSubTree();
    }
    return null;
  }

  public ObjectBinaryTree<T> remove() {
    ObjectBinaryTree<T> deletedNode = null;
    if (this.lastInsertedNode == this.root) {
      deletedNode = this.root;
      this.root = null;
      lastInsertedNode = null;
      return deletedNode;
    }

    ObjectBinaryTree<T> prevLastInsertedNode = this.getNewLastInsertedNode();
    T tempData = this.root.getData();
    this.root.setData(lastInsertedNode.getData());
    this.lastInsertedNode.setData(tempData);

    if (this.lastInsertedNode.getParentTree().getLeftSubTree() == this.lastInsertedNode) {
      this.lastInsertedNode.getParentTree().setLeftSubTree(null);
    } else {
      this.lastInsertedNode.getParentTree().setRightSubTree(null);
    }
    this.lastInsertedNode.setParentTree(null);
    deletedNode = this.lastInsertedNode;

    this.lastInsertedNode = prevLastInsertedNode;
    ObjectBinaryTree<T> current = this.root;
    do {
      ObjectBinaryTree<T> higherChild = getHigherPriorityChild(current.getLeftSubTree(), current.getRightSubTree());
      if (higherChild == null) break;
      else if (!this.isBigPriority(current.getData(), higherChild.getData())) {
        T tempData2 = current.getData();
        current.setData(higherChild.getData());
        higherChild.setData(tempData2);
        current = higherChild;
      } else break;
    } while (current.getLeftSubTree() != null || current.getRightSubTree() != null);

    return deletedNode;
  }

  private ObjectBinaryTree<T> getNewLastInsertedNode() {
    ObjectBinaryTree<T> prevLastInsertedNode = null;
    if (this.lastInsertedNode == this.lastInsertedNode.getParentTree().getLeftSubTree()) {
      ObjectBinaryTree<T> current = this.lastInsertedNode;
      ObjectBinaryTree<T> firstLeftSibling = null;

      while (current.getParentTree().getParentTree() != null) {
        current = current.getParentTree();
        firstLeftSibling = this.getLeftSibling(current);
        if (firstLeftSibling != null) break;
      }

      if (firstLeftSibling != null) {
        while (firstLeftSibling.getRightSubTree() != null) {
          firstLeftSibling = firstLeftSibling.getRightSubTree();
        }
        prevLastInsertedNode = firstLeftSibling;
      } else {
        current = this.root;
        while (current.getRightSubTree() != null) {
          current = current.getRightSubTree();
        }
        prevLastInsertedNode = current;
      }
    } else {
      prevLastInsertedNode = this.lastInsertedNode.getParentTree().getLeftSubTree();
    }

    return prevLastInsertedNode;
  }

  private ObjectBinaryTree<T> getHigherPriorityChild(ObjectBinaryTree<T> left, ObjectBinaryTree<T> right) {
    if (left == null) {
      return right;
    } else if (right == null) {
      return left;
    } else if (this.isBigPriority(left.getData(), right.getData())) {
      return left;
    } else {
      return right;
    }
  }

  public static void main(String[] args) {
    ObjectHeap<Person> objectHeap = new ObjectHeap<>();
    objectHeap.insert(new Person("임꺽정", 20));
    objectHeap.insert(new Person("홍길동", 10));
    objectHeap.insert(new Person("이순신", 31));

    System.out.println("==== 중위순회 ====");
    objectHeap.getRoot().inOrderTraversal(objectHeap.getRoot());
    System.out.println("root = " + objectHeap.getRoot());
  }

}


