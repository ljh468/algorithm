package 투포인터;

import java.util.Scanner;

/**
 * 현수의 아빠는 제과점을 운영합니다. 현수 아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 최대 매출액이 얼마인지 구하라고 했습니다.
 * 만약 N=10이고 10일 간의 매출기록이 아래와 같습니다. 이때 K=3이면
 * 12 1511 20 2510 20 19 13 15
 * 연속된 3일간의 최대 매출액은 11 + 20 + 25 = 56만원입니다.
 * k일 연속 최대 매출액을 출력하시오
 *
 * 입력
 * 10 3
 * 12 15 11 20 25 10 20 19 13 15
 *
 * 출력
 * 56
 *
 */
public class _03_최대매출 {

  public int solution1(int n, int k, int[] arr) {
    // 슬라이딩 윈도우 초기값 세팅
    int sum = 0;
    for (int i = 0; i < k; i++) {
      sum += arr[i];
    }

    // 최대 매출액 초기화
    int answer = 0;
    answer = sum;

    // k 위치부터 한칸씩 이동하면서 연속된 k만큼의 배열중 가장 큰 매출액 찾기
    for (int i = k; i < n; i++) {
      sum += arr[i] - arr[i - k];
      answer = Math.max(sum, answer);
    }
    return answer;
  }

  public static void main(String[] args) {
    _03_최대매출 t = new _03_최대매출();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    System.out.println(t.solution1(n, k, arr));

  }
}
