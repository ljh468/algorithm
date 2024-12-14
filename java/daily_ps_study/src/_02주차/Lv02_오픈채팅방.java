package _02주차;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://school.programmers.co.kr/learn/courses/30/lessons/42888
public class Lv02_오픈채팅방 {

  public static String[] solution(String[] record) {
    // 1. 유저 닉네임을 저장할 해시맵 선언 (유저 고유아이디 : 닉네임)
    Map<String, String> userMap = new HashMap<>();

    // 2. 유저의 입,퇴장을 기록할 해시맵 선언 (유저 고유아이디 : 입,퇴장)
    List<String> recordList = new ArrayList<>();

    // 3. 레코드 순회
    for (String rec : record) {
      String[] arr = rec.split(" ");
      String option = arr[0];
      String uid = arr[1];
      switch (option) {
        case "Enter" -> {
          // 입장 처리 - 유저 저장, 기존에 있으면 NAME 변경
          userMap.put(uid, arr[2]);
          recordList.add(uid + "님이 들어왔습니다.");
        }
        case "Leave" -> {
          // 퇴장 처리 - 퇴장 기록
          recordList.add(uid + "님이 나갔습니다.");
        }
        case "Change" -> {
          // 변경 처리 - 유저 해시맵 NAME 변경
          userMap.put(uid, arr[2]);
        }
      }
    }

    String[] result = new String[recordList.size()];
    for (int i = 0; i < recordList.size(); i++) {
      String[] arr = recordList.get(i).split("님");
      String name = userMap.get(arr[0]);
      result[i] = name + "님" + arr[1];
    }
    return result;
  }

  public static String[] solution2(String[] record) {
    // Enter/Leave 메시지를 저장할 해시맵 생성
    HashMap<String, String> msg = new HashMap<>();
    msg.put("Enter", "님이 들어왔습니다.");
    msg.put("Leave", "님이 나갔습니다.");

    // 유저 닉네임을 저장할 해시맵 생성
    HashMap<String, String> uid = new HashMap<>();

    // record의 각 줄을 하나씩 처리
    for (String s : record) {
      String[] cmd = s.split(" ");
      // Enter or Change인 경우, 닉네임 변경
      if (cmd.length == 3) {
        uid.put(cmd[1], cmd[2]);
      }
    }

    // 출입기록(정답)을 기록할 리스트 생성
    List<String> answer = new ArrayList<>();

    // record의 각줄을 하나씩 처리
    for (String s : record) {
      String[] cmd = s.split(" ");
      // Enter or Leave인 경우
      if (msg.containsKey(cmd[0])) {
        // 문자열 저장
        answer.add(uid.get(cmd[1]) + msg.get(cmd[0]));
      }
    }

    return answer.toArray(new String[0]);
  }

  public static void main(String[] args) {
    String[] record1 = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};

    String[] results1 = solution(record1);
    for (String str : results1) {
      System.out.println(str);
    }
    System.out.println();

    String[] results2 = solution2(record1);
    for (String str : results2) {
      System.out.println(str);
    }
  }
}
