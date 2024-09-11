package _04주차_그래프;

import java.util.*;

public class Lv03_여행경로 {

  // map 구조의 그래프
  static Map<String, List<String>> map = new HashMap<>();

  // map 구조만큼 방문을 기록할 배열
  static Map<String, boolean[]> visited = new HashMap<>();

  // 방문 순서를 저장할 배열
  static List<String> resultOrder = new ArrayList<>();

  public String[] solution(String[][] tickets) {
    // 1. 티켓을 그래프로 만듬 (인접리스트)
    for (String[] ticket : tickets) {

      List<String> list = map.getOrDefault(ticket[0], new ArrayList<>());
      list.add(ticket[1]);
      Collections.sort(list); // 알파벳 순서로 정렬
      map.put(ticket[0], list);
    }
    System.out.println("map = " + map);

    // 2. map의 각 키에 대해 방문 여부 배열을 생성
    for (String key : map.keySet()) {
      List<String> dest = map.get(key);
      visited.put(key, new boolean[dest.size()]); // 목적지 개수만큼 방문 여부 배열 생성
    }

    for (String key : visited.keySet()) {
      System.out.println(key + " = " + Arrays.toString(visited.get(key)));
    }

    // 3. DFS 시작 (ICN에서 출발)
    dfs("ICN", tickets.length);

    // 6. 방문순서 리턴
    return resultOrder.toArray(String[]::new);
  }

  // DFS : 현재 도시에서 갈 수 있는 경로를 탐색
  private boolean dfs(String current, int ticketCount) {
    resultOrder.add(current); // 방문 순서에 현재 도시 추가

    // 티켓을 모두 사용한 경우 탐색 종료
    if (resultOrder.size() == ticketCount + 1) {
      return true;
    }

    // 현재 도시에서 갈 수 있는 다음 도시들을 탐색
    if (map.containsKey(current)) {
      List<String> destinations = map.get(current);
      boolean[] visitArr = visited.get(current);

      // 인접한 도시 순회
      for (int i = 0; i < destinations.size(); i++) {
        if (!visitArr[i]) { // 방문하지 않은 도시라면
          visitArr[i] = true; // 방문 표시

          // DFS 재귀 (다음 도시를 탐색했으면 true를 리턴)
          if (dfs(destinations.get(i), ticketCount)) {
            return true;
          }
          visitArr[i] = false; // 되돌아오는 경우 방문 취소
        }
      }
    }

    resultOrder.remove(resultOrder.size() - 1); // 경로에서 마지막 도시 제거 (백트래킹)
    return false;
  }

  public static void main(String[] args) {
    Lv03_여행경로 main = new Lv03_여행경로();

    String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
    System.out.println("result = " + Arrays.toString(main.solution(tickets)));
  }
}
