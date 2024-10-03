package _덱;

import _연결리스트.DoublyLinkedList;
import _연결리스트.Node;

public class Deque {

  private final DoublyLinkedList doublyLinkedList;

  public Deque() {
    doublyLinkedList = new DoublyLinkedList();
  }

  // addFirst(data)
  public void addFirst(int data) {
    doublyLinkedList.insertAt(0, data);
  }

  // removeFirst()
  public Node removeFirst() {
    try {
      return doublyLinkedList.deleteAt(0);
    } catch (Exception e) {
      return null;
    }
  }

  // getFirst()
  public Node getFirst() {
    return doublyLinkedList.getFirst();
  }

  // addLast(data)
  public void addLast(int data) {
    doublyLinkedList.insertLast(data);
  }

  // removeLast()
  public Node removeLast() {
    try {
      return doublyLinkedList.deleteLast();
    } catch (Exception e) {
      return null;
    }
  }

  // getLast()
  public Node getLast() {
    return doublyLinkedList.getLast();
  }

  // isEmpty()
  public boolean isEmpty() {
    return doublyLinkedList.isEmpty();
  }

  // printAll()
  public void printAll() {
    doublyLinkedList.printAll();
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
