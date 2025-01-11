package _05주차_백트래킹;

public class _NQueen01 {

  // 퀸의 개수 (보드의 크기)
  private static int N;

  // 퀸의 위치 좌표를 나타냄 (인덱스는 행을, 값은 열)
  private static int[] board;

  // 보드의 현재 상태를 출력하는 함수
  public static void printBoard() {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        // 보드의 값은 퀸의 열 위치를 나타냄
        if (board[i] == j) {
          System.out.print("Q ");
        } else {
          System.out.print(". ");
        }
      }
      System.out.println();
    }
    System.out.println();
  }

  // 현재 위치에 퀸을 놓아도 되는지 확인하는 유망함수
  public static boolean isSafe(int row, int col) {
    for (int i = 0; i < row; i++) {
      // 1. 각 행의 동일한 열에 퀸이 배치 되는지 확인
      if (board[i] == col) {
        return false;
      }
      // 2. 각 행의 퀸들이 대각선 방향에 겹치는지 확인
      // 같은 대각선상에 있다는 것은 행 인덱스의 변화와 열 인덱스의 변화가 같다는 것
      if (Math.abs(board[i] - col) == Math.abs(i - row)) {
        return false;
      }
    }
    return true;
  }

  // N Queen 문제를 해결하기 위한 재귀 함수 (row는 퀸의 개수이기도 함)
  public static void checkNQueens(int row, _NumberOfCases numberOfCases) {
    // 모든 행에 퀸을 배치한 경우 (기저 조건)
    if (row == N) {
      numberOfCases.increase();
      printBoard();
      return;
    }

    // 현재 행의 모든 열에 대해 반복
    for (int col = 0; col < N; col++) {
      // 현재 위치에 퀸을 놓을 수 있는지 확인 (유망함수)
      if (isSafe(row, col)) {
        board[row] = col; // 현재 행의 열에 퀸을 놓음
        checkNQueens(row + 1, numberOfCases); // 다음 행에 대해 재귀 호출
        // 퀸을 제거할 필요 없음, 다음 반복에서 덮어쓰기 때문에
      }
    }
  }

  public static void main(String[] args) {
    // 입력값 예시:
    // 4
    N = 4;

    board = new int[N]; // 보드 초기화
    for (int i = 0; i < N; i++) {
      board[i] = -1; // 초기화 시 모든 열 값 -1로 설정
    }

    _NumberOfCases numberOfCases = new _NumberOfCases(); // 해결책 수를 저장할 배열
    checkNQueens(0, numberOfCases); // 첫 번째 행부터 시작
    System.out.println(numberOfCases.getCount());
  }
}

