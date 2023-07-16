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
public class _05_02_연속된_자연수의_합_수학 {

  public int solution1(int n) {
    int answer = 0;

    // 연속된 자연수의 개수
    int cnt = 1;

    /**
     * 15에서 1, 2를 빼면 12
     * 12에서 2를 나누었을 때 나머지가 0이면 참
     */
    n = n - 1;

    while (n > 0) {
      cnt++;
      n -= cnt;
      if (n % cnt == 0) {
        answer++;
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    _05_02_연속된_자연수의_합_수학 t = new _05_02_연속된_자연수의_합_수학();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    System.out.println(t.solution1(n));
  }
}
