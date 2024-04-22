package _덱;

import _연결리스트.DoublyLinkedList;
import _연결리스트.Node;

public class Deque {

  private final DoublyLinkedList doublyLinkedList;

  public Deque() {
    this.doublyLinkedList = new DoublyLinkedList();
  }

  public void printAll() {
    doublyLinkedList.printAll();
  }

  public void addFirst(int data) {
    doublyLinkedList.insertAt(0, data);
  }

  public Node removeFirst() {
    return doublyLinkedList.deleteAt(0);
  }

  public void addLast(int data) {
    doublyLinkedList.insertLast(data);
  }

  public Node removeLast() {
    return doublyLinkedList.deleteLast();
  }

  public boolean isEmpty() {
    return doublyLinkedList.getCount() == 0;
  }

  public static void main(String[] args) {
    Deque deque = new Deque();
    System.out.println("===== 1, 2, 3, 4, 5까지 addFirst() 5번 호출 =====");
    System.out.println("deque.isEmpty() = " + deque.isEmpty());
    deque.addFirst(1);
    deque.addFirst(2);
    deque.addFirst(3);
    deque.addFirst(4);
    deque.addFirst(5);
    deque.printAll();
    System.out.println("deque.isEmpty() = " + deque.isEmpty());
    System.out.println();

    System.out.println("===== removeFirst() 5번 호출 =====");
    System.out.println("deque.removeFirst() = " + deque.removeFirst());
    deque.printAll();
    System.out.println("deque.removeFirst() = " + deque.removeFirst());
    deque.printAll();
    System.out.println("deque.removeFirst() = " + deque.removeFirst());
    deque.printAll();
    System.out.println("deque.removeFirst() = " + deque.removeFirst());
    deque.printAll();
    System.out.println("deque.removeFirst() = " + deque.removeFirst());
    deque.printAll();
    System.out.println("deque.isEmpty() = " + deque.isEmpty());
    System.out.println();

    System.out.println("===== 1, 2, 3, 4, 5까지 addLast() 5번 호출 =====");
    deque.addLast(1);
    deque.addLast(2);
    deque.addLast(3);
    deque.addLast(4);
    deque.addLast(5);
    deque.printAll();
    System.out.println("deque.isEmpty() = " + deque.isEmpty());
    System.out.println();

    System.out.println("===== removeLast() 5번 호출 =====");
    System.out.println("deque.removeLast() = " + deque.removeLast());
    deque.printAll();
    System.out.println("deque.removeLast() = " + deque.removeLast());
    deque.printAll();
    System.out.println("deque.removeLast() = " + deque.removeLast());
    deque.printAll();
    System.out.println("deque.removeLast() = " + deque.removeLast());
    deque.printAll();
    System.out.println("deque.removeLast() = " + deque.removeLast());
    deque.printAll();
    System.out.println("deque.isEmpty() = " + deque.isEmpty());
    System.out.println();
  }
}
