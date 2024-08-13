package 투포인터;

import java.util.Scanner;

/**
 * N입력으로 양의 정수 N이 입력되면 2개 이상의 연속된 자연수의 합으로 정수 N을 표현하는 방법의 가짓수를 출력하는 프로그램을 작성
 * 만약 N=15이면
 * 7+8=15
 * 4+5+6=15
 * 1+2+3+4+5=15
 * 와 같이 총 3가지의 경우가 존재한다.
 * <p>
 * 입력
 * 15
 * <p>
 * 출력
 * 3
 */
public class _05_01_연속된_자연수의_합 {

  public int solution1(int n) {
    int answer = 0;
    int sum = 0;
    int lt = 1;

    // 연속된 자연수의 합으로 n을 표현한다면?
    // 연속된 자연수는 n을 2로 나눈 몫 + 1(n / 2 + 1) 까지만 확인하면 됨
    // ex: n이 15 -> 7 + 8(15 / 2 + 1)
    //     8을 넘어가는 순간 (8 + 9) 15를 넘어버림
    for (int rt = 1; rt <= n / 2 + 1; rt++) {
      sum += rt;
      if (sum == n) {
        answer++;
      }

      while (sum >= n) {
        sum -= lt;
        lt++;
        if (sum == n) {
          answer++;
        }
      }
    }

    return answer;
  }

  public int solution2(int n) {
    int answer = 0;

    int sum = 0;
    int lt = 0;
    int m = (n / 2) + 1;
    int[] arr = new int[m];
    for (int i = 0; i < m; i++) {
      arr[i] = i + 1;
    }

    for (int rt = 0; rt < m; rt++) {
      sum += arr[rt];
      if (sum == n) {
        answer++;
      }

      while (sum >= n) {
        sum -= arr[lt];
        lt++;
        if (sum == n) {
          answer++;
        }
      }
    }


    return answer;
  }

  public static void main(String[] args) {
    _05_01_연속된_자연수의_합 t = new _05_01_연속된_자연수의_합();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    System.out.println(t.solution1(n));
    System.out.println(t.solution2(n));
  }
}
