import java.util.*;

public class kakao_실패율 {
    /****************************************************************************
     * 내 풀이 (Map을 이용한 풀이)
     ****************************************************************************/
    public int[] solution(int n, int[] stages) {
        // 각 statge에 머물러있는 user의 수
        int[] answer = new int[n];

        HashMap<Integer, Double> failMap = new LinkedHashMap<>();
        // 스테이지에 도달한 플레이어의 수
        int endIn = stages.length;

        // stage 1~5까지 확인
        for (int i = 1; i <= n; i++) {
            // 스테이지에 머무는 인원을 저장
            int nextIn = 0;
            // 각 user의 statge를 확인
            for (int stage : stages) {
                if(stage == i){
                    nextIn++;
                }
            }
            if(endIn == 0) {
                failMap.put((i), (double)0);
            } else{
                failMap.put((i), (double) nextIn / endIn);
            }
            endIn -= nextIn;
        }
        System.out.println("failMap = " + failMap);
        List<Map.Entry<Integer, Double>> entryList = new LinkedList<>(failMap.entrySet());
        entryList.sort(new Comparator<Map.Entry<Integer, Double>>() {
            @Override
            public int compare(Map.Entry<Integer, Double> o1, Map.Entry<Integer, Double> o2) {
                    return o2.getValue().compareTo(o1.getValue());
            }
        });
        int cnt = 0;
        for (Map.Entry<Integer, Double> entryKey : entryList) {
            answer[cnt++] = entryKey.getKey();
        }
        return answer;
    }
    /****************************************************************************
     * 클래스를 이용한 풀이
     ****************************************************************************/
    public int[] solution2(int n, int[] stages) {
        int[] answer = new int[n];
        // 각 stage의 실패율을 저장할 FailList 생성
        List<Fail> fails = new ArrayList<>();
        // 전체 사용자 수
        int total = stages.length;

        // 각 현재 스테이지에 머물러있는 인원수 ( index는 stage번호, value는 도달한 인원수)
        // 현재 스테이지를 클리어하지 못한 수
        int[] users = new int[n + 1];
        for(int s : stages)
            users[s-1]++; // index 0은 stage 1로 매핑
        
        // stages 배열을 확인하며 실패율을 구함
        for (int i = 0; i < n; i++) {
            // 스테이지에 도달한 인원이 0이면 실패율은 0
            if(users[i] == 0)
                fails.add(new Fail(i + 1, 0));
            // 실패율을 구할 수 있는 경우
            else{
                fails.add(new Fail(i + 1, (double) users[i] / total));
                total -= users[i];
            }
        }
        // 실패율에 따른 정렬
        Collections.sort(fails, comp);
        for (int i = 0; i < n; i++) {
            answer[i] = fails.get(i).stage;
        }

        return answer;
    }
    class Fail{
        // 인스턴스 변수
        int stage;
        double rate;
        // 생성자
        Fail(int stage, double rate){
            this.stage = stage;
            this.rate = rate;
        }
    }
    // Comparator객체를 생성 (정렬을 위한)
    Comparator<Fail> comp = new Comparator<Fail>() {
        @Override
        public int compare(Fail a, Fail b) {
            // 실패율이 큰게 앞으로 와야함
            if (a.rate < b.rate) {
                return 1;
            } else if (a.rate > b.rate) {
                return -1;
            }
            // 실패율이 같다면 stage가 작은게 앞으로
            else{
                if(a.stage > b.stage)
                    return 1;
                else if(a.stage < b.stage)
                    return -1 ;
                else
                    return 0;
            }
        }
    };

    public static void main(String[] args) {
        kakao_실패율 sol = new kakao_실패율();
        int n = 5; // 전체 스테이지의 수
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3}; // 이용하는 사용자가 멈춰있는 스테이지 번호
        int[] solution = sol.solution(n, stages);
        int[] solution2 = sol.solution2(n, stages);
        System.out.println(Arrays.toString(solution));
        System.out.println(Arrays.toString(solution2));
    }
}
