package _그래프;

import java.util.*;

/**
 * BFS (너비 우선 탐색)
 * - 너비우선탐색은 시작 정점을 방문한 후 시작 정점에 인접한 모든 정점들을 우선 방문하고,
 * - 멀리 떨어져 있는 나머지 정점은 나중에 방문하는 방식으로 탐색하는 알고리즘
 * 1. 인접한 정점들을 순회하여 방문할 정점으로 저장하고, 방문한 정점을 큐에 삽입
 * 2. 모든 입접한 정점이 저장되었으면, 하나씩 큐에서 dequeue (FIFO)
 * 3. dequeue한 정점의 인접 정점을 순회
 * (만약 인접 정점이 이미 방문한 노드라면 건너뛰고, 방문하지 않은 정점이라면 1번 반복 수행)
 */
public class Bfs {

  public static void BFS(Vertex vertex) {
    // 큐 생성
    Queue<Vertex> queue = new LinkedList<>();
    // 방문할 정점들을 저장할 해시테이블
    Map<String, Boolean> visitedVertices = new HashMap<>();

    // 방문한 정점으로 저장 & 큐에 저장
    visitedVertices.put(vertex.getValue(), true);
    queue.offer(vertex);

    while (queue.isEmpty() == false) {
      Vertex currentVertex = queue.poll();
      System.out.println("정점: " + currentVertex.getValue());

      // 인접 정점 순회
      for (Vertex adjacent : currentVertex.getAdjacentVertices()) {
        // 이미 방문한 정점이라면, 아무일도 하지 않고 넘어감
        if (visitedVertices.getOrDefault(adjacent.getValue(), false)) {
          continue;
        } else {
          // 방문하지 않은 정점이라면, 방문한 정점으로 저장 & 큐에 저장
          visitedVertices.put(adjacent.getValue(), true);
          queue.offer(adjacent);
        }
      }

    }

  }

  public void BFS_Test() {
    Vertex ben = new Vertex("Ben");
    Vertex ivy = new Vertex("Ivy");
    Vertex joy = new Vertex("Joy");
    Vertex jake = new Vertex("Jake");
    Vertex anna = new Vertex("Anna");
    Vertex david = new Vertex("David");
    Vertex elin = new Vertex("Elin");
    Vertex owen = new Vertex("Owen");

    ben.addAdjacentVertex(ivy);
    ben.addAdjacentVertex(jake);
    ben.addAdjacentVertex(anna);
    ben.addAdjacentVertex(david);

    ivy.addAdjacentVertex(ben);
    ivy.addAdjacentVertex(joy);

    joy.addAdjacentVertex(ivy);
    joy.addAdjacentVertex(jake);

    jake.addAdjacentVertex(ben);
    jake.addAdjacentVertex(joy);

    anna.addAdjacentVertex(ben);

    david.addAdjacentVertex(ben);
    david.addAdjacentVertex(elin);

    elin.addAdjacentVertex(david);
    elin.addAdjacentVertex(owen);

    owen.addAdjacentVertex(elin);

    Bfs.BFS(ben);
  }

  public static void main(String[] args) {
    Bfs bfs = new Bfs();
    System.out.println("==== BFS 테스트 ====");
    bfs.BFS_Test();
  }

}
