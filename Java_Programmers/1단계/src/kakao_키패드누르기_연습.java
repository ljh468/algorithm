public class kakao_키패드누르기_연습 {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        // 1. 왼손 오른손 위치를 초기화
        // 2. 숫자를 누를 손가락 정하기
        // 3. 정해진 손가락을 answer에 담고 손가락 위치 이동
        return answer;
    }
    public static void main(String[] args) {
        kakao_키패드누르기_연습 sol = new kakao_키패드누르기_연습();
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        System.out.println(sol.solution(numbers, hand));
    }
}
