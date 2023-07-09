package 배열;

import java.util.Scanner;

public class _10_봉우리 {
  public int solution1(int n, int[][] arr) {
    int answer = 0;

    int up = 0;
    int down = 0;
    int left = 0;
    int right = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        up = i - 1;
        down = i + 1;
        left = j - 1;
        right = j + 1;
        boolean result = true;
        if (up >= 0 && arr[i][j] <= arr[up][j]) {
          result = false;
        }
        if (down < n && arr[i][j] <= arr[down][j]) {
          result = false;
        }
        if (left >= 0 && arr[i][j] <= arr[i][left]) {
          result = false;
        }
        if (right < n && arr[i][j] <= arr[i][right]) {
          result = false;
        }
        if (result) {
          answer++;
        }
      }
    }
    return answer;
  }

  int[] dx = {-1, 0, 1, 0};
  int[] dy = {0, 1, 0, -1};
  public int solution2(int n, int[][] arr) {
    int answer = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        boolean flag = true;
        for (int k = 0; k < 4; k++) {
          int nx = i + dx[k];
          int ny = j + dy[k];
          if (nx >= 0 && nx < n && ny >= 0 && ny < n && arr[nx][ny] >= arr[i][j]) {
            flag = false;
            break;
          }
        }
        if (flag) {
          answer++;
        }
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    _10_봉우리 t = new _10_봉우리();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[][] arr = new int[n][n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        arr[i][j] =sc.nextInt();
      }
    }
    System.out.println(t.solution1(n, arr));
    System.out.println(t.solution2(n, arr));
  }
}
