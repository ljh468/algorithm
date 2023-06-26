package 문자열;

import java.util.Scanner;

public class _12_암호 {
  public String solution1(int n, String str) {
    String answer = "";
    for (int i = 0; i < n; i++) {
      String tmp = str.substring(0, 7).replace('#', '1').replace('*', '0');
      int num = Integer.parseInt(tmp, 2);
      answer += (char) num;
      str = str.substring(7);
    }
    return answer;
  }

  public static void main(String[] args) {
    _12_암호 t = new _12_암호();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    String str = sc.next();
    System.out.println(t.solution1(n, str));
  }
}
