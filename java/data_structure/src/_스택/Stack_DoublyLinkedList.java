package _스택;

import _연결리스트.DoublyLinkedList;
import _연결리스트.Node;

public class Stack_DoublyLinkedList {

  private final DoublyLinkedList doublyLinkedList;

  public Stack_DoublyLinkedList() {
    this.doublyLinkedList = new DoublyLinkedList();
  }

  // push(data) - 데이터 삽입
  public void push(int data) {
    doublyLinkedList.insertAt(0, data);
  }

  // pop() - 데이터 제거
  public Node pop() {
    try {
      return doublyLinkedList.deleteAt(0);
    } catch (Exception exception) {
      return null;
    }
  }

  // peek() - 데이터 참조
  public Node peek() {
    try {
      return doublyLinkedList.getNodeAt(0);
    } catch (Exception exception) {
      return null;
    }
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
    Stack_DoublyLinkedList stackDoublyLinkedList = new Stack_DoublyLinkedList();
    System.out.println("===== 1, 2, 3, 4를 순서대로 스택에 push =====");
    stackDoublyLinkedList.push(1);
    stackDoublyLinkedList.push(2);
    stackDoublyLinkedList.push(3);
    stackDoublyLinkedList.push(4);
    stackDoublyLinkedList.printAll();

    System.out.println("===== 스택에서 4번 pop() =====");
    System.out.println("stack.pop().getData() = " + stackDoublyLinkedList.pop().getData());
    System.out.println("stack.pop().getData() = " + stackDoublyLinkedList.pop().getData());
    System.out.println("stack.pop().getData() = " + stackDoublyLinkedList.pop().getData());
    System.out.println("stack.pop().getData() = " + stackDoublyLinkedList.pop().getData());
    stackDoublyLinkedList.printAll();

    System.out.println("===== 다시 1부터 4까지 스택에 push =====");
    stackDoublyLinkedList.push(1);
    stackDoublyLinkedList.push(2);
    stackDoublyLinkedList.push(3);
    stackDoublyLinkedList.push(4);
    stackDoublyLinkedList.printAll();

    System.out.println("stack.peek() = " + stackDoublyLinkedList.peek().getData());
    System.out.println("stack.pop() = " + stackDoublyLinkedList.pop().getData());
    System.out.println("stack.peek() = " + stackDoublyLinkedList.peek().getData());
    System.out.println("stack.isEmpty() = " + stackDoublyLinkedList.isEmpty());
    System.out.println("stack.pop() = " + stackDoublyLinkedList.pop().getData());
    System.out.println("stack.pop() = " + stackDoublyLinkedList.pop().getData());
    System.out.println("stack.pop() = " + stackDoublyLinkedList.pop().getData());
    System.out.println("stack.isEmpty() = " + stackDoublyLinkedList.isEmpty());
    System.out.println("stack.pop() = " + stackDoublyLinkedList.pop());
  }
}
