package _11주차_동적프로그래밍;

import java.util.Arrays;

public class FruitTree {

  public static void main(String[] args) {
    n = 7; // 떨어지는 과일 횟수
    m = 2; // 최대 이동 가능 횟수
    b = new int[]{1, 2, 1, 2, 1, 2, 1}; // 각 시간마다 떨어지는 나무 번호

    // DP 배열 초기화
    dp = new int[n][2][m + 1];
    for (int[][] rows : dp) {
      for (int[] cols : rows) {
        Arrays.fill(cols, -1); // 초기 값을 -1로 설정 (미방문 상태)
      }
    }

    // 두 가지 초기 상태 중 최대 값 계산
    // 1. 1번 나무에서 시작
    // 2. 2번 나무에서 시작
    int result = Math.max(
        go(0, 0, m),     // 1번 나무에서 시작
        go(0, 1, m - 1)  // 2번 나무에서 시작 (이동 기회 1회 소모)
    );

    System.out.println("result = " + result); // 결과 출력
  }

  static int[][][] dp; // DP 배열: dp[idx][tree][cnt]
  static int n, m;     // n: 과일 떨어지는 횟수, m: 이동 가능 횟수
  static int[] b;      // b[i]: i번째 시간에 떨어지는 나무 번호 (1 또는 2)

  // 재귀적으로 최대 과일 수를 계산하는 함수
  static int go(int idx, int tree, int cnt) {
    if (cnt < 0) return Integer.MIN_VALUE; // 이동 가능 횟수를 초과하면 불가능한 상태
    if (idx == n) return 0;                // 모든 시간이 지나면 종료

    if (dp[idx][tree][cnt] != -1) {
      return dp[idx][tree][cnt]; // 이미 계산된 값이면 반환
    }

    // 현재 상태에서 최대 과일 수 계산
    // 1. 다른 나무로 이동: go(idx + 1, tree ^ 1, cnt - 1)
    // 2. 같은 나무에 머무름: go(idx + 1, tree, cnt)
    // 3. tree == b[idx] - 1이면 현재 나무에서 과일을 받을 수 있음
    int maxFruit = Math.max(
        go(idx + 1, tree ^ 1, cnt - 1), // 다른 나무로 이동 (XOR 연산 활용)
        go(idx + 1, tree, cnt)          // 같은 나무에 머무름
    ) + ((tree == b[idx] - 1) ? 1 : 0); // 현재 나무에서 과일을 받았는지 확인

    return dp[idx][tree][cnt] = maxFruit; // DP에 저장 후 반환
  }
}