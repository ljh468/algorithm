package _02주차;

import java.util.HashMap;
import java.util.Map;

// https://school.programmers.co.kr/learn/courses/30/lessons/131127
public class Lv02_할인행사 {

  public static int solution(String[] want, int[] number, String[] discount) {
    int answer = 0;
    // 1. 내가 사려고 하는 품목과 품목의 개수를 해시맵으로 초기화
    Map<String, Integer> wantMap = new HashMap<>();
    for (int i = 0; i < want.length; i++) {
      wantMap.put(want[i], number[i]);
    }

    // 2. N일차에 회원가입하면 원하는 제품을 모두 할인 받을 수 있는 확인
    //    10일 동안 회원 자격이 부여되므로 시작일은 (0 ~ 10일전만 가능)
    for (int i = 0; i < discount.length - 9; i++) {
      // 2-1. 10일간 살수 있는 품목과 개수를 해시맵으로 초기화
      Map<String, Integer> discountMap = new HashMap<>();
      for (int j = i; j < i + 10; j++) {
        discountMap.put(discount[j], discountMap.getOrDefault(discount[j], 0) + 1);
      }

      // 2-2. 구매할 수 있는 상품 Map 과 원하는 상품 Map 이 같으면 가입 가능일자 증가
      if (discountMap.equals(wantMap)) {
        answer++;
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    String[] want = {"banana", "apple", "rice", "pork", "pot"};
    int[] number = {3, 2, 2, 2, 1};
    String[] discount = {
        "chicken", "apple", "apple", "banana", "rice",
        "apple", "pork", "banana", "pork", "rice",
        "pot", "banana", "apple", "banana"
    };

    int result = solution(want, number, discount);
    System.out.println("result = " + result);
  }
}
