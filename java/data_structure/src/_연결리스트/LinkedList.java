package _연결리스트;

public class LinkedList {

  // 연결리스트의 시작 노드
  private Node head;

  // 총 저장된 노드의 수
  private int count;

  public LinkedList() {
    this.head = null;
    this.count = 0;
  }

  // 1. 모든 데이터 출력 printAll();
  public void printAll() {
    Node currentNode = this.head;
    String text = "[";
    while (currentNode != null) {
      text += currentNode.getData();
      currentNode = currentNode.getNext();

      if (currentNode != null) {
        text += ", ";
      }
    }
    text += "]";
    System.out.println("linkedList: " + text);
  }

  // 2. 모든 데이터 제거 clear();
  public void clear() {
    this.head = null;
    this.count = 0;
  }

  // 3. 인덱스 삽입 insertAt(index, data);
  public void insertAt(int index, int data) {
    if (index > this.count || index < 0) {
      throw new IllegalArgumentException("추가할 범위를 넘어갔습니다.");
    }
    Node newNode = new Node(data);
    if (index == 0) {
      newNode.setNext(head);
      this.head = newNode;
    } else {
      Node currentNode = this.head;
      // 넣으려는 인덱스의 바로 전까지 이동
      for (int i = 0; i < index - 1; i++) {
        currentNode = currentNode.getNext();
      }
      newNode.setNext(currentNode.getNext());
      currentNode.setNext(newNode);
    }
    count++;
  }

  // 4. 마지막 삽입 insertLast(data);
  public void insertLast(int data) {
    insertAt(this.count, data);
  }

  // 5. 인덱스 삭제 deleteAt(index);
  public Node deleteAt(int index) {
    if (index >= this.count || index < 0) {
      throw new IllegalArgumentException("제거할 범위를 넘었습니다.");
    }

    Node currentNode = this.head;
    Node deleteNode = null;
    if (index == 0) {
      deleteNode = currentNode;
      this.head = currentNode.getNext();
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

  // 6. 마지막 삭제 deleteLast();
  public Node deleteLast() {
    return deleteAt(this.count - 1);
  }

  // 7. 인덱스 읽기 getNodeAt(index);
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

    System.out.println("===== deleteAt() 호출 =====");
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

    System.out.println("===== getNodeAt() 호출 =====");
    linkedList.insertLast(1);
    linkedList.insertLast(2);
    linkedList.insertLast(3);
    linkedList.insertLast(4);
    linkedList.insertLast(5);
    linkedList.printAll();

    Node secondNode = linkedList.getNodeAt(2);
    System.out.println("secondNode = " + secondNode);
  }
}

