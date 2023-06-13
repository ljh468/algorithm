package 문자열;

import java.util.Scanner;

public class _01_문자찾기 {
  public int solution(String str, char ch) {
    int answer = 0;
    str = str.toLowerCase();
    ch = Character.toLowerCase(ch);
    System.out.println(str + " " + ch);


    // for (int i = 0; i < str.length(); i++) {
    //   if (str.charAt(i) == ch) {
    //     answer++;
    //   }
    // }

    for (char x : str.toCharArray()) {
      if (x == ch) {
        answer++;
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    _01_문자찾기 T = new _01_문자찾기();
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    char ch = sc.nextLine().charAt(0);
    System.out.println(T.solution(str, ch));
  }
}
