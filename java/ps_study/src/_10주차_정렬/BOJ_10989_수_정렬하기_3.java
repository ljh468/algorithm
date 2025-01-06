package _10주차_정렬;

import java.io.*;

// https://www.acmicpc.net/problem/10989
// 첫째 줄에 수의 개수 N(1 ≤ N ≤ 10,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다. 이 수는 10,000보다 작거나 같은 자연수이다.
public class BOJ_10989_수_정렬하기_3 {

  /**
   * 입력 예시
   * 10
   * 5
   * 2
   * 3
   * 1
   * 4
   * 2
   * 3
   * 5
   * 1
   * 7
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());

    // 계수 배열 생성
    int[] countingArr = new int[10_000 + 1];

    // 입력
    for (int i = 0; i < n; i++) {
      int num = Integer.parseInt(br.readLine());
      countingArr[num]++;
    }

    // O(K+N)
    for (int i = 0; i < countingArr.length; i++) { // O(K)
      // 개수만큼 출력
      for (int j = 0; j < countingArr[i]; j++) { // O(N)
        bw.write(i + "\n");
      }
    }
    bw.flush();

    br.close();
    bw.close();
  }
  /**
   * 출력 예시
   * 1
   * 1
   * 2
   * 2
   * 3
   * 3
   * 4
   * 5
   * 5
   * 7
   */
}
