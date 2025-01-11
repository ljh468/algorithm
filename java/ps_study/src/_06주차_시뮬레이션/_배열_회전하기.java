package _06주차_시뮬레이션;

import java.util.Arrays;

public class _배열_회전하기 {

  public static int[][] rightRotate90(int[][] arr) {
    int n = arr.length;
    int[][] result = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        // 일반화 : A[i, j] = A[j, (n - 1) - i)
        result[j][n - i - 1] = arr[i][j];
      }
    }
    return result;
  }

  public static void printMatrix(int[][] matrix) {
    for (int[] row : matrix) {
      System.out.println(Arrays.toString(row));
    }
  }

  public static void main(String[] args) {
    int N = 2;
    int[][] arr = {
        {1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12},
        {13, 14, 15, 16}
    };

    // 시계방향 90도로 n번 회전
    for (int i = 0; i < N; i++) {
      arr = rightRotate90(arr);
    }

    // 출력
    printMatrix(arr);
  }
}
