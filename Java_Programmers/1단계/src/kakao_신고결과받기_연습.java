import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class kakao_신고결과받기_연습 {
    public int[] solution(String[] id_list, String[] report, int k) {
        // 유저가 받을 결과 메일수 를 저장할 배열
        int[] answer = new int[id_list.length];
        // 1. 중복제거
        // 2. notifyListHash 만들기
        // 3. notifyListHash를 기반으로 reporterHash 만들기
        // 4. 신고한사람에게 보내야하는 메일 수 answer배열에 저장
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
    }
}