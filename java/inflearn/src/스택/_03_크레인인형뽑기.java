package 스택;

import java.util.Scanner;
import java.util.Stack;

// 5
//     0 0 0 0 0
//     0 0 1 0 3
//     0 2 5 0 1
//     4 2 4 4 2
//     3 5 1 3 1
//     8
//     1 5 3 5 1 2 1 4
public class _03_크레인인형뽑기 {

  public int solution1(int[][] board, int[] moves) {
    int answer = 0;
    Stack<Integer> stack = new Stack<>();
    // 1. 크레인 위치에 해당하는 인형을 찾는다. (밑으로 행을 이동하면서 인형 찾기)
    for (int pos : moves) {
      for (int i = 0; i < board.length; i++) {
        // 2. 비어 있지 않은 인형 캐치 (배열의 index는 0부터 시작하기 때문에 -1)
        if (board[i][pos - 1] != 0) {
          // 인형 꺼냄
          int tmp = board[i][pos - 1];
          // board의 인형은 비어줌
          board[i][pos - 1] = 0;
          // 바구니에 겹치는게 있으면 모두 꺼냄
          if (!stack.isEmpty() && (stack.peek() == tmp)) {
            stack.pop();
            answer += 2;
          } else {
            // 아니면 바구니에 인형 담기
            stack.push(tmp);
          }
          // 다음 위치로 이동
          break;
        }
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    _03_크레인인형뽑기 t = new _03_크레인인형뽑기();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[][] board = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        board[i][j] = sc.nextInt();
      }
    }
    int m = sc.nextInt();
    int[] moves = new int[m];
    for (int i = 0; i < m; i++) {
      moves[i] = sc.nextInt();
    }
    System.out.println("1번 : " + t.solution1(board, moves));
  }
}