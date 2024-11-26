package _01주차;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/68645
public class Lv02_삼각달팽이 {

  public static int[] solution(int n) {
    int num = 1; // 증가할 숫
    int[][] matrix = new int[n][n];

    // 삼각형의 좌표 (x, y)
    int x = -1; // x좌표는 시작부터 증가하기 때문에 -1로 시작
    int y = 0;

    // 삼각형 배열에 접근하여 순회
    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        // 아래이동
        if (i % 3 == 0) {
          x++;
        }
        // 오른쪽 이동
        if (i % 3 == 1) {
          y++;
        }
        // 위로 이동
        if (i % 3 == 2) {
          x--;
          y--;
        }
        // 값 채워줌
        matrix[x][y] = num++;
      }
    }

    int[] answer = new int[num - 1];
    int index = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == 0) {
          break;
        }
        answer[index++] = matrix[i][j];
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    int n = 4;
    int[] result = solution(n);
    System.out.println("Arrays.toString(result) = " + Arrays.toString(result));
  }
}
