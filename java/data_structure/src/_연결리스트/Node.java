package _연결리스트;

public class Node {

  private int data;

  private Node next;

  private Node prev;

  public Node(int data) {
    this.data = data;
    this.next = null;
    this.prev = null;
  }

  public int getData() {
    return data;
  }

  public void setData(int data) {
    this.data = data;
  }

  public Node getNext() {
    return next;
  }

  public void setNext(Node next) {
    this.next = next;
  }

  public Node getPrev() {
    return prev;
  }

  public void setPrev(Node prev) {
    this.prev = prev;
  }

  @Override
  public String toString() {
    return "Node{" +
        "data=" + data +
        '}';
  }

  public static void main(String[] args) {
    Node node1 = new Node(1);
    Node node2 = new Node(2);
    Node node3 = new Node(3);
    node1.setNext(node2);
    node2.setPrev(node1);
    node2.setNext(node3);
    node3.setPrev(node2);
    System.out.println("node1.data = " + node1.getData());
    System.out.println("node1.next.data = " + node1.next.getData());
    System.out.println("node1.next.next.data = " + node1.getNext().getNext().getData());
  }

}
