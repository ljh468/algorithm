package _11주차_동적프로그래밍;

import java.util.Arrays;

// 불필요한 중복 연산이 수행됨 -> 메모이제이션을 활용
public class FibonacciMemo {

  private static long[] dp = new long[101];

  public static long fibonacciMemo(int n) {
    // 기저조건
    if (n <= 2) return dp[n] = 1;

    // 이전에 연산을 수행한 적이 없으면 메모이제이션 저장
    if (!(dp[n] > 0)) {
      dp[n] = fibonacciMemo(n - 1) + fibonacciMemo(n - 2);
    }
    // 연산을 수행한 적이 있으면 값 리턴
    return dp[n];
  }

  public static void main(String[] args) {
    // 피보나치 수열 : 1, 1, 2, 3, 5, 8, 13, 21
    System.out.println("fibonacci(50) = " + fibonacciMemo(50));
    System.out.println("Arrays.toString(dp) = " + Arrays.toString(dp));
  }
}
