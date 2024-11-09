package _11주차_동적프로그래밍;

public class Lv03_정수삼각형 {

  public static int solution(int[][] triangle) {
    int n = triangle.length;

    // 1. dp 배열 초기화
    int[][] dp = new int[n][n];

    // 2. dp 배열의 맨 아래쪽 라인 초기화
    for (int i = 0; i < n; i++) {
      dp[n - 1][i] = triangle[n - 1][i];
    }

    // 3. 아래쪽 라인부터 올라가면서 dp 배열 채우기
    for (int i = n - 2; i >= 0; i--) {
      for (int j = 0; j <= i; j++) {
        dp[i][j] = Math.max(dp[i + 1][j], dp[i + 1][j + 1]) + triangle[i][j];
      }
    }

    // 4. 꼭대기에서의 최댓값 반환
    return dp[0][0];
  }

  public static void main(String[] args) {
    int[][] triangle = {
        {7},
        {3, 8},
        {8, 1, 0},
        {2, 7, 4, 4},
        {4, 5, 2, 6, 5}
    };

    int result = solution(triangle);
    System.out.println("result = " + result);
  }
}
