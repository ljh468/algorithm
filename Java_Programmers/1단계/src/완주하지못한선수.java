import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class 완주하지못한선수 {
    /**
     * Sorting / Loop를 활용한 solution
     * 1. 두 list를 sorting한다
     * 2. completion list의 length만큼 돌려서 participant에만 존재하는 한명을 찾는다.
     * 3. list를 전부 다 뒤져도 답이 없다면, participant의 마지막 주자가 완주하지 못한 선수이다.
     */
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        // 1. 두 배열을 정렬한다.
        Arrays.sort(participant);
        Arrays.sort(completion);

        // 2. 두 배열이 다를 때까지 찾는다.
        int i = 0;
        for(; i < completion.length; i++){
            if(!participant[i].equals(completion[i])){
                break;
            }
        }

        // 3. 여기까지 왔다면, 마지막 주자가 완주하지 못한 선수다.
        return participant[i];
    }

    /**
     * Hash를 활용한 solution
     * 1. Key에 선수의 이름을, Value의 Count를 갖는 HashMap을 만든다.
     * 2. completion에 존재하는 선수들의 Hash를 뺀다.
     * 3. Value가 남아있는 선수가 완주하지 못한 선수이다.
     */
    public String solution2(String[] participant, String[] completion) {
        String answer = "";
        // 1. HashMap을 만든다. (participant)
        HashMap<String, Integer> map = new HashMap<>();
        for (String player : participant) {
            map.put(player, map.getOrDefault(player, 0) + 1);
        }
        // 2. HashMap을 뺀다. (completion)
        for (String player : completion) {
            map.put(player, map.get(player) - 1);
        }
        // 3. Value가 0이 아닌 마지막 주자를 찾느다.
        for (String key : map.keySet()) {
            if (map.get(key) != 0) {
                answer = key;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        완주하지못한선수 sol = new 완주하지못한선수();
        String[] participant = {"mislav", "stanko", "mislav", "ana"}; // 마라톤 참여 인원 이름
        String[] completion = {"stanko", "ana", "mislav"};            // 완주한 선수 이름
        System.out.println(sol.solution(participant, completion));
        System.out.println(sol.solution2(participant, completion));
    }
}
