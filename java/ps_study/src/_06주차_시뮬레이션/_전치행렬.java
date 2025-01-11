package _06주차_시뮬레이션;

import java.util.Arrays;

public class _전치행렬 {

  // 행과 열의 위치를 바꾸는 전치행렬을 구하는 메서드
  public static int[][] transposeMatrix(int[][] matrix) {
    int rows = matrix.length;
    int cols = matrix[0].length;
    int[][] transposedMatrix = new int[cols][rows];

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        transposedMatrix[j][i] = matrix[i][j];
      }
    }
    return transposedMatrix;
  }

  public static void printMatrix(int[][] matrix) {
    for (int[] row : matrix) {
      System.out.println(Arrays.toString(row));
    }
  }

  public static void main(String[] args) {
    // 예시 행렬
    int[][] matrix = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };

    // 전치행렬 구하기
    int[][] transposed = transposeMatrix(matrix);

    System.out.println("원본 행렬:");
    printMatrix(matrix);

    System.out.println("\n전치 행렬:");
    printMatrix(transposed);
  }
}
