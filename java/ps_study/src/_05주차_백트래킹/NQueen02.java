package _05주차_백트래킹;

public class NQueen02 {

  // 각 열(column), '/' 방향 대각선, '\' 방향 대각선의 퀸 위치를 추적하는 배열
  static boolean[] isUsed1 = new boolean[40]; // 열에 퀸이 있는지 여부 체크

  static boolean[] isUsed2 = new boolean[40]; // '/' 방향 대각선에 퀸이 있는지 여부 체크

  static boolean[] isUsed3 = new boolean[40]; // '\' 방향 대각선에 퀸이 있는지 여부 체크

  static int count = 0; // 가능한 배치 수

  static int n; // 퀸을 배치할 보드의 크기

  // 현재 cur 번째 행(row)에 퀸을 배치하는 함수
  public static void solveNQueens(int cur) {
    if (cur == n) { // 퀸을 모두 배치한 경우
      count++;
      return;
    }

    // 현재 행의 모든 열을 검사하며 퀸을 배치할 수 있는지 확인
    for (int col = 0; col < n; col++) {
      // 열 또는 대각선에 퀸이 있으면 건너뜀
      if (isUsed1[col] || isUsed2[col + cur] || isUsed3[cur - col + n - 1]) continue;

      // 퀸을 배치할 수 있으면 배열에 상태 업데이트
      isUsed1[col] = isUsed2[col + cur] = isUsed3[cur - col + n - 1] = true;

      // 다음 행으로 넘어가서 퀸 배치
      solveNQueens(cur + 1);

      // 백트래킹: 퀸을 제거하고 다음 위치 검사
      isUsed1[col] = isUsed2[col + cur] = isUsed3[cur - col + n - 1] = false;
    }
  }

  public static void main(String[] args) {
    // 입력값 예시 :
    // 4
    n = 4;
    solveNQueens(0);
    System.out.println("가능한 배치 수: " + count);
  }
}