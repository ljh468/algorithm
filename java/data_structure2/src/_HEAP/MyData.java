package _HEAP;

public class MyData implements Comparable<MyData> {

  private int data;
  private int priority;

  public MyData(int data) {
    this.data = data;
    this.priority = data;
  }

  public int getData() {
    return data;
  }

  public void setData(int data) {
    this.data = data;
  }

  public int getPriority() {
    return priority;
  }

  public void setPriority(int priority) {
    this.priority = priority;
  }

  @Override
  public int compareTo(MyData other) {
    return Integer.compare(this.priority, other.priority);
  }

  @Override
  public String toString() {
    return "MyData{" +
        "data=" + data +
        ", priority=" + priority +
        '}';
  }

}
