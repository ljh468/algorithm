package _05주차_백트래킹;

import java.util.Scanner;

public class BOJ_15649_N과M_01 {

  static int n, m;

  static int[] arr = new int[10]; // 숫자를 저장할 배열

  static boolean[] isused = new boolean[10]; // 숫자의 사용 여부를 체크할 배열

  // 현재 k개까지 수를 선택한 상태에서의 재귀 함수
  public static void func(int k) {
    // m개의 숫자를 모두 선택한 경우 출력 (기저 조건)
    if (k == m) {
      for (int i = 0; i < m; i++) {
        System.out.print(arr[i] + " ");
      }
      System.out.println();
      return;
    }

    // 1부터 n까지의 숫자를 선택
    for (int i = 1; i <= n; i++) {
      if (!isused[i]) { // 아직 i가 사용되지 않은 경우
        arr[k] = i; // k번째 수를 i로 선택
        isused[i] = true; // i를 사용 중이라고 표시
        func(k + 1); // 다음 숫자를 선택하기 위해 재귀 호출
        isused[i] = false; // i를 다시 사용하지 않도록 표시 해제
      }
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // 사용자로부터 n과 m 입력받음
    n = 4;
    m = 3;

    // 재귀 함수 호출
    func(0);

    sc.close();
  }
}
