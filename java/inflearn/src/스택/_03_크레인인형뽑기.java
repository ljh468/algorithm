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
    for (int pos : moves) {
      for (int i = 0; i < board.length; i++) {
        if (board[i][pos - 1] != 0) {
          int tmp = board[i][pos - 1];
          board[i][pos-1] = 0;
          if (!stack.isEmpty() && (stack.peek() == tmp)) {
            stack.pop();
            answer += 2;
          } else {
            stack.push(tmp);
          }
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
    System.out.println(t.solution1(board, moves));
  }
}
