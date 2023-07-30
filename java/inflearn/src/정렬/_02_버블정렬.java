package 정렬;

import java.util.Scanner;

// 가장 큰수가 맨 뒤로 이동
public class _02_버블정렬 {

  public int[] solution(int n, int[] arr) {

    // 1. 버블정렬은 n-1 회전한다.
    for (int i = 0; i < n - 1; i++) {

      // 2. 인접한 두 원소를 비교 (n - i - 1 만큼 확인)
      for (int j = 0; j < n - i - 1; j++) {

        // 3. 앞의 수가 뒤의 수 보다 크면 자리를 바꾼다.
        if (arr[j] > arr[j+1]) {
          int tmp = arr[j];
          arr[j] = arr[j+1];
          arr[j+1] = tmp;
        }

      }

    }

    return arr;
  }

  public static void main(String[] args) {
    _02_버블정렬 t = new _02_버블정렬();
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
