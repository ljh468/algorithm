package _02주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2178
public class BOJ_2178_미로탐색 {

  private static int[] dy = {-1, 0, 1, 0}; // 북, 동, 남, 서
  private static int[] dx = {0, 1, 0, -1};

  private static int[][] miro;

  private static int[][] dist;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    dist = new int[N + 1][M + 1];
    miro = new int[N + 1][M + 1];

    for (int i = 1; i <= N; i++) {
      String strArr = br.readLine();
      for (int j = 1; j <= M; j++) {
        miro[i][j] = strArr.charAt(j - 1) - '0';
      }
    }

    ArrayDeque<int[]> queue = new ArrayDeque<>();
    // 시작 좌표 거리 초기화, 큐에 삽입
    dist[1][1] = 1;
    queue.addLast(new int[] {1, 1});

    // BFS
    while (!queue.isEmpty()) {
      int[] now = queue.pollFirst();
      int y = now[0];
      int x = now[1];

      // 상하좌우 탐색
      for (int i = 0; i < 4; i++) {
        int ny = y + dy[i];
        int nx = x + dx[i];

        // 경계값 확인
        if (ny < 0 || ny >= miro.length || nx < 0 || nx >= miro[0].length) {
          continue;
        }

        // 이미 방문했거나, 이동할 수 없는 곳이면 무시
        if (dist[ny][nx] > 0 || miro[ny][nx] == 0) {
          continue;
        }

        // 거리 갱신 & 큐에 삽입
        dist[ny][nx] = dist[y][x] + 1;
        queue.addLast(new int[] {ny, nx});
      }
    }

    System.out.println(dist[N][M]);
  }
}
