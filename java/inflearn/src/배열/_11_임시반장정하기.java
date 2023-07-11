package 배열;

import java.util.Scanner;

/**
 * 학생 중에서 1학년부터 5학년까지 지내오면서 한번이라도 같은 반이었던 사람이 가장 많은 학생을 임시 반장으로 정하려 한다.
 * 첫 줄에 임시 반장으로 정해진 학생의 번호를 출력한다.
 * 단, 임시 반장이 될 수 있는 학생이 여러 명인 경우에는 그 중 가장 작은 번호만 출력한다.
 *
 * 입력
 * 5
 * 2 3 1 7 3
 * 4 1 9 6 8
 * 5 5 2 4 4
 * 6 5 2 6 7
 * 8 4 2 2 2
 *
 * 출력
 * 4
 */
public class _11_임시반장정하기 {
  public int solution1(int n, int[][] arr) {
    int answer = 0;
    int max = Integer.MIN_VALUE;

    // 본인 학생번호
    for (int i = 0; i < n; i++) {
      int count = 0;
      // 비교 학생번호
      for (int j = 0; j < n; j++) {
        // 학년
        for (int k = 0; k < 5; k++) {
          if (arr[i][k] == arr[j][k]) {
            count++;
            break;
          }
        }
      }
      if (count > max) {
        max = count;
        answer = i+1;
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    _11_임시반장정하기 t = new _11_임시반장정하기();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[][] arr = new int[n][5];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < 5; j++) {
        arr[i][j] =sc.nextInt();
      }
    }
    System.out.println(t.solution1(n, arr));
  }
}
