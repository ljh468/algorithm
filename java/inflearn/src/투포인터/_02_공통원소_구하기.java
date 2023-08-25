package 투포인터;

import java.util.*;

/**
 * A, B 두 개의 집합이 주어지면 두 집합의 공통 원소를 추출하여 오름차순으로 출력하는 프로그램을 작성
 * 두 집합의 공통원소를 오름차순 정렬하여 출력
 *
 * 입력
 * 5
 * 1 3 9 5 2
 * 5
 * 3 2 5 7 8
 *
 * 출력
 * 2 3 5
 *
 */
public class _02_공통원소_구하기 {

  public List<Integer> solution1(int n, int m, int[] a, int[] b) {
    List<Integer> answer = new ArrayList<>();
    // a, b 배열 오름차순 정렬
    Arrays.sort(a);
    Arrays.sort(b);

    int p1 = 0, p2 = 0;
    // 포인터가 끝날 때까지 반복
    while (p1 < n && p2 < m) {

      // 공통 원소이면 추가하기
      if (a[p1] == b[p2]) {
        answer.add(a[p1]);
        p1++;
        p2++;
      } else if (a[p1] < b[p2]) {
        p1++;
      } else {
        p2++;
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    _02_공통원소_구하기 t = new _02_공통원소_구하기();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = sc.nextInt();
    }

    int m = sc.nextInt();
    int[] b = new int[m];
    for (int i = 0; i < m; i++) {
      b[i] = sc.nextInt();
    }

    for (int x : t.solution1(n, m, a, b)) {
      System.out.print(x + " ");
    }

  }
}
