package _그래프;

import java.util.HashMap;
import java.util.Map;

public class WeightedGraphVertex {

  private String value;

  private Map<String, Integer> adjacentVertices;

  public WeightedGraphVertex(String value) {
    this.value = value;
    this.adjacentVertices = new HashMap<>(); // key는 지역이름, value는 가중치
  }

  public String getValue() {
    return value;
  }

  public Map<String, Integer> getAdjacentVertices() {
    return adjacentVertices;
  }

  public void addAdjacentVertex(WeightedGraphVertex vertex, int weight) {
    this.adjacentVertices.put(vertex.getValue(), weight);
  }

  public void removeAdjacentVertex(WeightedGraphVertex vertex) {
    this.adjacentVertices.remove(vertex.getValue());
  }

  public static void main(String[] args) {
    WeightedGraphVertex seoul = new WeightedGraphVertex("서울");
    WeightedGraphVertex wonju = new WeightedGraphVertex("원주");
    WeightedGraphVertex gangneung = new WeightedGraphVertex("강릉");
    WeightedGraphVertex daejeon = new WeightedGraphVertex("대전");
    WeightedGraphVertex jeonju = new WeightedGraphVertex("전주");
    WeightedGraphVertex daegu = new WeightedGraphVertex("대구");

    System.out.println("==== seoul의 인접정점: " + seoul.getAdjacentVertices());
    System.out.println("==== 원주(wonju), 대전(daejeon), 전주(jeonju) 추가");
    seoul.addAdjacentVertex(wonju, 87);
    seoul.addAdjacentVertex(daejeon, 140);
    seoul.addAdjacentVertex(jeonju, 187);

    System.out.println("==== seoul의 인접정점: " + seoul.getAdjacentVertices());

    System.out.println("==== 전주(jeonju) 제거");
    seoul.removeAdjacentVertex(jeonju);

    System.out.println("==== seoul의 인접정점: " + seoul.getAdjacentVertices());
  }
}
