package 정렬;

import java.util.Scanner;

// 2번째 수 부터 시작하여 앞의 수와 비교하여 작으면 앞으로 이동한다.
public class _03_삽입정렬 {

  public int[] solution(int n, int[] arr) {

    // 1. 삽입정렬은 2번째 부터 n까지 회전한다.
    for (int i = 1; i < n; i++) {

      // 2. 앞의 수들 확인
      int tmp = arr[i];
      int j;
      for (j = i - 1; j >= 0; j--) {

        // 3. 앞의 수와 비교해서 작으면 자리를 바꾼다.
        if (arr[j] > tmp) {
          arr[j + 1] = arr[j];
        } else {
          break;
        }
      }
      arr[j + 1] = tmp;
    }
    return arr;
  }

  public static void main(String[] args) {
    _03_삽입정렬 t = new _03_삽입정렬();
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    for (int x : t.solution(n, arr)) {
      System.out.print(x + " ");
    }
  }
}
