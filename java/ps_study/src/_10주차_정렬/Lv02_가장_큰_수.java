package _10주차_정렬;

import java.util.ArrayList;

// https://school.programmers.co.kr/learn/courses/30/lessons/42746
public class Lv02_가장_큰_수 {

  public static void main(String[] args) {
    int[] numbers = {6, 10, 2};
    System.out.println(solution(numbers));
  }

  public static String solution(int[] numbers) {
    ArrayList<String> strNumbers = new ArrayList<>();

    for (int number : numbers) {
      strNumbers.add(Integer.toString(number));
    }

    strNumbers.sort((o1, o2) -> {
      int a = Integer.parseInt(o1 + o2);
      int b = Integer.parseInt(o2 + o1);
      return Integer.compare(b, a);
    });

    StringBuilder sb = new StringBuilder();

    for (String strNumber : strNumbers) {
      sb.append(strNumber);
    }

    if (sb.charAt(0) == '0') {
      return "0";
    }

    return sb.toString();
  }

}
