package 문자열;

import java.util.Scanner;

/**
 * 한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성
 *
 * teachermode e -> 1 0 1 2 1 0 1 2 2 1 0
 */
public class _10_가장짧은문자거리 {
  public int[] solution1(String s, char t) {
    int[] answer = new int[s.length()];
    int p = 1000;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == t) {
        p = 0;
        answer[i] = p;
      } else {
        p++;
        answer[i] = p;
      }
    }
    p = 1000;
    for (int i = s.length() - 1; i >= 0; i--) {
      if (s.charAt(i) == t) {
        p = 0;
      } else {
        p++;
        answer[i] = Math.min(answer[i], p);
      }
    }
    return answer;
  }
  public static void main(String[] args) {
    _10_가장짧은문자거리 t = new _10_가장짧은문자거리();
    Scanner sc = new Scanner(System.in);
    String str = sc.next();
    char c = sc.next().charAt(0);
    for (int x : t.solution1(str, c)) {
      System.out.print(x + " ");
    }
  }
}
