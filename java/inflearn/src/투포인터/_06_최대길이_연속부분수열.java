package 투포인터;

import java.util.Scanner;

/**
 * 0과 1로 구성된 길이가 N인 수열이 주어집니다. 여러분은 이 수열에서 최대 k번을 0을 1로 변경할 수 있습니다. 여러분이 최대 k번의 변경을 통해 이 수열에서 1로만 구성된 최대 길이의 연속부분수열을 찾는 프로그램을 작성하세요.
 * 만약 길이가 길이가 14인 다음과 같은 수열이 주어지고 k=2라면
 * 1 1 0 0 1 1 0 1 1 0 1 1 0 1
 *
 * 여러분이 만들 수 있는 1이 연속된 연속부분수열은
 * 1 1 0 0 1 1 1 1 1 1 1 1
 * 이며 그 길이는 8입니다.
 *
 * 입력
 * 15
 *
 * 출력
 * 3
 */
public class _06_최대길이_연속부분수열 {

  public int solution1(int n, int k, int[] arr) {
    // 0이 1로 변경된 횟수
    int count = 0;
    int lt = 0;
    int answer = 0;

    for (int rt = 0; rt < n; rt++) {
      // 0을 만나면 count
      if (arr[rt] == 0) {
        count++;
      }

      // count가 k를 초과하면 lt 이동
      while (count > k) {
        if (arr[lt] == 0) {
          count--;
        }
        lt++;
      }

      // 최대 길이 연속부분수열 확인
      answer = Math.max(answer, rt - lt + 1);
    }

    return answer;
  }

  public static void main(String[] args) {
    _06_최대길이_연속부분수열 t = new _06_최대길이_연속부분수열();
    Scanner sc = new Scanner(System.in);
    // 입력 예시:
    // 14 2
    // 1 1 0 0 1 1 0 1 1 0 1 1 0 1
    int n = sc.nextInt();
    int k = sc.nextInt();

    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    System.out.println(t.solution1(n, k, arr));
  }
}
