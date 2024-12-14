package _02주차;

import java.util.HashMap;

// https://school.programmers.co.kr/learn/courses/30/lessons/42578
public class Lv02_의상 {

  public static int solution(String[][] clothes) {
    // 1. 옷을 종류별로 구분 (의상종류 : 개수)
    HashMap<String, Integer> wearMap = new HashMap<>();
    for (String[] wear : clothes) {
      wearMap.put(wear[1], wearMap.getOrDefault(wear[1], 0) + 1);
    }

    // 2. 입지 않는 경우를 추가해서 모든 조합을 계산
    int answer = 1;
    for (Integer count : wearMap.values()) {
      answer *= count + 1; // 입지 않는 경우 추가
    }

    // 3. 옷을 아무것도 입지 않은 경우를 제외하고 리턴
    return answer - 1;
  }

  public static void main(String[] args) {
    String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
    String[][] clothes2 = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};

    int result = solution(clothes);
    int result2 = solution(clothes2);
    System.out.println("result = " + result);
    System.out.println("result2 = " + result2);

  }
}
