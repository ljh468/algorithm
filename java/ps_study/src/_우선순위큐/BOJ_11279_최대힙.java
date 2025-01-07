package _우선순위큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

// https://www.acmicpc.net/problem/11279
public class BOJ_11279_최대힙 {

  /**
   * 입력 예시
   * 9
   * 0
   * 12345678
   * 1
   * 2
   * 0
   * 0
   * 0
   * 0
   * 32
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    // 1. 우선순위 큐에 삽입
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(br.readLine());
      if (num != 0) {
        pq.add(num);
      } else {
        if (pq.isEmpty()) {
          sb.append(0).append("\n");
        } else {
          sb.append(pq.poll()).append("\n");
        }
      }
    }
    System.out.println(sb);
    br.close();
  }
  /**
   * 출력 예시
   * 0
   * 1
   * 2
   * 12345678
   * 0
   */
}
