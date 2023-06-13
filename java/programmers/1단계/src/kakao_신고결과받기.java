import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class kakao_신고결과받기 {
    /********************************************************************************************************
     * 내 풀이
     ********************************************************************************************************/
    public int[] solution(String[] id_list, String[] report, int k) {
        // 유저가 받을 결과 메일수 를 저장할 배열
        int[] answer = new int[id_list.length];

        // id당 신고한 인원을 저장할 배열
        Map<String, HashSet<String>> map = new HashMap<>();

        // map은 순서가 없기때문에 id의 인덱스를 설정
        Map<String, Integer> id_Index = new HashMap<>();

        // map초기화
        for (int i = 0; i < id_list.length; i++) {
            String name = id_list[i];
            map.put(name, new HashSet<>());
            id_Index.put(name, i);
        }

        // 신고한사람 저장
        for (String s : report) {
            String[] str = s.split(" ");
            map.get(str[1]).add(str[0]);
        }

        // 이용정지 메일발송
        for (int i = 0; i < id_list.length; i++) {
            // id 키값으로 나를 신고한 인원 send에 저장
            HashSet<String> send = map.get(id_list[i]);

            // 신고한 인원이 k 이상이면 메일 보내기
            if (send.size() >= k) {
                for (String name : send) {
                    answer[id_Index.get(name)]++;
                }
            }
        }
        return answer;
    }

    /********************************************************************************************************
     * Hash를 활용한 객체지향 풀이
     ********************************************************************************************************/
    public int[] solution2(String[] id_list, String[] report, int k) {
        // 유저가 받을 결과 메일수 를 저장할 배열
        int[] answer = new int[id_list.length];
        // 유저의 정보를 저장할 유저객체 리스트
        ArrayList<User> users = new ArrayList<>();
        // <이름 리스트>
        HashMap<String,Integer> suspendedList = new HashMap<>();
        //  <해당 이름의 User의 인덱스>
        HashMap<String,Integer> idIdx = new HashMap<String,Integer>();
        
        // 초기화
        int idx = 0;
        for(String name : id_list) {
            idIdx.put(name,idx++);
            users.add(new User(name));
        }
        // 내가 신고한인원, 나를 신고한인원 저장
        for(String re : report){
            String[] str = re.split(" ");
            users.get(idIdx.get(str[0])).reportList.add(str[1]);
            users.get(idIdx.get(str[1])).reportedList.add(str[0]);
        }
        // 나를 신고한 인원이 k이상이면 이용정지
        for(User user : users){
            if(user.reportedList.size() >= k)
                suspendedList.put(user.name,1);
        }
        // 이용정지 메일발송 (내가 신고한사람이 이용정지 인원이라면 메일발송)
        for(User user : users){
            for(String nameReport : user.reportList){
                if(suspendedList.get(nameReport) != null){
                    answer[idIdx.get(user.name)]++;
                }
            }
        }
        for (User user : users) {
            System.out.println("user = " + user);
        }
        return answer;
    }
    /********************************************************************************************************
     * 모범 풀이
     ********************************************************************************************************/
    public int[] solution3(String[] id_list, String[] report, int k){
        int[] answer = new int[id_list.length];
        // 1. 중복제거
        HashSet<String> reportSet = new HashSet<>();
        for(String rep : report){
            reportSet.add(rep);
        }
        // 2. notifyListHash 만들기
        HashMap<String, ArrayList<String>> notifyListHash = new HashMap<>();
        for(String rep : reportSet){
            String[] re = rep.split(" ");
            String reporter = re[0]; // 신고한사람
            String reportee = re[1]; // 신고당한사람

            ArrayList<String> reporterList = notifyListHash.getOrDefault(reportee, null);
            if(reporterList == null) reporterList = new ArrayList<>();

            reporterList.add(reporter);
            notifyListHash.put(reportee, reporterList);
        }
        // 3. notifyListHash를 기반으로 reporterHash 만들기
        // 신고한사람에게 보내야하는 메일 수 저장
        HashMap<String, Integer> reporterHash = new HashMap();
        for(ArrayList<String> notifyList : notifyListHash.values()){
            if(notifyList.size() >= k)
                for(String reporter : notifyList)
                    reporterHash.put(reporter, reporterHash.getOrDefault(reporter, 0) + 1);
        }
        // 4. reporterHash를 기반으로 answer 배열을 채운다.
        for(int i = 0; i < id_list.length; i++){
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
        kakao_신고결과받기 sol = new kakao_신고결과받기();
//        sol.solution(id_list, report, k);
//        sol.solution2(id_list, report, k);
        sol.solution3(id_list, report, k);
    }
}

/**
 * 유저 객체
 */
class User{
    String name; // 이름
    HashSet<String> reportList; // 내가 신고한 사람 <중복불가 HashSet>
    HashSet<String> reportedList; // 나를 신고한 사람 <중복불가 HashSet>
    public User(String name){
        this.name = name;
        reportList = new HashSet<>();
        reportedList = new HashSet<>();
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", reportList=" + reportList +
                ", reportedList=" + reportedList +
                '}';
    }
}