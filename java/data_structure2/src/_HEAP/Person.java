package _HEAP;

public class Person implements Comparable<Person> {

  private String name;

  private int age;

  private int priority;

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
    this.priority = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public int getPriority() {
    return priority;
  }

  public void setPriority(int priority) {
    this.priority = priority;
  }

  @Override
  public int compareTo(Person other) {
    return Integer.compare(this.priority, other.priority);
  }


  @Override
  public String toString() {
    return "Person{" +
        "name='" + name + '\'' +
        ", age=" + age +
        ", priority=" + priority +
        '}';
  }

}
