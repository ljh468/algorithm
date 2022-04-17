public class Solution {
    Position left;
    Position right;
    Position numPos;

    public String solution(int[] numbers, String hand) {
        String answer = "";

        // 1. 왼손, 오른손 위치를 초기화
        left = new Position(3, 0);
        right = new Position(3, 2);

        for (int num : numbers) {
            // 2. 숫자를 누를 손가락 선택
            numPos = new Position((num - 1) / 3, (num - 1) % 3);
            if (num == 0) {
                numPos = new Position(3, 1);
            }
            String finger = numPos.getFinger(hand);
            answer += finger;
            if(finger.equals("L")){
                left = numPos;
            } else{
                right = numPos;
            }
        }
        // 3. answer에 저장
        return answer;
    }
    class Position {
        int row;
        int col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public String getFinger(String hand){
            String finger = (hand.equals("left") ? "L" : "R");
            if(this.col == 0){
                finger = "L";
            } else if(this.col == 2){
                finger = "R";
            } else{
                int leftDist = left.getDistance(this);
                int rightDist= right.getDistance(this);
                
                if(leftDist < rightDist){
                    finger = "L";
                } else if(rightDist < leftDist){
                    finger = "R";
                }
            }
            return finger;
        }
        public int getDistance(Position p) {
            return Math.abs(this.col - p.col) + Math.abs(this.row - p.row);
        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        String result = sol.solution(numbers, hand);
        System.out.println("result = " + result);
    }
}

