package _스택;

import _연결리스트.LinkedList;
import _연결리스트.Node;

public class Stack_LinkedList {

  private final LinkedList linkedList;

  public Stack_LinkedList() {
    linkedList = new LinkedList();
  }

  public void push(int data) {
    linkedList.insertAt(0, data);
  }

  public Node pop() {
    try {
      return linkedList.deleteAt(0);
    } catch (Exception exception) {
      return null;
    }
  }

  public Node peek() {
    try {
      return linkedList.getNodeAt(0);
    } catch (Exception exception) {
      return null;
    }
  }

  public boolean isEmpty() {
    return linkedList.getCount() == 0;
  }

  public static void main(String[] args) {
    Stack_LinkedList stack = new Stack_LinkedList();
    System.out.println("===== 1, 2, 3, 4를 순서대로 스택에 push =====");
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);

    System.out.println("===== 스택에서 4번 pop() =====");
    System.out.println("stack.pop().getData() = " + stack.pop().getData());
    System.out.println("stack.pop().getData() = " + stack.pop().getData());
    System.out.println("stack.pop().getData() = " + stack.pop().getData());
    System.out.println("stack.pop().getData() = " + stack.pop().getData());

    System.out.println("===== 다시 1부터 4까지 스택에 push =====");
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);

    System.out.println("stack.peek() = " + stack.peek().getData());
    System.out.println("stack.pop() = " + stack.pop().getData());
    System.out.println("stack.peek() = " + stack.peek().getData());
    System.out.println("stack.isEmpty() = " + stack.isEmpty());
    System.out.println("stack.pop() = " + stack.pop().getData());
    System.out.println("stack.pop() = " + stack.pop().getData());
    System.out.println("stack.pop() = " + stack.pop().getData());
    System.out.println("stack.isEmpty() = " + stack.isEmpty());
    System.out.println("stack.pop() = " + stack.pop());
  }
}
