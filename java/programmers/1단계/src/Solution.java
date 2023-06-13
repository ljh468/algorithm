public class Solution {
    Position left;
    Position right;
    Position numPos;
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        // 1. 손가락 위치 초기화
        left = new Position(3, 0);
        right = new Position(3, 2);
        
        // 2. 숫자를 누른 손가락 위치 정하기
        for (int num : numbers) {
            // 현재 위치
            numPos = new Position((num - 1) / 3, (num - 1) % 3);
            if(num == 0) numPos = new Position(3, 1);
            
            String finger = numPos.getFinger(hand);
            answer += finger;
            // 마지막으로 누른 손가락위치 이동
            if(finger.equals("L")) left = numPos;
            else right = numPos;
        }
        return answer;
    }
    class Position{
        int row;
        int col;
        public Position(int row, int col){
            this.row = row;
            this.col = col;
        }
        public String getFinger(String hand){
            // 주 손 설정
            String finger = (hand.equals("right") ? "R" : "L");
            if(this.col == 0) finger = "L";
            else if(this.col == 2) finger = "R";
            else{
                int leftDist = left.getDistance(numPos);
                int rightDist = right.getDistance(numPos);
                if(leftDist < rightDist) finger = "L";
                else if(rightDist < leftDist) finger = "R";
            }
            return finger;
        }
        public int getDistance(Position p) {
            return Math.abs(this.row - p.row) + Math.abs(this.col - p.col);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        System.out.println(sol.solution(numbers, hand));
    }
}

