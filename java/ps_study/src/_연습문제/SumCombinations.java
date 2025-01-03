package _연습문제;

import java.io.*;
import java.util.StringTokenizer;

public class SumCombinations {

  /**
   * 기본 아이디어: 문제를 쪼개서 생각하기<p>
   * 숫자 j를 만드는 방법은, "숫자 j - i를 만든 다음 숫자 i를 더하는 경우"로 나눌 수 있음<p>
   * 즉, j를 만드는 모든 경우는 j - i를 만들 수 있는 경우의 수를 기반으로 함<p>
   * dp[j - i]는 숫자 j - i를 만드는 모든 경우의 수를 이미 알고 있기 때문에,<p>
   * 이 값에 숫자 i를 더한 모든 경우를 dp[j]에 더해서 계산<p>
   */
  public static void main(String[] args) throws IOException {
    // 입력 예시
    // 3
    // 4 8 15
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int T = Integer.parseInt(br.readLine());
    int[] dp = new int[10001]; // dp[x]는 숫자 x를 만들 수 있는 모든 경우의 수

    dp[0] = 1; // 초기값: 0을 만들 수 있는 경우는 1가지 (아무것도 선택하지 않는 경우)

    // dp 배열은 1, 2, 3을 조합하여 모든 숫자를 만들 수 있는 경우의 수를 계산

    // 외부 반복문: i = 1, 2, 3 (1, 2, 3이라는 숫자를 사용해서 dp 배열을 채움)
    // i = 1: 숫자 1만을 사용해서 모든 값을 계산
    // i = 2: 숫자 1과 2를 사용해서 추가적인 값을 계산
    // i = 3: 숫자 1, 2, 3을 사용해서 최종 값을 계산
    // 1, 2, 3 숫자로 구할 수 있는 경우의 수를 모두 더하면 총 경우의 수를 구할 수 있음
    for (int i = 1; i <= 3; i++) {
      // 내부 반복문: j = i부터 10000까지, 숫자 j를 만들 수 있는 경우의 수를 계산
      for (int j = 1; j <= 10; j++) {
        System.out.println("i = " + i + ", j = " + j);
        System.out.println("(j - i) = " + (j - i));
        // j가 되기 위해 i를 더하는게 유효하다면? dp[j] 갱신
        if (j - i >= 0) {
          System.out.println("이전 dp[" + j + "] = " + dp[j]);
          System.out.println("dp[" + j + "] = " + dp[j] + ", dp[" + (j - i) + "] = " + dp[j - i]);
          System.out.println("dp[" + j + "] + " + "dp[" + (j - i) + "] = " + (dp[j] + dp[j - i]));
          // dp[j - i]를 더하는 이유는 :
          // 숫자 j - i를 만들 수 있는 모든 경우의 수에 숫자 i를 추가하면 숫자 j를 만들 수 있기 때문
          dp[j] += dp[j - i];
          System.out.println("이후 dp[" + j + "] = " + dp[j]);
          /**
           * 예시 i가 2일때 dp[4] = dp[4] + dp[2] 가 되는 이유
           * 숫자 2를 추가할 때 dp[4]에는 (1 + 1 + 1 + 1) (2 + 1 + 1), (2 + 2) 이 되어야 함
           * 숫자 2로 숫자 4를 만드는 경우는 숫자 2에 (이전에 2를 만드는 경우)를 추가하면 됨
           * [2 + "(1 + 1) -> 이전에 계산된 dp[2]의 경우의 수 값"]
           * [2 + "(0 + 2) -> 이전에 계산된 dp[2]의 경우의 수 값"]
           * 결 국 (0 + 2), (1 + 1)은 숫자 2를 만드는 내부 과정
           * 결국, 숫자 2를 만드는 모든 경우의 수 (dp[2])는 숫자 4를 만드는 새로운 경우로 확장
           * 숫자 4를 만들기 위해 숫자 2를 선택한 뒤, 남은 숫자 2 (4 - 2 = 2)를 만들 수 있는 모든 경우의 수를 추가
           * <br>
           * 예제: i = 2, j = 2에서 dp[j] += dp[j - i]
           * 상태:
           * j = 2: 숫자 2를 만들려고 함.
           * i = 2: 숫자 2를 사용하는 상황.
           * j - i = 2 - 2 = 0: 즉, 숫자 0에 숫자 2를 추가하면 숫자 2를 만들 수 있음.
           * <br>
           * dp[0]의 의미:
           * dp[0] = 1: 숫자 0을 만들 수 있는 경우의 수는 1가지(아무것도 선택하지 않는 경우).
           * <br>
           * 숫자 2를 만드는 방법:
           * 숫자 0에서 숫자 2를 추가하면 숫자 2가 만들어짐.
           * 따라서, 숫자 0을 만들 수 있는 경우의 수인 dp[0]을 숫자 2를 만들 수 있는 경우의 수에 더해줌.
           * <br>
           * 계산 과정:
           * 이전 상태: dp[2] = 1 (숫자 2를 만들 수 있는 기존 경우의 수는 1개).
           * 새로운 경우 추가: 숫자 0에서 숫자 2를 더한 경우의 수를 추가하므로, dp[2] += dp[0].
           * 결과: dp[2] = 1 + 1 = 2.
           */
        }
        System.out.println();
      }
      System.out.println();
    }

    // 각 테스트 케이스 처리
    StringTokenizer st = new StringTokenizer(br.readLine());
    while (T-- > 0) {
      int n = Integer.parseInt(st.nextToken());
      // dp[n]: n을 만들 수 있는 경우의 수
      bw.write(dp[n] + " "); // dp[n]: n을 만들 수 있는 경우의 수
    }
    bw.flush();
    br.close();
    bw.close();
    // 출력예시
    // 4 10 27
  }
}