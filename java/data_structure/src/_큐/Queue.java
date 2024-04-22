package _큐;

import _연결리스트.Node;

public class Queue {

  private Node head;

  private Node tail;

  private int count;

  public void enqueue(int data) {
    Node newNode = new Node(data);
    if (this.head == null) {
      this.head = newNode;
      this.tail = newNode;
    } else {
      newNode.setNext(this.head);
      this.head.setPrev(newNode);
      this.head = newNode;
    }
    this.count++;
  }

  public Node dequeue() {
    if (this.tail == null) {
      return null;
    }
    Node temp = this.tail;
    this.tail = this.tail.getPrev();
    if (this.tail == null) {
      this.head = null;
    } else {
      this.tail.setNext(null);
    }
    this.count--;
    return temp;
  }

  public Node front() {
    return this.tail;
  }

  public boolean isEmpty() {
    return (this.count == 0);
  }

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

  public Queue() {
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

  public int getCount() {
    return count;
  }

  public static void main(String[] args) {
    Queue queue = new Queue();
    System.out.println("===== enqueue() 3번 호출 =====" );
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    queue.printAll();
    System.out.println("queue.front() = " + queue.front());

    System.out.println("===== dequeue() 1번 호출 =====" );
    System.out.println("queue.dequeue() = " + queue.dequeue());
    queue.printAll();
    System.out.println("queue.isEmpty() = " + queue.isEmpty());

    System.out.println("===== dequeue() 2번 호출 =====" );
    System.out.println("queue.dequeue() = " + queue.dequeue());
    System.out.println("queue.dequeue() = " + queue.dequeue());
    queue.printAll();
    System.out.println("queue.isEmpty() = " + queue.isEmpty());
  }
}
