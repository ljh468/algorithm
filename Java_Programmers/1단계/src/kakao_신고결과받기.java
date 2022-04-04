import java.util.*;

public class kakao_신고결과받기 {
    /********************************************************************************************************
     * 내 풀이
     ********************************************************************************************************/
    public static int[] solution(String[] id_list, String[] report, int k) {
            int[] answer = new int[id_list.length];
            Map<String, HashSet<String>> map = new HashMap<>();
            Map<String, Integer> index = new HashMap<>();

            // map초기화
            for (int i = 0; i < id_list.length; i++) {
                String name = id_list[i];
                map.put(name, new HashSet<>());
                index.put(name, i);
            }
            // 신고한 사람찾기
            for (String s : report) {
                String[] str = s.split(" ");
                map.get(str[1]).add(str[0]);
            }
            // 이용정지 메일발송
            for (int i = 0; i < id_list.length; i++) {
                HashSet<String> send = map.get(id_list[i]);
                if (send.size() >= k) {
                    for (String name : send) {
                        answer[index.get(name)]++;
                    }
                }
            }
            return answer;
        }

    /********************************************************************************************************
     * 객체지향 풀이
     ********************************************************************************************************/
    public static int[] solution2(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        ArrayList<User> users = new ArrayList<>();
        // <이름>
        HashMap<String,Integer> suspendedList = new HashMap<>();
        //  <이름, 해당 이름의 User 클래스 idx>
        HashMap<String,Integer> idIdx = new HashMap<String,Integer>();
        int idx = 0;

        for(String name : id_list) {
            idIdx.put(name,idx++);
            users.add(new User(name));
        }
        for(String re : report){
            String[] str = re.split(" ");
            users.get( idIdx.get(str[0])).reportList.add(str[1]);
            users.get( idIdx.get(str[1])).reportedList.add(str[0]);
        }
        for(User user : users){
            if(user.reportedList.size() >= k)
                suspendedList.put(user.name,1);
        }
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
     * main
     ********************************************************************************************************/
    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;

        solution(id_list, report, k);
        solution2(id_list, report, k);
    }
}

/**
 * 유저 객체
 */
class User{
    String name; // 이름
    HashSet<String> reportList; // 내가 신고한 사람
    HashSet<String> reportedList; // 나를 신고한 사람
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