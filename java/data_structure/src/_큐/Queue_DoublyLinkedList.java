package _큐;

import _연결리스트.DoublyLinkedList;
import _연결리스트.Node;

public class Queue_DoublyLinkedList {

  private final DoublyLinkedList doublyLinkedList;

  public Queue_DoublyLinkedList() {
    doublyLinkedList = new DoublyLinkedList();
  }

  // enqueue(data) - 데이터 삽입
  public void enqueue(int data) {
    doublyLinkedList.insertAt(0, data);
  }

  // dequeue() - 데이터 제거
  public Node dequeue() {
    try {
      return doublyLinkedList.deleteLast();
    } catch (Exception e) {
      return null;
    }
  }

  // front() - 데이터 참조
  public Node front() {
    return doublyLinkedList.getLast();
  }

  // isEmpty() - 비었는지 확인
  public boolean isEmpty() {
    return doublyLinkedList.isEmpty();
  }

  // printAll() - 데이터 출력
  public void printAll() {
    doublyLinkedList.printAll();
  }

  public static void main(String[] args) {
    Queue_DoublyLinkedList queueDoublyLinkedList = new Queue_DoublyLinkedList();
    System.out.println("===== enqueue() 3번 호출 =====");
    queueDoublyLinkedList.enqueue(1);
    queueDoublyLinkedList.enqueue(2);
    queueDoublyLinkedList.enqueue(3);
    queueDoublyLinkedList.printAll();
    System.out.println("queue.front() = " + queueDoublyLinkedList.front());

    System.out.println("===== dequeue() 1번 호출 =====");
    System.out.println("queue.dequeue() = " + queueDoublyLinkedList.dequeue());
    queueDoublyLinkedList.printAll();
    System.out.println("queue.isEmpty() = " + queueDoublyLinkedList.isEmpty());

    System.out.println("===== dequeue() 2번 호출 =====");
    System.out.println("queue.dequeue() = " + queueDoublyLinkedList.dequeue());
    System.out.println("queue.dequeue() = " + queueDoublyLinkedList.dequeue());
    queueDoublyLinkedList.printAll();
    System.out.println("queue.isEmpty() = " + queueDoublyLinkedList.isEmpty());
  }
}
