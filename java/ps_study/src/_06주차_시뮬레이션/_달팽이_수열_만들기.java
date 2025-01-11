package _06주차_시뮬레이션;

import java.util.Arrays;

public class _달팽이_수열_만들기 {

  public static int[][] solution(int n) {
    // 숫자를 저장할 배열 생성
    int[][] snailArr = new int[n][n];
    // 달팽이 수열 시작 숫자
    int num = 1;

    // 행과 열의 시작과 끝 인덱스를 설정
    int startRow = 0, endRow = n - 1;
    int startCol = 0, endCol = n - 1;

    // 달팽이 수열 채우기
    while (startRow <= endRow && startCol <= endCol) {

      // 1. 값이 채워지지 않은 행 중 첫번째 행에서 오른쪽 방향으로 값을 채움
      for (int i = startCol; i <= endCol; i++) {
        snailArr[startRow][i] = num++;
      }
      startRow++;

      // 2. 값이 채워지지 않은 열 중 가장 마지막 열에서 아래방향으로 값을 채움
      for (int i = startRow; i <= endRow; i++) {
        snailArr[i][endCol] = num++;
      }
      endCol--;

      // 3. 마지막 행 값을 왼쪽방향으로 채움
      if (startRow <= endRow) {
        for (int i = endCol; i >= startCol; i--) {
          snailArr[endRow][i] = num++;
        }
        endRow--;
      }

      // 4. 첫번째 열의 값을 아래에서 위로 채움
      if (startCol <= endCol) {
        for (int i = endRow; i >= startRow; i--) {
          snailArr[i][startCol] = num++;
        }
        startCol++;
      }

    }

    return snailArr;
  }

  public static void main(String[] args) {
    // 입력값 예시
    // 4
    int n = 4;

    /*
     * 출력값 예시
     * 1, 2, 3, 4
     * 12, 13, 14, 5
     * 11, 16, 15, 6
     * 10, 9, 8, 7
     */
    int[][] result = solution(n);
    for (int[] r : result) {
      System.out.println(Arrays.toString(r));
    }

  }
}
