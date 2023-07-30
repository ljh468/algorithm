package 정렬;

import java.util.Scanner;

// 가장 작은 수가 맨 앞으로 이동
public class _01_선택정렬 {

  public int[] solution(int n, int[] arr) {

    // 1. 선택정렬은 n-1 회전한다.
    for (int i = 0; i < n - 1; i++) {

      // 2. 가장 작은 수의 위치를 찾는다.
      int idx = i;
      for (int j = i + 1; j < n; j++) {
        if (arr[j] < arr[idx]) {
          idx = j;
        }
      }

      // 3. 가장 작은 값을 찾아서 비교하는 수와 자리를 바꾼다.
      int tmp = arr[i];
      arr[i] = arr[idx];
      arr[idx] = tmp;
    }

    return arr;
  }

  public static void main(String[] args) {
    _01_선택정렬 t = new _01_선택정렬();
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
