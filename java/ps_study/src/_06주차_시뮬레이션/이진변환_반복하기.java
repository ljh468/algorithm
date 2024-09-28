package _06주차_시뮬레이션;

import java.util.Arrays;

public class 이진변환_반복하기 {

  public static int[] solution(String s) {
    // answer[0] -> 변환 횟수, answer[1] -> 제거한 0의 개수
    int[] answer = new int[2];

    // 문자열이 "1"이 될 때까지 반복
    while (!s.equals("1")) {
      int originalLength = s.length();
      s = s.replace("0", ""); // 0 제거
      answer[1] += originalLength - s.length(); // 제거한 0의 개수 누적
      s = Integer.toBinaryString(s.length()); // 남은 문자열 길이를 이진수로 변환
      answer[0]++; // 변환 횟수 증가
    }

    return answer;
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
