package _05주차_백트래킹;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 긍정황_홍철이의_구걸여행 {

  static int dy[] = {-1, 0, 1, 0};
  static int dx[] = {0, 1, 0, -1};

  static int n;

  // 돈이 저장되어 있는 맵 배열
  static int[][] arr;

  // 방문을 기록할 배열
  static boolean[][] visited;

  // 경우의 수를 저장할 리스트
  static ArrayList<Integer> count = new ArrayList<>();

  static void go(int y, int x) {
    // 기저사례 : 목적지에 도착하면 종료
    if (y == (n - 1) && x == (n - 1)) {
      System.out.println("count = " + count);
      return;
    }

    // 상하좌우 순회
    for (int i = 0; i < 4; i++) {
      int ny = y + dy[i];
      int nx = x + dx[i];
      // 경계값 처리
      if (ny < 0 || nx < 0 || ny >= n || nx >= n) continue;

      // 방문한 정점은 무시
      if (visited[ny][nx]) continue;

      // 추가
      count.add(arr[ny][nx]);
      visited[ny][nx] = true;

      go(ny, nx);

      // 원상복구
      count.removeLast();
      visited[ny][nx] = false;
    }
  }

  public static void main(String[] args) {
    n = 3;

    arr = new int[][]{
        {10, 20, 21},
        {70, 90, 12},
        {80, 110, 120}
    };

    visited = new boolean[n][n];
    for (int i = 0; i < n; i++) {
      Arrays.fill(visited[i], false);
    }

    // {0, 0} 방문처리
    visited[0][0] = true;
    count.addFirst(arr[0][0]);
    // 완전탐색 시작
    go(0, 0);
  }
}
