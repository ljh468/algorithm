package _07주차_해시;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/42888
public class Lv02_오픈채팅방 {

  public static void main(String[] args) {
    String[] record = {
        "Enter uid1234 Muzi",
        "Enter uid4567 Prodo",
        "Leave uid1234",
        "Enter uid1234 Prodo",
        "Change uid4567 Ryan"
    };

    System.out.println("result = " + Arrays.toString(solution(record)));
  }

  public static String[] solution(String[] record) {
    // 1. 입장, 퇴장 문자열 맵 초기화, uid, nickname을 저장할 맵 선언
    Map<String, String> actionMap =  Map.of("Enter", "님이 들어왔습니다.",
                                            "Leave", "님이 나갔습니다.");
    Map<String, String> nicknameMap = new HashMap<>();

    // 2. recod를 순회하면서 입장, 퇴장 기록하고, 닉네임 처리
    List<String> result = new ArrayList<>();
    for (String str : record) {
      String[] split = str.split(" ");
      switch (split[0]) {
        // 입장 기록, 닉네임이 바뀌었으면 갱신
        case "Enter" -> {
          result.add(split[1] + actionMap.get(split[0]));
          nicknameMap.put(split[1], split[2]);
        }
        // 퇴장 기록
        case "Leave" -> result.add(split[1] + actionMap.get(split[0]));
        // 닉네임 변경
        case "Change" -> nicknameMap.put(split[1], split[2]);
      }
    }

    // 3. 문자열 처리 - "님"을 기준으로 uid를 구해서 uid를 최종 닉네임으로 변경해서 출력
    String[] answer = new String[result.size()];
    for (int i = 0; i < answer.length; i++) {
      String str = result.get(i);
      int idx = str.indexOf("님");
      String uid = str.substring(0, idx);
      answer[i] = nicknameMap.get(uid) + str.substring(idx);
    }

    return answer;
  }

  private static String[] solution2(String[] record) {
    HashMap<String, String> nickName = new HashMap<>();
    HashMap<String, String> msg = new HashMap<>();
    msg.put("Enter", "님이 들어왔습니다.");
    msg.put("Leave", "님이 나갔습니다.");

    // 1. record를 순회해서 닉네임이 변경될 수 있는 경우 유저의 닉네임을 갱신 - O(N)
    for (String s : record) {
      String[] split = s.split(" ");
      if (split.length == 3) {
        // 닉네임 갱신 (바뀌면 덮어씌움)
        nickName.put(split[1], split[2]);
      }
    }

    // 2. 한번더 record를 순회해서 최종 닉네임을 대입해서 입장, 퇴장을 기록 - O(N)
    ArrayList<String> answer = new ArrayList<>();
    for (String s : record) {
      String[] split = s.split(" ");
      if (msg.containsKey(split[0])) {
        answer.add(nickName.get(split[1]) + msg.get(split[0]));
      }
    }

    return answer.toArray(new String[0]);
  }
}
