package _그래프;

import java.util.HashMap;
import java.util.Map;

/**
 * DFS (깊이 우선 탐색)
 * - 깊이우선탐색은 시작 정점의 인접 정점 중 하나를 먼저 끝까지 탐색하고,
 * - 나머지 인접 정점도 같은 방식으로 탐색하는 알고리즘
 * 1. 현재 정점을 해시테이블에 저장 (방문 표시)
 * 2. 현재 정점의 인접 정점을 순회 (방문했던 정점은 순회하지 않음)
 * 3. 방문하지 않았던 정점이면 그 정점에 대하여 재귀적으로 깊이우선탐색 수행
 */
public class Dfs {

  public static void DFS(Vertex vertex, Map<String, Boolean> visitedVertices) {
    // 현재 정점의 방문을 기록
    visitedVertices.put(vertex.getValue(), true);
    System.out.println("정점: " + vertex.getValue());

    // 인접 정점 순회
    for (Vertex adjacent : vertex.getAdjacentVertices()) {
      // 이미 방문했다면 넘어감
      if (visitedVertices.getOrDefault(adjacent.getValue(), false)) {
        continue;
      } else {
        // 인접한 노드가 방문한 곳이 아니라면, 인접한 노드를 기준으로 DFS 재귀호출
        DFS(adjacent, visitedVertices);
      }
    }
  }

  public void DFS_Test() {
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

    Dfs.DFS(ben, new HashMap<>());
  }

  public static void main(String[] args) {
    Dfs dfs = new Dfs();
    System.out.println("==== DFS 테스트 ====");
    dfs.DFS_Test();
  }
}
