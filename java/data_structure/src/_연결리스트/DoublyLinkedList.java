package _연결리스트;

public class DoublyLinkedList {

  private Node first;

  private Node last;

  private int count;

  public DoublyLinkedList() {
    this.first = null;
    this.last = null;
    this.count = 0;
  }

  public Node getFirst() {
    return first;
  }

  public void setFirst(Node first) {
    this.first = first;
  }

  public Node getLast() {
    return last;
  }

  public void setLast(Node last) {
    this.last = last;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  // printAll()
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

  // clear()
  public void clear() {
    this.first = null;
    this.last = null;
    this.count = 0;
  }

  // insertAt(index, data)
  public void insertAt(int index, int data) {
    if (index > this.count || index < 0) {
      throw new IllegalArgumentException("추가할 범위를 넘어섰습니다.");
    }
    Node newNode = new Node(data);

    // 1. first(맨 앞)에 데이터를 넣는 경우
    if (index == 0) {
      newNode.setNext(this.first);
      if (this.first != null) {
        this.first.setPrev(newNode);
      }
      this.first = newNode;
    }

    // 2. last(맨 뒤)에 데이터를 넣는 경우
    else if (index == this.count) {
      newNode.setNext(null);
      newNode.setPrev(this.last);
      if (this.last != null) {
        this.last.setNext(newNode);
      }
    }

    // 3. 중간에 데이터를 넣을때
    else {
      Node currentNode = this.first;
      // 넣을 인덱스 바로 전까지 이동
      for (int i = 0; i < index - 1; i++) {
        currentNode = currentNode.getNext();
      }
      // 노드 연결
      newNode.setNext(currentNode.getNext());
      newNode.setPrev(currentNode);
      currentNode.setNext(newNode);
      newNode.getNext().setPrev(newNode);
    }

    // 새로 삽입한 노드가 마지막 노드라면 last를 새로 삽입한 노드로 설정
    if (newNode.getNext() == null) {
      this.last = newNode;
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
    // 1. first(맨 앞)의 데이터를 제거할 때
    Node currentNode = this.first;
    Node deleteNode = null;
    if (index == 0) {
      deleteNode = currentNode;
      // 데이터가 1개 남아있는 경우
      if (this.first.getNext() == null) {
        this.first = null;
        this.last = null;
      }
      // 데이터가 2개 이상 남아있는 경우
      else {
        this.first = this.first.getNext();
        this.first.setPrev(null);
      }
      this.count--;
      return deleteNode;
    }
    // 2. last(맨 뒤)의 데이터를 제거할 때
    else if (index == this.count - 1) {
      deleteNode = this.last;
      this.last.getPrev().setNext(null);
      this.last = this.last.getPrev();
      this.count--;
      return deleteNode;
    }
    // 3. 중간에 있는 데이터를 제거할 때
    else {
      // 제거할 인덱스 바로 전 노드까지 이동
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
    Node currentNode = this.first;
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
