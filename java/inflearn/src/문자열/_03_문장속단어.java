package 문자열;

import java.util.Scanner;

public class _03_문장속단어 {
  public String solution(String str) {
    String answer = "";

    int m = Integer.MIN_VALUE;
    String[] s = str.split(" ");
    for (String x : s) {
      int len = x.length();
      if (len > m) {
        m = len;
        answer = x;
      }
    }

    // int m = Integer.MIN_VALUE;
    // int pos = Integer.MIN_VALUE;
    // while ((pos = str.indexOf(' ')) != -1) {
    //   String temp = str.substring(0, pos);
    //   int len = temp.length();
    //   if (len > m) {
    //     m = len;
    //     answer = temp;
    //   }
    //   str = str.substring(pos + 1);
    // }
    // if (str.length() > m) {
    //   answer = str;
    // }
    return answer;
  }

  public static void main(String[] args) {
    _03_문장속단어 t = new _03_문장속단어();
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    System.out.println(t.solution(str));
  }
}
