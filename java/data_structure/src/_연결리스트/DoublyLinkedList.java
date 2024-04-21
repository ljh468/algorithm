package _연결리스트;

public class DoublyLinkedList {

  private Node head;

  private Node tail;

  private int count;

  public DoublyLinkedList() {
    this.head = null;
    this.tail = null;
    this.count = 0;
  }

  public Node getHead() {
    return head;
  }

  public Node getTail() {
    return tail;
  }

  // 1. printAll()
  public void printAll() {
    Node currentNode = this.head;
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
    this.head = null;
    this.count = 0;
  }

  // 3. insertAt(index, data)
  public void insertAt(int index, int data) {
    if (index > this.count || index < 0) {
      throw new IllegalArgumentException("추가할 범위를 넘어갔습니다.");
    }
    Node newNode = new Node(data);
    // head에 데이터 삽입
    if (index == 0) {
      newNode.setNext(this.head);
      if (this.head != null) {
        this.head.setPrev(newNode);
      }
      this.head = newNode;
    }
    // tail에 데이터 삽입
    else if (index == this.count) {
      newNode.setNext(null);
      newNode.setPrev(this.tail);
      this.tail.setNext(newNode);
    }

    // 중간에 데이터 삽입
    else {
      Node currentNode = this.head;
      // 1. 넣을 인덱스의 바로 전 노드까지 이동
      for (int i = 0; i < index - 1; i++) {
        currentNode = currentNode.getNext();
      }
      // 2. 새로운 노드 다음 노드에 현재 노드의 다음 노드를 연결
      newNode.setNext(currentNode.getNext());
      // 3. 새로운 노드 이전 노드에 현재 노드를 연결
      newNode.setPrev(currentNode);
      // 4. 현재 노드의 다음 노드에 새로운 노드를 연결
      currentNode.setNext(newNode);
      // 5. 새로운 노드 다음 노드의 이전 노드에 새로운 노드를 연결
      newNode.getNext().setPrev(newNode);
    }
    if (newNode.getNext() == null) {
      this.tail = newNode;
    }
    this.count++;
  }

  // 4. insertLast(data)
  public void insertLast(int data) {
    insertAt(this.count, data);
  }

  // 5. deleteAt(index)
  public Node deleteAt(int index) {
    if (index >= this.count || index < 0) {
      throw new IllegalArgumentException("제거할 범위를 넘겼습니다.");
    }

    Node currentNode = this.head;
    Node deleteNode = null;
    // head에 있는 데이터 제거
    if (index == 0) {
      deleteNode = currentNode;
      // 데이터가 1개 남은경우
      if (this.head.getNext() == null) {
        this.head = null;
        this.tail = null;
      }
      // 데이터가 여러개 남은경우
      else {
        this.head = this.head.getNext();
        this.head.setPrev(null);
      }
      this.count--;
      this.head = currentNode.getNext();
      return deleteNode;
    }

    // tail에 있는 데이터 제거
    else if (index == this.count - 1) {
      deleteNode = this.tail;
      // 1. tail의 이전 노드의 다음노드에 null을 연결
      this.tail.getPrev().setNext(null);
      // 2. tail의 이전 노드를 tail로 변경
      this.tail = this.tail.getPrev();
      this.count--;
      return deleteNode;
    }

    // 중간의 데이터 제거
    else {
      // 1. 제거할 노드 인덱스의 바로 전 노드까지 이동
      for (int i = 0; i < index - 1; i++) {
        currentNode = currentNode.getNext();
      }
      deleteNode = currentNode.getNext();
      currentNode.setNext(currentNode.getNext().getNext());
      currentNode.getNext().setPrev(currentNode);
      this.count--;
      return deleteNode;
    }

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
    Node currentNode = this.head;
    for (int i = 0; i < index; i++) {
      currentNode = currentNode.getNext();
    }
    return currentNode;
  }

  public int getCount() {
    return count;
  }

  public static void main(String[] args) {
    DoublyLinkedList linkedList = new DoublyLinkedList();
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
