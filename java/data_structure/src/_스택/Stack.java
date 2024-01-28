package _스택;

import _연결리스트.LinkedList;
import _연결리스트.Node;

public class Stack {

  LinkedList list;

  //  private int size;
  //
  //  private Node head;
  //
  //  public Stack() {
  //    this.size = 0;
  //    this.head = null;
  //  }
  //
  //  public void push(int data) {
  //    Node node = new Node(data);
  //    if (this.head != null) {
  //      node.setNext(head);
  //    }
  //    this.head = node;
  //    size++;
  //  }
  //
  //  public Node pop() {
  //    if (head != null) {
  //      Node popNode = head;
  //      size--;
  //      this.head = head.getNext();
  //      return popNode;
  //    }
  //    return null;
  //  }
  //
  //  public Node peek() {
  //    return this.head;
  //  }
  //
  //  public boolean isEmpty() {
  //    return size == 0;
  //  }

  public Stack() {
    this.list = new LinkedList();
  }

  // push()
  public void push(int data) {
    list.insertAt(0, data);
  }

  // pop()
  public Node pop() {
    try {
      return list.deleteAt(0);
    } catch (IllegalArgumentException illegalArgumentException) {
      return null;
    }
  }

  // peek()
  public Node peek() {
    return this.list.getNodeAt(0);
  }

  // isEmpty()
  public boolean isEmpty() {
    try {
      return list.getNodeAt(0) == null;
    } catch (IllegalArgumentException illegalArgumentException) {
      return true;
    }
  }

  public static void main(String[] args) {
    Stack stack = new Stack();
    System.out.println("===== 첫번째 출력 =====");
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    System.out.println("stack.pop() = " + stack.pop().getData());
    System.out.println("stack.pop() = " + stack.pop().getData());
    System.out.println("stack.pop() = " + stack.pop().getData());
    System.out.println("stack.pop() = " + stack.pop().getData());

    System.out.println("===== 두번째 출력 =====");
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    System.out.println("stack.peek() = " + stack.peek());
    System.out.println("stack.pop() = " + stack.pop().getData());
    System.out.println("stack.peek() = " + stack.peek());
    System.out.println("stack.isEmpty() = " + stack.isEmpty());
    System.out.println("stack.pop() = " + stack.pop().getData());
    System.out.println("stack.pop() = " + stack.pop().getData());
    System.out.println("stack.pop() = " + stack.pop().getData());
    System.out.println("stack.isEmpty() = " + stack.isEmpty());
    System.out.println("stack.pop() = " + stack.pop());

  }
}
