package 문자열;

import java.util.Scanner;

public class _02_대소문자_변환 {
  public String solution(String str) {
    String answer = "";

    // for (char ch : str.toCharArray()) {
    //   if (Character.isLowerCase(ch)) {
    //     answer += Character.toUpperCase(ch);
    //   } else {
    //     answer += Character.toLowerCase(ch);
    //   }
    // }

    // 대문자 65 ~ 90
    // 소문자 97 ~ 122
    for (char ch : str.toCharArray()) {
      if (65 <= ch && ch<= 90) {
        answer += (char)(ch + 32);
      } else {
        answer += (char)(ch - 32);
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    _02_대소문자_변환 t = new _02_대소문자_변환();
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();

    System.out.println(t.solution(str));
  }
}
