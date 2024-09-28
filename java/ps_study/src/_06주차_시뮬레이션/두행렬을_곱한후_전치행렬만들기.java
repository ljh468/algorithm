package _06주차_시뮬레이션;

import java.util.Arrays;

public class 두행렬을_곱한후_전치행렬만들기 {

  public static int[][] transposeMatrix(int[][] arr) {
    int[][] transposeArr = new int[arr.length][arr[0].length];
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        transposeArr[j][i] = arr[i][j];
      }
    }
    return transposeArr;
  }

  public static int[][] multiplyMatrix(int[][] matrix1, int[][] matrix2) {
    int rowA = matrix1.length;
    int colA = matrix1[0].length;
    int colB = matrix2[0].length;

    int[][] multiplyArr = new int[rowA][colB];
    for (int i = 0; i < rowA; i++) {
      for (int j = 0; j < colB; j++) {
        for (int k = 0; k < colA; k++) {
          multiplyArr[i][j] += matrix1[i][k] * matrix2[k][j];
        }
      }
    }
    return multiplyArr;
  }

  public static void printMatrix(int[][] matrix) {
    for (int[] row : matrix) {
      System.out.println(Arrays.toString(row));
    }
  }

  public static void main(String[] args) {

    // 입력값 예시
    int[][] matrix1 = {
        {2, 4, 6},
        {1, 3, 5},
        {7, 8, 9}
    };
    int[][] matrix2 = {
        {9, 1, 2},
        {4, 5, 5},
        {7, 3, 8}
    };

    // 출력값 예시
    /**
     * 76, 56, 158
     * 40, 31, 74
     * 72, 57, 126
     */
    int[][] transposed = transposeMatrix(multiplyMatrix(matrix1, matrix2));
    printMatrix(transposed);
  }
}
