package _HEAP;

public class Monster implements Comparable<Monster> {

  private String name;

  private int health;

  private int priority;

  public Monster(String name, int health) {
    this.name = name;
    this.health = health;
    this.priority = health;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getHealth() {
    return health;
  }

  public void setHealth(int health) {
    this.health = health;
  }

  public int getPriority() {
    return priority;
  }

  public void setPriority(int priority) {
    this.priority = priority;
  }

  @Override
  public int compareTo(Monster other) {
    return Integer.compare(this.priority, other.priority);
  }

  @Override
  public String toString() {
    return "Monster{" +
        "name='" + name + '\'' +
        ", healath=" + health +
        ", priority=" + priority +
        '}';
  }

}
