package _그래프;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

  private String value;

  private final List<Vertex> adjacentVertices; // 이웃을 저장할 리스트 (인접한 정점들)

  public Vertex(String value) {
    this.value = value;
    this.adjacentVertices = new ArrayList<>();
  }

  // 이웃 등록 (follow)
  public void addAdjacentVertex(Vertex vertex) {
    adjacentVertices.add(vertex);
  }

  // 이웃 제거 (unfollow)
  public void removeAdjacentVertex(Vertex vertex) {
    adjacentVertices.removeIf(v -> v.equals(vertex));
  }

  public List<Vertex> getAdjacentVertices() {
    return adjacentVertices;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return "Vertex{" +
        "value='" + value + '\'' +
        ", adjacentVertices=" + adjacentVertices +
        '}';
  }

  public static void main(String[] args) {
    Vertex jake = new Vertex("Jake");
    Vertex ben = new Vertex("Ben");
    Vertex joy = new Vertex("Joy");
    Vertex ivy = new Vertex("Ivy");
    Vertex elin = new Vertex("Elin");
    Vertex anna = new Vertex("Anna");
    Vertex david = new Vertex("David");

    jake.addAdjacentVertex(ben);

    ben.addAdjacentVertex(jake);

    joy.addAdjacentVertex(ben);
    joy.addAdjacentVertex(ivy);

    ivy.addAdjacentVertex(joy);
    ivy.addAdjacentVertex(ben);

    elin.addAdjacentVertex(ivy);
    elin.addAdjacentVertex(anna);

    anna.addAdjacentVertex(ben);
    anna.addAdjacentVertex(david);
    anna.addAdjacentVertex(elin);

    david.addAdjacentVertex(anna);

    // anna 출력
    printAdjacentVertices("Before removal", anna);

    // david unfollow
    System.out.println("==== anna unfollow david ====");
    anna.removeAdjacentVertex(david);

    printAdjacentVertices("After removal", anna);
  }

  private static void printAdjacentVertices(String message, Vertex vertex) {
    System.out.println(message + ": " + vertex.getValue() + "'s adjacent vertices:");
    StringBuilder text = new StringBuilder();
    text.append("[");

    List<Vertex> adjacentVertices = vertex.getAdjacentVertices();
    for (int i = 0; i < adjacentVertices.size(); i++) {
      text.append(adjacentVertices.get(i).getValue());
      if (i < adjacentVertices.size() - 1) {
        text.append(", ");
      }
    }
    text.append("]");
    System.out.println(text);
  }

}
