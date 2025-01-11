package _04주차_그래프;

import java.util.ArrayList;

/*
인접리스트의 개념:
- 인접리스트는 그래프를 표현하는 방법 중 하나로, 각 정점에 연결된 다른 정점들을 리스트 형태로 저장합니다.
  이 리스트는 일반적으로 벡터, 배열 또는 링크드 리스트로 구현됩니다.

인접리스트의 시간 복잡도:
- 그래프의 모든 간선을 순회하는데 걸리는 시간은 O(E)입니다. 여기서 E는 간선의 수를 의미합니다.
- 정점의 수를 V라 할 때, 모든 정점을 순회하는데 O(V)의 시간이 걸립니다.
- 특정 정점에 연결된 모든 정점을 순회하는 시간은 해당 정점에 연결된 간선의 수에 비례하며,
  평균적으로 한 정점에 연결된 간선의 수는 E/V 이므로 O(E/V)입니다.
- 인접리스트를 사용하여 두 정점 사이에 간선이 존재하는지 확인하는 데는 최악의 경우 O(V)의 시간이 걸립니다.
  이는 특정 정점에 연결된 모든 간선을 순회해야 하기 때문입니다.
- 따라서, 그래프 전체를 순회하는 시간 복잡도는 O(V + E)입니다. 이는 각 정점과 각 간선을 한 번씩 방문하는 것을 의미합니다.

인접리스트의 장점:
- 메모리 효율적: 인접 행렬에 비해 간선이 적은 희소 그래프에서 메모리를 더 효율적으로 사용합니다.
- 동적 그래프: 간선의 추가와 삭제가 상대적으로 용이합니다.

완성된 인접리스트의 모습:
- 위 코드에서 출력되는 인접리스트는 다음과 같은 형식을 가집니다.
  Vertex 1: (2, 3) (3, 5)
  Vertex 2: (1, 6) (3, 5)
  Vertex 3: (2, 1) (4, 13)
  Vertex 4: (4, 9) (1, 42)
*/
public class _AdjacencyList {

  public static void main(String[] args) {
    // 정점의 수
    int V = 4;

    // 인접 리스트 생성
    ArrayList<ArrayList<int[]>> adjList = new ArrayList<>(V + 1);

    // 각 정점에 대해 리스트 초기화
    for (int i = 0; i <= V; i++) {
      adjList.add(new ArrayList<>());
    }

    // 그래프에 간선 추가
    adjList.get(1).add(new int[]{2, 3});
    adjList.get(2).add(new int[]{1, 6});
    adjList.get(2).add(new int[]{3, 5});
    adjList.get(3).add(new int[]{2, 1});
    adjList.get(3).add(new int[]{4, 13});
    adjList.get(4).add(new int[]{1, 42});

    // 인접 리스트 출력
    for (int i = 1; i <= V; i++) {
      System.out.print("Vertex " + i + ":");
      for (int[] edge : adjList.get(i)) {
        System.out.print(" (" + edge[0] + ", " + edge[1] + ")");
      }
      System.out.println();
    }
  }
}
