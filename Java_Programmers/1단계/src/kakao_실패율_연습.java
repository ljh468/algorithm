import java.util.*;

public class kakao_실패율_연습 {
    public int[] solution(int n, int[] stages) {
        // 실패율이 높은 stage순으로 저장할 배열 생성
        int[] answer = new int[n];
        // 각 stage의 실패율을 저장할 FailList 생성
        List<Fail> fails = new ArrayList<>();
        // 총인원을 저장
        int total = stages.length;

        // 1. 해당 stage에 머물고 있는 인원을 저장할 user배열
        // 모든 스테이지를 통과하면 마지막 stage +1 배열에 저장됨
        int[] user = new int[n + 1];
        for(int s : stages)
            user[s-1]++; // index 0은 stage 1로 매핑

        // 2. stages배열에서 스테이지에 머물고 있는 인원을 탐색
        for (int i = 1; i < n + 1; i++) {
            // 스테이지에 도달한 인원이 0이면 실패율은 0
            if (user[i - 1] == 0) {
                fails.add(new Fail(i, (double) 0));
            }
            // 실패율을 구할 수 있는 경우
            else{
                fails.add(new Fail(i, (double) user[i - 1] / total));
            }
            total -= user[i-1];
        }
        Collections.sort(fails, comp);
        // 3. answer배열에 실패율이 높은 순서로 저장
        for (int i = 0; i < n; i++) {
            answer[i] = fails.get(i).stage;
        }
        return answer;
    }
    // 스테이지별 실패율을 저장할 객체 생성
    class Fail{
        int stage;
        double rate;

        public Fail(int stage, double rate){
            this.stage = stage;
            this.rate = rate;
        }
    }
    // Collects.sort의 정렬기준에 사용한 익명객체
    Comparator<Fail> comp = new Comparator<Fail>() {
        @Override
        public int compare(Fail o1, Fail o2) {
            if(o1.rate < o2.rate) return 1;
            else if(o1.rate > o2.rate) return -1;
            else return o1.stage - o2.stage;
        }
    };
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
