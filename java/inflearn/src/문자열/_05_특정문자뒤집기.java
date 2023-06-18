package 문자열;

import java.util.Scanner;

public class _05_특정문자뒤집기 {
  public String solution1(String str) {
    String answer = "";
    char[] ch = str.toCharArray();

    int down = 0;
    int top = str.length() - 1;
    while (down < top) {
      if (!Character.isAlphabetic(ch[down])) {
        down++;
      } else if (!Character.isAlphabetic(ch[top])) {
        top--;
      } else {
        char tmp = ch[down];
        ch[down] = ch[top];
        ch[top] = tmp;
        down++;
        top--;
      }
    }
    answer = String.valueOf(ch);
    return answer;
  }

  public static void main(String[] args) {
    _05_특정문자뒤집기 t = new _05_특정문자뒤집기();
    Scanner sc = new Scanner(System.in);
    String str = sc.next();
    System.out.println(t.solution1(str));
  }
}
