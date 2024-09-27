package _06주차_시뮬레이션;

import java.util.Arrays;

public class 행렬_덧셈_뺄셈_곱셈 {
  // 행렬 덧셈
  public static int[][] addMatrix(int[][] a, int[][] b) {
    int rows = a.length;
    int cols = a[0].length;
    int[][] result = new int[rows][cols];

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        result[i][j] = a[i][j] + b[i][j];
      }
    }
    return result;
  }

  // 행렬 뺄셈
  public static int[][] subtractMatrix(int[][] a, int[][] b) {
    int rows = a.length;
    int cols = a[0].length;
    int[][] result = new int[rows][cols];

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        result[i][j] = a[i][j] - b[i][j];
      }
    }
    return result;
  }

  // 행렬 곱셈
  public static int[][] multiplyMatrix(int[][] a, int[][] b) {
    int rowsA = a.length;
    int colsA = a[0].length;
    int colsB = b[0].length;
    int[][] result = new int[rowsA][colsB];

    for (int i = 0; i < rowsA; i++) {
      for (int j = 0; j < colsB; j++) {
        for (int k = 0; k < colsA; k++) {
          result[i][j] += a[i][k] * b[k][j];
        }
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
    // 예시 행렬
    int[][] matrixA = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };

    int[][] matrixB = {
        {9, 8, 7},
        {6, 5, 4},
        {3, 2, 1}
    };

    // 행렬 덧셈
    int[][] sum = addMatrix(matrixA, matrixB);
    System.out.println("덧셈 결과:");
    printMatrix(sum);

    // 행렬 뺄셈
    int[][] difference = subtractMatrix(matrixA, matrixB);
    System.out.println("\n뺄셈 결과:");
    printMatrix(difference);

    // 행렬 곱셈
    int[][] product = multiplyMatrix(matrixA, matrixB);
    System.out.println("\n곱셈 결과:");
    printMatrix(product);
  }
}
