import java.util.Arrays;

/**
 * 행렬의 곱셈 : https://school.programmers.co.kr/learn/courses/30/lessons/12949
 */
public class Lv02_행렬의곱셈 {

  public int[][] solution(int[][] arr1, int[][] arr2) {
    int r1 = arr1.length; // arr1의 행
    int c1 = arr1[0].length; // arr1의 열
    int r2 = arr2.length; // arr2의 행
    int c2 = arr2[0].length; // arr2의 열

    // 행렬을 곱하면 -> arr1(행) * arr2(열)
    int[][] result = new int[r1][c2];

    // 행렬 arr1의 각 행에 대해 반복
    for (int i = 0; i < r1; i++) {
      // 행렬 arr2의 각 열에 대해 반복
      for (int j = 0; j < c2; j++) {
        // 행렬 arr1의 열이자 행렬 arr2의 행에 대해 반복
        for (int k = 0; k < c1; k++) {
          result[i][j] += arr1[i][k] * arr2[k][j];
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[][] arr1 = {{1, 4}, {3, 2}, {4, 1}};
    int[][] arr2 = {{3, 3}, {3, 3}};
    Lv02_행렬의곱셈 lv02_행렬의곱셈 = new Lv02_행렬의곱셈();
    System.out.println("result = " + Arrays.deepToString(lv02_행렬의곱셈.solution(arr1, arr2)));
  }
}
