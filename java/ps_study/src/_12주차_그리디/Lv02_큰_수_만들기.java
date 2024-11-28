package _12주차_그리디;

import java.util.ArrayDeque;

// https://school.programmers.co.kr/learn/courses/30/lessons/42883
public class Lv02_큰_수_만들기 {

  public static String solution(String number, int k) {
    // 스택을 사용하여 가장 큰 숫자를 결정
    ArrayDeque<Character> stack = new ArrayDeque<>();
    int length = number.length();

    for (int i = 0; i < length; i++) {
      char current = number.charAt(i);

      // 스택의 마지막 요소가 현재 숫자보다 작고, k를 줄일 수 있는 경우
      while (!stack.isEmpty() && k > 0 && stack.getLast() < current) {
        stack.removeLast();
        k--;
      }

      // 현재 숫자를 스택에 추가
      stack.addLast(current);
    }

    // 아직 제거해야 할 숫자가 남아있다면 뒤에서 제거
    while (k > 0) {
      stack.removeLast();
      k--;
    }

    // 스택을 문자열로 변환
    StringBuilder result = new StringBuilder();
    for (char c : stack) {
      result.append(c);
    }

    return result.toString();
  }

  public static void main(String[] args) {
    System.out.println(solution("1924", 2));       // 출력: "94"
    System.out.println(solution("1231234", 3));    // 출력: "3234"
    System.out.println(solution("4177252841", 4)); // 출력: "775841"
  }
}
