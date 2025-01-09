package _11주차_동적프로그래밍;

public class Lv02_멀리뛰기 {

  public static void main(String[] args) {
    System.out.println("result1 = " + solution1(4));
    System.out.println("result2 = " + solution2(3));
  }

  /////////////////////////////////////////////////////////////////////////////////////////////////////////////
  public static int solution1(int n) {
    // DP 배열 생성 (dp[i]는 i칸을 가는 방법의 수를 저장)
    int[] dp = new int[n + 1];

    // 초기값 설정
    dp[1] = 1;
    dp[2] = 2;

    // TODO: BOTTOM-UP
    for (int i = 3; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2] % 1234567; // 나머지 연산을 통해 값이 커지는 것을 방지
    }

    // 결과 반환
    return dp[n];
  }

  /////////////////////////////////////////////////////////////////////////////////////////////////////////////

  /////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // 메모이제이션을 위한 배열
  private static int[] memo;

  public static int solution2(int n) {
    memo = new int[n + 1];
    return topDown(n);
  }

  // TODO: TOP_DOWN
  private static int topDown(int n) {
    // 기본 케이스
    if (n == 1) return 1;
    if (n == 2) return 2;

    // 이미 계산된 값이 있다면 바로 반환
    if (memo[n] > 0) {
      return memo[n];
    }

    // 점화식을 이용하여 값 계산 및 저장
    return memo[n] = (topDown(n - 1) + topDown(n - 2)) % 1234567;
  }
  /////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
