package _HEAP;

import java.util.ArrayList;

public class HeapSort<T extends Comparable<T>> {

  private final ObjectHeap<T> objectHeap;

  public HeapSort() {
    this.objectHeap = new ObjectHeap<>() {
      @Override
      public boolean isBigPriority(T first, T second) {
        return HeapSort.this.isBigPriority(first, second);
      }
    };
  }

  // 기본 우선순위 (작은값이 우선순위가 높도록 설정)
  public boolean isBigPriority(T first, T second) {
    return first.compareTo(second) < 0;
  }

  public ObjectHeap<T> getObjectHeap() {
    return objectHeap;
  }

  public static void main(String[] args) {
    HeapSort<MyData> heapSort = new HeapSort<>() {
      @Override
      public boolean isBigPriority(MyData first, MyData second) {
        // 작은값이 우선순위가 높은 최소 힙으로 설정
        return first.getPriority() < second.getPriority();
      }
    };

    ObjectHeap<MyData> heap = heapSort.getObjectHeap();
    heap.insert(new MyData(2));
    heap.insert(new MyData(8));
    heap.insert(new MyData(5));
    heap.insert(new MyData(6));
    heap.insert(new MyData(10));
    heap.insert(new MyData(4));
    heap.insert(new MyData(3));
    heap.insert(new MyData(7));
    heap.insert(new MyData(9));
    heap.insert(new MyData(1));

    ArrayList<MyData> list = new ArrayList<>();
    list.add(heap.remove().getData());
    list.add(heap.remove().getData());
    list.add(heap.remove().getData());
    list.add(heap.remove().getData());
    list.add(heap.remove().getData());
    list.add(heap.remove().getData());
    list.add(heap.remove().getData());
    list.add(heap.remove().getData());
    list.add(heap.remove().getData());
    list.add(heap.remove().getData());

    for (MyData myData : list) {
      System.out.println("myData.getData() = " + myData.getData());
    }

  }

}
