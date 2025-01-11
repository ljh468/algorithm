package _11주차_동적프로그래밍;

import java.util.Arrays;

// 불필요한 중복 연산이 수행됨 -> 메모이제이션을 활용
public class _FibonacciTabul {

  private static long[] dp = new long[101];

  public static void main(String[] args) {

    // 첫번째, 두번째 초기값 설정
    dp[1] = 1;
    dp[2] = 1;

    // 피보나치 수열 : 1, 1, 2, 3, 5, 8, 13, 21
    // for문을 이용한 점화식
    for (int i = 3; i <= 100; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    System.out.println("Arrays.toString(dp) = " + Arrays.toString(dp));
  }
}
