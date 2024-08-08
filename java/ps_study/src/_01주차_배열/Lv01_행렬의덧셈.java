package _01주차_배열;

import java.util.Arrays;

/**
 * 행렬의 덧셈 : https://school.programmers.co.kr/learn/courses/30/lessons/12950
 */
public class Lv01_행렬의덧셈 {

  public int[][] solution(int[][] arr1, int[][] arr2) {
    int row = arr1.length;
    int col = arr1[0].length;
    int[][] answer = new int[row][col];

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        answer[i][j] = arr1[i][j] + arr2[i][j];
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    // 입력예시 :
    int[][] arr1 = {{1, 2}, {2, 3}};
    int[][] arr2 = {{3, 4}, {5, 6}};

    Lv01_행렬의덧셈 main = new Lv01_행렬의덧셈();
    // 결과 : [[4, 6], [7, 9]]
    System.out.println("result = " + Arrays.deepToString(main.solution(arr1, arr2)));

  }
}