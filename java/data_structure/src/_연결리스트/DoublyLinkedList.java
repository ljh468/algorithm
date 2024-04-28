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

  public void setHead(Node head) {
    this.head = head;
  }

  public Node getTail() {
    return tail;
  }

  public void setTail(Node tail) {
    this.tail = tail;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  // printAll()
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

  // clear
  public void clear() {
    this.head = null;
    this.tail = null;
    this.count = 0;
  }

  // insertAt(index, data)
  public void insertAt(int index, int data) {
    if (index > this.count || index < 0) {
      throw new IllegalArgumentException("추가할 범위를 넘어섰습니다.");
    }
    Node newNode = new Node(data);

    // 1. head에 데이터를 넣을때
    if (index == 0) {
      newNode.setNext(this.head);
      if (this.head != null) {
        this.head.setPrev(newNode);
      }
      this.head = newNode;
    }

    // 2. tail에 데이터를 넣을때
    else if (index == this.count) {
      newNode.setPrev(this.tail);
      if (this.tail != null) {
        this.tail.setNext(newNode);
      }
    }

    // 3. 중간에 데이터를 넣을때
    else {
      Node currentNode = this.head;
      for (int i = 0; i < index - 1; i++) {
        currentNode = currentNode.getNext();
      }
      newNode.setPrev(currentNode);
      newNode.setNext(currentNode.getNext());
      currentNode.getNext().setPrev(newNode);
      currentNode.setNext(newNode);
    }
    if (newNode.getNext() == null) {
      this.tail = newNode;
    }
    this.count++;
  }

  // insertLast(data)
  public void insertLast(int data) {
    insertAt(this.count, data);
  }

  // deleteAt(index)
  public Node deleteAt(int index) {
    if (index >= this.count || index < 0) {
      throw new IllegalArgumentException("제거할 범위를 넘어섰습니다.");
    }
    // 1. head의 데이터를 제거할 때
    Node currentNode = this.head;
    Node deleteNode = null;
    if (index == 0) {
      deleteNode = currentNode;
      // 데이터가 1개 남은 경우
      if (this.head.getNext() == null) {
        this.head = null;
        this.tail = null;
      }
      // 데이터가 여러개 남은 경우
      else {
        this.head = this.head.getNext();
        this.head.setPrev(null);
      }
      this.count--;
      return deleteNode;
    }
    // 2. tail의 데이터를 제거할 때
    else if (index == this.count - 1) {
      deleteNode = this.tail;
      this.tail.getPrev().setNext(null);
      this.tail = this.tail.getPrev();
      this.count--;
      return deleteNode;
    }
    // 3. 중간의 데이터를 제거할 때
    else {
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

  // deleteLast()
  public Node deleteLast() {
    return deleteAt(this.count - 1);
  }

  // getNodeAt(index)
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

  // isEmpty()
  public boolean isEmpty() {
    return (this.count == 0) ;
  }

  public static void main(String[] args) {
    DoublyLinkedList linkedList = new DoublyLinkedList();
    System.out.println("===== insertAt() 5번 호출 =====");
    linkedList.insertAt(0, 0);
    linkedList.insertAt(1, 1);
    linkedList.insertAt(2, 2);
    linkedList.insertAt(3, 4);
    linkedList.insertAt(3, 3);
    linkedList.insertAt(5, 5);
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
