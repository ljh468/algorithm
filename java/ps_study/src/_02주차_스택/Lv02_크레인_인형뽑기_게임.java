package _02주차_스택;

import java.util.ArrayDeque;

public class Lv02_크레인_인형뽑기_게임 {

  public int solution(int[][] board, int[] moves) {
    int answer = 0;
    ArrayDeque<Integer> stack = new ArrayDeque<>();

    // 1. 크레인 이동 경로 순회
    for (int move : moves) {
      // 2. board에서 뽑을 열 (Index가 0부터 시작하도록 변환)
      int col = move - 1;

      // 3. 해당 열의 인형을 찾음
      for (int row = 0; row < board.length; row++) {
        // 3-1. 인형이 있는경우 처리
        if (board[row][col] != 0) {
          int doll = board[row][col];
          board[row][col] = 0; // 인형을 뽑았으니 해당 자리를 0으로 초기화

          // 3-2. 바구니의 맨 위에 있는 인형과 뽑은 인형이 같으면 제거하고 answer +2 추가
          if (!stack.isEmpty() && stack.peek() == doll) {
            stack.pop();
            answer += 2;
          }
          // 3-3. 바구니가 비어있거나, 다른인형이라면, 인형을 바구니에 넣음
          else {
            stack.push(doll);
          }
          break; // 해당 열에서 인형을 찾았으면 더 이상 탐색할 필요 없음
        }
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    Lv02_크레인_인형뽑기_게임 main = new Lv02_크레인_인형뽑기_게임();
    // 입력값 예시
    int[][] board = {
        {0, 0, 0, 0, 0},
        {0, 0, 1, 0, 3},
        {0, 2, 5, 0, 1},
        {4, 2, 4, 4, 2},
        {3, 5, 1, 3, 1}
    };
    int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};

    // 출력값 예시
    // 4
    System.out.println("result = " + main.solution(board, moves));
  }
}
