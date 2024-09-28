package _06주차_시뮬레이션;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/70129
public class Lv02_이진변환_반복하기 {

  public static int[] solution(String s) {
    // 변환 횟수
    int countTrans = 0;
    // 제거한 0의 개수
    int countZero = 0;

    // 문자열이 "1"이 될 때까지 반복
    while (!s.equals("1")) {
      countTrans++;
      int zero = s.replace("1", "").length(); // 0 개수 세기
      countZero += zero; // 0의 개수 누적
      s = Integer.toBinaryString(s.length() - zero); // 0을 제거한 문자열의 개수를 이진수로 변환
    }

    return new int[]{countTrans, countZero};
  }

  public static void main(String[] args) {
    // 입력값 예시
    // "110010101001"
    String s = "110010101001";

    // 출력값 예시
    // 3, 8
    int[] result = solution(s);
    System.out.println("result = " + Arrays.toString(result));
  }
}
