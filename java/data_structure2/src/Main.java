import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    // BufferedReader를 사용하여 입력받기
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());  // 수빈이의 시작 위치
    int k = Integer.parseInt(st.nextToken());  // 동생의 위치

    int[] dist = new int[100005];  // 거리 배열
    Arrays.fill(dist, -1);  // -1로 배열 초기화

    Queue<Integer> queue = new LinkedList<>();
    queue.offer(n);  // 수빈이의 현재 위치를 큐에 삽입
    dist[n] = 0;  // 수빈이의 현재 위치 0으로 초기화

    // 동생의 위치를 찾을 때까지 반복
    while (dist[k] == -1) {
      int cur = queue.poll();  // 큐에서 현재 위치 가져오기

      // 가능한 다음 위치들 계산
      int[] nextPositions = {cur - 1, cur + 1, cur * 2};
      for (int nxt : nextPositions) {
        // 범위를 벗어난 경우 무시
        if (nxt < 0 || nxt >= 100005) continue;
        // 이미 방문한 경우 무시
        if (dist[nxt] != -1) continue;

        // 거리 계산
        dist[nxt] = dist[cur] + 1;
        queue.offer(nxt);
      }
    }
    System.out.println(dist[k]);  // 동생의 위치까지의 최단 거리 출력
  }
}
