package _04주차_그래프;

import java.util.ArrayList;
import java.util.List;

/*
 깊이 우선 탐색(DFS)의 개념:
 - DFS는 그래프 탐색 알고리즘 중 하나로, 시작 정점에서 출발하여 한 방향으로 가능한 깊이까지 탐색한 후,
   더 이상 갈 곳이 없으면 이전 정점으로 되돌아와 다른 방향으로 탐색을 계속하는 방식이다.
 - 시간 복잡도는 O(V + E)이며, 여기서 V는 정점의 수, E는 간선의 수를 의미한다.

 DFS를 사용해야 하는 경우:
 - 그래프의 모든 정점을 방문해야 하는 경우
 - 경로 찾기 (예: 미로 탐색)
 - 사이클 검출
 - 위상 정렬
 - 강한 연결 요소 찾기

 BFS를 사용할 수 없고 DFS를 사용해야 하는 경우:
 - 재귀적 성질을 이용해야 할 때 (예: 백트래킹 문제)
 - 공간 복잡도가 중요한 경우 (BFS는 큐를 사용하여 더 많은 메모리를 필요로 함)
*/
public class _DFS {

  // 전역 인접 리스트 및 방문 리스트
  static List<List<Integer>> adj = new ArrayList<>();
  static boolean[] visited;

  // 그래프에 간선을 추가하는 함수
  // 인자: v (정점), w (연결된 정점)
  public static void addEdge(int v, int w) {
    adj.get(v).add(w); // 정점 v의 인접 리스트에 정점 w를 추가
  }

  // 깊이 우선 탐색(DFS)을 수행하는 함수
  // 인자: v (현재 정점)
  public static void dfs(int v) {
    // 현재 정점을 방문했다고 표시하고 출력
    visited[v] = true;
    System.out.print(v + " ");

    // 현재 정점에 인접한 모든 정점을 순회
    for (int i : adj.get(v)) {
      if (!visited[i]) {
        dfs(i);
      }
    }
  }

  // 메인 함수: 그래프 생성 및 DFS 수행
  public static void main(String[] args) {
    // 정점의 개수
    int V = 5;
    visited = new boolean[V];

    // 인접 리스트 초기화
    for (int i = 0; i < V; i++) {
      adj.add(new ArrayList<>());
    }

    // 그래프에 간선 추가 (주어진 다이어그램에 따라)
    addEdge(0, 1); // A -> B
    addEdge(0, 2); // A -> C
    addEdge(1, 3); // B -> D
    addEdge(1, 4); // B -> E

    System.out.println("깊이 우선 탐색 (정점 0에서 시작):");

    // DFS 수행 (정점 0부터 시작)
    dfs(0);

        /*
         재귀 호출 과정 설명 (예: 정점 0에서 시작):
          dfs(0) 호출 -> 0 출력
              dfs(1) 호출 -> 1 출력
                  dfs(3) 호출 -> 3 출력
                  dfs(4) 호출 -> 4 출력
              dfs(2) 호출 -> 2 출력
          - dfs_traversal 종료
        */
  }
}
