package 문자열;

import java.util.Scanner;
import java.util.Stack;

public class _07_회문문자열 {
  public String solution1(String str) {
    String str2 = "";
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < str.length(); i++) {
      stack.push(str.charAt(i));
    }
    while (!stack.isEmpty()) {
      str2 += stack.pop();
    }
    return str.equals(str2) ? "YES" : "NO";
  }

  public String solution2(String str) {
    String tmp = new StringBuilder(str).reverse().toString();
    return str.equalsIgnoreCase(tmp) ? "YES" : "NO";
  }

  public String solution3(String str) {
    int len = str.length();
    for (int i = 0; i < len / 2; i++) {
      if (str.charAt(i) != str.charAt(len - i - 1)) {
        return "NO";
      }
    }
    return "YES";
  }

  public static void main(String[] args) {
    _07_회문문자열 t = new _07_회문문자열();
    Scanner sc = new Scanner(System.in);
    String str = sc.next();
    System.out.println(t.solution1(str.toLowerCase()));
    System.out.println(t.solution2(str.toLowerCase()));
    System.out.println(t.solution3(str.toLowerCase()));
  }
}
