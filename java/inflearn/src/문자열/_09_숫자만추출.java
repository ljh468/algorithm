package 문자열;

import java.util.Scanner;

public class _09_숫자만추출 {
  public int solution1(String str) {
    String answer = "";
    for (int i = 0; i < str.length(); i++) {
      if (Character.isDigit(str.charAt(i))) {
        answer += str.charAt(i);
      }
    }
    return Integer.parseInt(answer);
  }

  public int solution2(String str) {
    int answer = 0;
    for (char ch : str.toCharArray()) {
      if (ch >= 48 && ch <= 57) {
        answer = answer * 10 + (ch - 48);
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    _09_숫자만추출 t = new _09_숫자만추출();
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    System.out.println(t.solution1(str));
    System.out.println(t.solution2(str));
  }
}
