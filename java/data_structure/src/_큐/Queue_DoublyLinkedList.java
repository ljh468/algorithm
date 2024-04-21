package _큐;

import _연결리스트.DoublyLinkedList;
import _연결리스트.Node;

public class Queue_DoublyLinkedList {

  private DoublyLinkedList doublyLinkedList;

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
    } catch (Exception exception) {
      return null;
    }
  }

  // front() - 데이터 참조
  public Node front() {
    return doublyLinkedList.getTail();
  }

  // isEmpty() - 비었는지 확인
  public boolean isEmpty() {
    return doublyLinkedList.getCount() == 0;
  }

  public static void main(String[] args) {
    Queue_DoublyLinkedList queue = new Queue_DoublyLinkedList();
    System.out.println("===== enqueue() 3번 호출 =====" );
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    queue.doublyLinkedList.printAll();
    System.out.println("queue.front() = " + queue.front());

    System.out.println("===== dequeue() 1번 호출 =====" );
    System.out.println("queue.dequeue() = " + queue.dequeue());
    queue.doublyLinkedList.printAll();
    System.out.println("queue.isEmpty() = " + queue.isEmpty());

    System.out.println("===== dequeue() 2번 호출 =====" );
    System.out.println("queue.dequeue() = " + queue.dequeue());
    System.out.println("queue.dequeue() = " + queue.dequeue());
    queue.doublyLinkedList.printAll();
    System.out.println("queue.isEmpty() = " + queue.isEmpty());
  }
}
