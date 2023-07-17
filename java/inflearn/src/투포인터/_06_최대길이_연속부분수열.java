package 투포인터;

import java.util.Scanner;

public class _06_최대길이_연속부분수열 {

  public int solution1(int n, int k, int[] arr) {
    int answer = 0;
    // 0을 1로 바꾸는 횟수
    int count = 0;
    int lt = 0;

    // rt 이동
    for (int rt = 0; rt < n; rt++) {
      // 0 만나면 바뀐 횟수 ++
      if (arr[rt] == 0) {
        count++;
      }

      // lt 이동 (바뀐 횟수가 다 차면)
      while (count > k) {
        if (arr[lt] == 0) {
          count--;
        }
        // lt가 0을 만날때까지 올라감
        lt++;
      }
      // 연속된 수열이 크면 저장
      answer = Math.max(answer, rt - lt + 1);
    }
    return answer;
  }

  public static void main(String[] args) {
    _06_최대길이_연속부분수열 t = new _06_최대길이_연속부분수열();
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
