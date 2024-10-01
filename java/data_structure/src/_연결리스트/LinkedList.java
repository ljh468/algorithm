package _연결리스트;

public class LinkedList {

  private Node first;

  private int count;

  public LinkedList() {
    this.first = null;
    this.count = 0;
  }

  // 1. printAll()
  public void printAll() {
    Node currentNode = this.first;
    StringBuilder text = new StringBuilder("[");
    while (currentNode != null) {
      text.append(currentNode.getData());
      currentNode = currentNode.getNext();

      if (currentNode != null) {
        text.append(", ");
      }
    }
    text.append("]");
    System.out.println(text);
  }

  // 2. clear()
  public void clear() {
    this.first = null;
    this.count = 0;
  }

  // 3. insertAt(index, data)
  public void insertAt(int index, int data) {
    if (index > this.count || index < 0) {
      throw new IllegalArgumentException("추가할 범위를 넘어갔습니다.");
    }
    Node newNode = new Node(data);
    // 맨 앞에 데이터를 삽입하는 경우
    if (index == 0) {
      newNode.setNext(this.first);
      this.first = newNode;
    }
    // 중간이나 맨뒤에 데이터를 삽입하는 경우
    else {
      Node currentNode = this.first;
      // 맨 앞 노드부터 삽입하려는 인덱스 전까지 이동
      for (int i = 0; i < index - 1; i++) {
        currentNode = currentNode.getNext();
      }
      // 연결
      newNode.setNext(currentNode.getNext());
      currentNode.setNext(newNode);
    }
    this.count++;
  }

  // 4. insertLast(data)
  public void insertLast(int data) {
    // count는 맨마지막 인덱스와 같음
    insertAt(this.count, data);
  }

  // 5. deleteAt(index)
  public Node deleteAt(int index) {
    if (index >= this.count || index < 0) {
      throw new IllegalArgumentException("제거할 범위를 넘겼습니다.");
    }

    Node currentNode = this.first;
    Node deleteNode = null;
    // // 맨 앞에 데이터를 삭제하는 경우
    if (index == 0) {
      deleteNode = currentNode;
      this.first = currentNode.getNext();
    } else {
      for (int i = 0; i < index - 1; i++) {
        currentNode = currentNode.getNext();
      }
      deleteNode = currentNode.getNext();
      currentNode.setNext(deleteNode.getNext());
    }
    this.count--;
    return deleteNode;
  }

  // 6. deleteLast()
  public Node deleteLast() {
    return deleteAt(this.count - 1);
  }

  // 7. getNodeAt(index)
  public Node getNodeAt(int index) {
    if (index >= this.count || index < 0) {
      throw new IllegalArgumentException("읽을 수 없는 인덱스입니다.");
    }
    Node currentNode = this.first;
    for (int i = 0; i < index; i++) {
      currentNode = currentNode.getNext();
    }
    return currentNode;
  }

  public int getCount() {
    return count;
  }

  public static void main(String[] args) {
    LinkedList linkedList = new LinkedList();
    System.out.println("===== insertAt() 5번 호출 =====");
    linkedList.insertAt(0, 0);
    linkedList.insertAt(1, 1);
    linkedList.insertAt(2, 2);
    linkedList.insertAt(3, 3);
    linkedList.insertAt(4, 4);
    linkedList.printAll();

    System.out.println("===== clear() 호출 =====");
    linkedList.clear();
    linkedList.printAll();

    System.out.println("===== insertLast() 3번 호출 =====");
    linkedList.insertLast(0);
    linkedList.insertLast(1);
    linkedList.insertLast(2);
    linkedList.printAll();

    System.out.println("===== deleteAt()으로 앞에 2개 제거 =====");
    linkedList.deleteAt(0);
    linkedList.printAll();
    linkedList.deleteAt(1);
    linkedList.printAll();

    System.out.println("===== deleteLast() 2번 호출 =====");
    linkedList.insertLast(5);
    linkedList.printAll();

    linkedList.deleteLast();
    linkedList.deleteLast();
    linkedList.printAll();

    System.out.println("===== getNodeAt() index 2 호출 =====");
    linkedList.insertLast(1);
    linkedList.insertLast(2);
    linkedList.insertLast(3);
    linkedList.insertLast(4);
    linkedList.insertLast(5);
    linkedList.printAll();

    Node secondNode = linkedList.getNodeAt(2);
    System.out.println("Node{index:2}: " + secondNode.getData());
  }
}
