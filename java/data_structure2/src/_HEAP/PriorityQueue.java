package _HEAP;

public class PriorityQueue<T extends Comparable<T>> {

  private final ObjectHeap<T> objectHeap;

  public PriorityQueue() {
    this.objectHeap = new ObjectHeap<T>() {
      @Override
      public boolean isBigPriority(T first, T second) {
        return PriorityQueue.this.isBigPriority(first, second);
      }
    };
  }

  // 기본 우선순위 (작은값이 우선순위가 높도록 설정)
  public boolean isBigPriority(T first, T second) {
    // 음수 값: first가 second보다 작음
    // 0: first가 second와 같음
    // 양수 값: first가 second보다 큼
    return first.compareTo(second) < 0;
  }

  public ObjectHeap<T> getObjectHeap() {
    return objectHeap;
  }

  public void enqueue(T data) {
    this.objectHeap.insert(data);
  }

  public ObjectBinaryTree<T> dequeue() {
    return this.objectHeap.remove();
  }

  public static void main(String[] args) {
    // 우선순위 큐의 몬스터의 우선순위 값이 큰 것이 우선순위가 높도록 설정 가능
    PriorityQueue<Monster> priorityQueue = new PriorityQueue<Monster>() {
      @Override
      public boolean isBigPriority(Monster first, Monster second) {
        return first.getPriority() > second.getPriority();
      }
    };

    priorityQueue.enqueue(new Monster("슬라임", 100));
    priorityQueue.enqueue(new Monster("슬라임", 87));
    priorityQueue.enqueue(new Monster("슬라임", 21));
    priorityQueue.enqueue(new Monster("슬라임", 47));
    priorityQueue.enqueue(new Monster("주황버섯", 200));

    System.out.println("==== 중위순회 ====");
    priorityQueue.getObjectHeap().getRoot()
                 .inOrderTraversal(priorityQueue.getObjectHeap().getRoot());
    System.out.println("root = " + priorityQueue.objectHeap.getRoot());

    System.out.println("==== dequeue ====");
    System.out.println(priorityQueue.dequeue().getData());
    System.out.println(priorityQueue.dequeue().getData());
    System.out.println(priorityQueue.dequeue().getData());
  }

}
