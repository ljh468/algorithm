package _01주차;

import java.util.ArrayDeque;

// https://school.programmers.co.kr/learn/courses/30/lessons/1844
public class Lv02_게임_맵_최단거리 {

  public static int solution(int[][] maps) {
    int[] dy = {-1, 0, 1, 0};
    int[] dx = {0, 1, 0, -1};
    int[][] dist = new int[maps.length][maps[0].length];

    ArrayDeque<int[]> queue = new ArrayDeque<>();
    queue.addLast(new int[] {0, 0});
    dist[0][0] = 1;

    while (!queue.isEmpty()) {
      int[] index = queue.removeFirst();
      int y = index[0]; // 행
      int x = index[1]; // 열

      // 4방향 순회
      for (int i = 0; i < 4; i++) {
        int ny = y + dy[i];
        int nx = x + dx[i];

        // 이동할 위치 경계값 확인
        if (ny < 0 || ny >= maps.length || nx < 0 || nx >= maps[0].length) {
          continue;
        }

        // 이동할 위치가 갈수 있는 곳인지 확인 (0이면 벽)
        if (maps[ny][nx] == 0) {
          continue;
        }

        // 이동할 위치가 방문한곳이 아니면, 방문체크하고 큐에 삽입
        if (dist[ny][nx] == 0) {
          dist[ny][nx] = dist[y][x] + 1; // ##### 이전 위치에서 + 1
          queue.addLast(new int[] {ny, nx});
        }
      }

    }

    // 최종 위치 거리확인하고 거리값이 0이면 도달하지 못한것으로 -1 리턴
    int result = dist[maps.length - 1][maps[0].length - 1];
    return result == 0 ? -1 : result;
  }

  public static void main(String[] args) {
    int[][] map = {
        {1, 0, 1, 1, 1},
        {1, 0, 1, 0, 1},
        {1, 0, 1, 1, 1},
        {1, 1, 1, 0, 1},
        {0, 0, 0, 0, 1}
    };

    int[][] map2 = {
        {1, 0, 1, 1, 1},
        {1, 0, 1, 0, 1},
        {1, 0, 1, 1, 1},
        {1, 1, 1, 0, 0},
        {0, 0, 0, 0, 1}
    };

    int result1 = solution(map);
    int result2 = solution(map2);
    System.out.println("result1 = " + result1);
    System.out.println("result2 = " + result2);
  }
}
