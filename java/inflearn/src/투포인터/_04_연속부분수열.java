package 투포인터;

import java.util.Scanner;

/**
 * N개의 수로 이루어진 수열이 주어집니다.
 * 이 수열에서 연속부분수열의 합이 특정숫자 M이 되는 경우가 몇 번 있는지 구하는 프로그램을 작성하세요.
 * 만약 N=8, M=6이고 수열이 다음과 같다면
 * 1 2 1 3 1 1 1 2
 * 합이 6이 되는 연속부분수열은 {2, 1, 3}, {1, 3, 1, 1}, {3, 1, 1, 1}로 총 3가지입니다.
 *
 * 입력
 * 8 6
 * 1 2 1 3 1 1 1 2
 *
 * 출력
 * 3
 *
 */
public class _04_연속부분수열 {

  public int solution1(int n, int m, int[] arr) {
    int answer = 0;
    int sum = 0;
    int lt = 0;

    // lt ==> rt 까지의 합이 작으면 rt의 위치는 다음으로 이동
    for (int rt = 0; rt < n; rt++) {

      sum += arr[rt];
      // 값이 같으면 경우의 수 추가
      if (sum == m) {
        answer++;
      }

      // lt ==> rt 까지의 합이 크거나 같으면 lt가 쫓아와야 함
      // 합이 같을 때까지 계속 rt를 쫓아와야 하므로 while문
      while (sum >= m) {
        sum -= arr[lt];
        lt++;
        if (sum == m) {
          answer++;
        }
      }

    }
    return answer;
  }

  public int solution2(int n, int m, int[] arr) {
    int answer = 0;

    return answer;
  }

  public static void main(String[] args) {
    _04_연속부분수열 t = new _04_연속부분수열();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    System.out.println(t.solution1(n, m, arr));
  }
}
