import java.util.*;

public class kakao_실패율_연습 {
    public int[] solution(int n, int[] stages) {
        // 실패율이 높은 stage순으로 저장할 배열 생성
        int[] answer = new int[n];
        // 각 stage의 실패율을 저장할 FailList 생성
        // 총인원을 저장
        // 1. 해당 stage에 머물고 있는 인원을 저장할 user배열
        // 모든 스테이지를 통과하면 마지막 stage +1 배열에 저장됨

        // 2. stages배열에서 스테이지에 머물고 있는 인원을 탐색
            // 스테이지에 도달한 인원이 0이면 실패율은 0
            // 실패율을 구할 수 있는 경우
        // 3. answer배열에 실패율이 높은 순서로 저장
        return answer;
    }
    // 스테이지별 실패율을 저장할 객체 생성
    // Collects.sort의 정렬기준에 사용한 익명객체
       public static void main(String[] args) {
        kakao_실패율_연습 sol = new kakao_실패율_연습();
        int n = 5; // 전체 스테이지의 수
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3}; // 이용하는 사용자가 멈춰있는 스테이지 번호
        int[] solution = sol.solution(n, stages);
//        int[] solution2 = sol.solution2(n, stages);
        System.out.println(Arrays.toString(solution));
//        System.out.println(Arrays.toString(solution2));
    }
}
