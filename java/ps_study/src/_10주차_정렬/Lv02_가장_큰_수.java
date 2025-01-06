package _10주차_정렬;

import java.util.ArrayList;

// https://school.programmers.co.kr/learn/courses/30/lessons/42746
public class Lv02_가장_큰_수 {

  public static void main(String[] args) {
    int[] numbers1 = {6, 65, 2};
    System.out.println("result1 = " + solution(numbers1));

    int[] numbers2 = {0, 0, 0};
    System.out.println("result2 = " + solution(numbers2));
  }

  public static String solution(int[] numbers) {
    // 1. 문자열로 처리하기 위해 리스트 생성
    ArrayList<String> strNumbers = new ArrayList<>();
    for (int number : numbers) {
      strNumbers.add(String.valueOf(number));
    }

    strNumbers.sort((o1, o2) -> {
      // 2. 두수를 이어붙혀서 비교
      int a = Integer.parseInt(o1 + o2);
      int b = Integer.parseInt(o2 + o1);
      return Integer.compare(b, a); // 내림차순
    });

    // 3. 정렬된 순서대로 출력
    StringBuilder sb = new StringBuilder();
    for (String strNumber : strNumbers) {
      sb.append(strNumber);
    }
    // 0만 여러개 들어오는 경우에는 0으로 리턴
    if (sb.charAt(0) == '0') {
      return "0";
    }
    return sb.toString();
  }

}
