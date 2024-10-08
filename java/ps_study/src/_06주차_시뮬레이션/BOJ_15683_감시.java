package _06주차_시뮬레이션;

import java.util.ArrayList;
import java.util.List;

// https://www.acmicpc.net/problem/15683
public class BOJ_15683_감시 {

  // y, x 기반 이동: 북, 동, 남, 서
  static int[] dy = {-1, 0, 1, 0};

  static int[] dx = {0, 1, 0, -1};

  static int n;

  static int m;

  static int[][] board;

  static int[][] visited; // 감시 상태를 저장할 배열

  static List<int[]> cctv = new ArrayList<>(); // CCTV 좌표 저장 리스트

  // Out Of Bounds (범위 체크) 함수
  static boolean rangeCheck(int a, int b) {
    return a < 0 || a >= n || b < 0 || b >= m;
  }

  // (x,y)에서 dir 방향으로 진행하며 벽(6)을 만날 때까지 빈칸(0)을 7로 덮음
  static void upd(int y, int x, int dir) {
    // 각 CCTV 방향구하기
    dir %= 4; // 가능한 방향이 4개이므로 4진법
    while (true) {
      y += dy[dir]; // y축 이동
      x += dx[dir]; // x축 이동
      if (rangeCheck(y, x) || visited[y][x] == 6) return; // 범위를 벗어나거나 벽을 만나면 종료
      if (visited[y][x] == 0) { // 빈칸일 경우만 덮음
        visited[y][x] = 7; // 빈칸을 7로 덮음 (CCTV 감시 영역 표시)
      }
    }
  }

  public static void main(String[] args) {
    // 입력값 예시
    n = 4;
    m = 6;
    board = new int[][]{
        {0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0},
        {0, 0, 1, 0, 6, 0},
        {0, 0, 0, 0, 0, 0}
    };
    visited = new int[n][m];

    int result = 0; // 사각지대 최소 크기

    // CCTV 위치와 초기 사각지대 개수 계산
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (board[i][j] != 0 && board[i][j] != 6) {
          cctv.add(new int[]{i, j});
        }
        if (board[i][j] == 0) {
          result++; // 사각지대 개수 카운트
        }
      }
    }

    // 각 CCTV의 방향 설정을 순차적으로 탐색
    int totalCases = (int) Math.pow(4, cctv.size()); // CCTV 크기만큼의 모든 경우의 수 (4^cctv.size())

    for (int tmp = 0; tmp < totalCases; tmp++) {
      // 방문 배열 초기화
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          visited[i][j] = board[i][j];
        }
      }

      int brute = tmp;
      for (int i = 0; i < cctv.size(); i++) {
        int dir = brute % 4;
        brute /= 4;
        int y = cctv.get(i)[0];
        int x = cctv.get(i)[1];

        // CCTV 종류별로 감시 영역 설정
        if (board[y][x] == 1) {
          upd(y, x, dir);
        } else if (board[y][x] == 2) {
          upd(y, x, dir);
          upd(y, x, dir + 2); // 반대 방향
        } else if (board[y][x] == 3) {
          upd(y, x, dir);
          upd(y, x, dir + 1); // 직각 방향
        } else if (board[y][x] == 4) {
          upd(y, x, dir);
          upd(y, x, dir + 1);
          upd(y, x, dir + 2); // 3방향 감시
        } else { // board[y][x] == 5 (네 방향 모두 감시)
          upd(y, x, dir);
          upd(y, x, dir + 1);
          upd(y, x, dir + 2);
          upd(y, x, dir + 3);
        }
      }

      // 사각지대(0)의 개수 계산
      int val = 0;
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (visited[i][j] == 0) val++;
        }
      }
      result = Math.min(result, val); // 최소 사각지대 갱신
    }

    // 결과 출력
    System.out.println(result);
  }
}