package 문자열;

import java.util.Scanner;

public class _06_중복문자제거 {
  public String solution1(String str) {
    String answer = "";
    for (int i = 0; i < str.length(); i++) {
      if (str.indexOf(str.charAt(i)) == i) {
        answer += str.charAt(i);
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    _06_중복문자제거 t = new _06_중복문자제거();
    Scanner sc = new Scanner(System.in);
    String str = sc.next();
    System.out.println(t.solution1(str));
  }
}
