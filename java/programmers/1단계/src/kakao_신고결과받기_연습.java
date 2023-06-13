import java.util.*;

public class kakao_신고결과받기_연습 {
    public int[] solution(String[] id_list, String[] report, int k) {
        // 유저가 받을 결과 메일수 를 저장할 배열
        int[] answer = new int[id_list.length];
        // 1. 중복제거
        HashSet<String> reportSet = new HashSet<>();
        reportSet.addAll(Arrays.asList(report));
        // 2. 각 유저에 내가 신고한사람과 나를 신고한사람을 저장할 notifyListHash 만들기
        HashMap<String, ArrayList<String>> notifyListHash = new HashMap<>();
        for (String rep : reportSet) {
            String[] re = rep.split(" ");
            String reporter = re[0]; // 신고한 사람
            String reportee = re[1]; // 신고당한 사람

            // 각 유저에 대해 이전에 신고한사람을 불러옴 (없으면 새로 생성)
            ArrayList<String> reporterList = notifyListHash.getOrDefault(reportee, null);
            if(reporterList == null) reporterList = new ArrayList<>();

            // 신고한 사람 추가
            reporterList.add(reporter);
            notifyListHash.put(reportee, reporterList);
        }
        // 3. 신고한 사람에게 보내야할 메일 수를 저장할 변수 reporterHash 만들기
        HashMap<String, Integer> reporterHash = new HashMap<>();
        for (ArrayList<String> notifyList : notifyListHash.values()) {
            // 신고횟수를 넘으면 신고한 사람에게 보낼 메일 횟수 저장
            if (notifyList.size() >= k) {
                for (String reporter : notifyList) {
                    // 기존횟수에 1씩 추가
                    reporterHash.put(reporter, reporterHash.getOrDefault(reporter, 0) + 1);
                }
            }
        }
        // 4. 신고한사람에게 보내야하는 메일 수 answer배열에 저장
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = reporterHash.getOrDefault(id_list[i], 0);
        }
        return answer;
    }
    /********************************************************************************************************
     * main
     ********************************************************************************************************/
    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        kakao_신고결과받기_연습 sol = new kakao_신고결과받기_연습();
        System.out.println(Arrays.toString(sol.solution(id_list, report, k)));
    }
}