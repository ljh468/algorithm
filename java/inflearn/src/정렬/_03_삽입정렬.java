package 정렬;

import java.util.Scanner;

// 2번째 수 부터 시작하여 앞의 수와 비교하여 작으면 앞으로 이동한다.
public class _03_삽입정렬 {

  public int[] solution1(int n, int[] arr) {

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

  public int[] solution2(int n, int[] arr) {

    // 1. 삽입정렬은 2번째 부터 n까지 회전한다.
    for (int i = 1; i < n; i++) {

      // 2. 앞의 수들 확인
      for (int j = i; j > 0; j--) {
        /**
         * i가 1일 때 1과 0 비교 (i-0, i-1)
         * i가 2일 때 2과 1 비교 (i-0, i-1)
         * i가 2일 때 1과 0 비교 (i-1, i-2)
         * i가 3일 때 3과 2 비교 (i-0, i-1)
         * i가 3일 때 2과 1 비교 (i-1, i-2)
         * i가 3일 때 1과 0 비교 (i-2, i-3)
         */

        // 앞의 수가 더 크면 자리 바꾸기
        if (arr[j - 1] > arr[j]) {
          int tmp = arr[j - 1];
          arr[j - 1] = arr[j];
          arr[j] = tmp;
        }

      }

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

    for (int x : t.solution1(n, arr)) {
      System.out.print(x + " ");
    }
    System.out.println();
    for (int x : t.solution2(n, arr)) {
      System.out.print(x + " ");
    }
  }
}
