import java.util.HashMap;

public class 완주하지못한선수_연습 {
    /**
     * Hash를 활용한 solution
     * 1. Key에 선수의 이름을, Value의 Count를 갖는 HashMap을 만든다.
     * 2. completion에 존재하는 선수들의 Hash를 뺀다.
     * 3. Value가 남아있는 선수가 완주하지 못한 선수이다.
     */
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        // 1. HashMap을 만든다. (participant)
        HashMap<String, Integer> map = new HashMap<>();
        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        // 2. HashMap을 뺀다. (completion)
        for (String c : completion) {
            map.put(c, map.get(c) - 1);
        }

        // 3. Value가 0이 아닌 마지막 주자를 찾는다.
        for (String key : map.keySet()) {
            if (map.get(key) != 0) {
                return key;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        완주하지못한선수_연습 sol = new 완주하지못한선수_연습();
        String[] participant = {"mislav", "stanko", "mislav", "ana"}; // 마라톤 참여 인원 이름
        String[] completion = {"stanko", "ana", "mislav"};            // 완주한 선수 이름
        System.out.println(sol.solution(participant, completion));
    }
}
