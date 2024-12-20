package _11주차_동적프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11053
public class BOJ_11053_가장_긴_증가하는_부분수열 {

  static int[] seq;
  static Integer[] dp;

  public static void main(String[] args) throws IOException {

    // 입력값 예시
    // N = 6
    // A[] = 10 20 10 30 20 50
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    seq = new int[N];
    dp = new Integer[N];

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < N; i++) {
      seq[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < N; i++) {
      LIS(i);
    }

    int max = dp[0];
    // 최댓값 찾기
    for (int i = 1; i < N; i++) {
      max = Math.max(max, dp[i]);
    }
    System.out.println(max);
  }


  static int LIS(int N) {

    // 만약 탐색하지 않던 위치의 경우
    if (dp[N] == null) {
      dp[N] = 1;  // 1로 초기화

      // N-1 부터 0까지중 N보다 작은 값들을 찾으면서 재귀호출.
      for (int i = N - 1; i >= 0; i--) {
        if (seq[i] < seq[N]) {
          dp[N] = Math.max(dp[N], LIS(i) + 1);
        }
      }
    }
    return dp[N];
  }
}
