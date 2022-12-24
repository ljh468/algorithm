import java.util.Stack;

public class kakao_크레인인형뽑기게임_연습 {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        // 1. 뽑은 인형을 저장한 스택 선언
        Stack<Integer> bucket = new Stack();

        // 2. 크레인 이동의 index는 -1을 해야함
        for (Integer index : moves) {
            index -= 1;

        // 3. 스택의 마지막에 쌓인 인형과 뽑은 인형이 같으면 answer를 올려주고 제거
            for (int i = 0; i < board.length; i++) {
                if(!bucket.isEmpty() && (bucket.peek().equals(board[i][index]))) {
                    board[i][index] = 0;
                    bucket.pop();
                    answer += 2;
                    break;
                }
                // 4. 크레인이 이동하여 뽑은 자리를 0으로 초기화하고 스택에 넣음
                else if(board[i][index] != 0){
                    bucket.push(board[i][index]);
                    board[i][index] = 0;
                    break;
                }
            }
         }
        return answer;
    }
    public static void main(String[] args) {
        kakao_크레인인형뽑기게임_연습 sol = new kakao_크레인인형뽑기게임_연습();
        int[][] board = {{0,0,0,0,0},
                         {0,0,1,0,3},
                         {0,2,5,0,1},
                         {4,2,4,4,2},
                         {3,5,1,3,1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        System.out.println(sol.solution(board, moves));
    }
}
