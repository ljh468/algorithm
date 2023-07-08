package 배열;

import java.util.Scanner;

public class _09_격자판최대합 {

  public int solution1(int n, int[][] arr) {
    int answer = Integer.MIN_VALUE;
    int colSum, lowSum;
    // 행 체크
    // 열 체크
    for (int i = 0; i < n; i++) {
      colSum = 0;
      lowSum = 0;
      for (int j = 0; j < n; j++) {
        colSum += arr[i][j];
        lowSum += arr[j][i];
      }
      if (colSum > answer) {
        answer = colSum;
      }
      if (lowSum > answer) {
        answer = lowSum;
      }
    }

    int crossSum1 = 0;
    int crossSum2 = 0;

    // 왼쪽 대각선 체크
    // 오른쪽 대각선 체크
    for (int i = 0; i < n; i++) {
      crossSum1 += arr[i][i];
      crossSum2 += arr[i][n - i - 1];
    }
    answer = Math.max(answer, crossSum1);
    answer = Math.max(answer, crossSum2);
    return answer;
  }

  public static void main(String[] args) {
    _09_격자판최대합 t = new _09_격자판최대합();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[][] arr = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        arr[i][j] = sc.nextInt();
      }
    }
    System.out.println(t.solution1(n, arr));
  }
}
