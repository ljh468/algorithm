package _Codility;

// https://app.codility.com/programmers/lessons/17-dynamic_programming/number_solitaire/
public class NumberSolitaire {

  public static void main(String[] args) {
    int[] A = {1, -2, 0, 9, -1, -2};
    System.out.println("result = " + solution(A));
  }

  /**
   * 코드의 핵심 아이디어<p>
   * 주어진 배열 A에서, 시작점(첫 번째 칸)부터 마지막 칸까지 이동하면서 최대 점수를 계산합니다.<p>
   * 각 칸 i에서 가능한 이전 위치(주사위 눈금)를 통해 최대 점수를 갱신합니다.<p>
   * dp[i]는 칸 i에 도달했을 때의 최대 점수를 의미<p>
   */
  public static int solution(int[] A) {
    int N = A.length;
    // 최대 점수를 저장할 배열
    int[] dp = new int[N];
    dp[0] = A[0]; // 첫 번째 칸의 점수 초기화

    // 각 칸에 대해 최대 점수를 계산하면서 dp에 미리 저장
    for (int i = 1; i < N; i++) {
      System.out.println("i = " + i);
      int maxScore = Integer.MIN_VALUE;
      // 주사위(1~6)가 나올 수 있는 경우를 보고 현재 위치 i로 도달할 수 있는 이전 위치를 계산
      // 예를 들어, 위치 i에 도달하기 위해서는 주사위를 굴려 1에서 6 사이의 값을 얻어야 함
      // 따라서, i에서 주사위 값(dice)을 뺀 값 (i - dice)은 이전에 도달 가능한 위치라는 것
      // 이전에 도달 가능한 위치의 최대점수와 비교하면 현재의 최대점수도 쉽게 구할 수 있음
      for (int dice = 1; dice <= 6; dice++) {
        //  유효한 이전 위치라면?
        if (i - dice >= 0) {
          // 이전 위치의 최대점수와 현재 최대점수를 비교해서 최대점수를 갱신
          maxScore = Math.max(maxScore, dp[i - dice]);
          System.out.println("maxScore = " + maxScore);
        }
      }
      dp[i] = maxScore + A[i];
    }

    return dp[N - 1]; // 마지막 칸의 최대 점수 반환
  }
}
