package 문자열;

import java.util.Scanner;
import java.util.Stack;

public class _08_유효한팰린드롬 {
  public String solution1(String str) {
    String str1 = "";
    String str2 = "";
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < str.length(); i++) {
      if (Character.isAlphabetic(str.charAt(i))) {
        stack.push(str.charAt(i));
        str1 += str.charAt(i);
      }
    }
    while (!stack.isEmpty()) {
      str2 += stack.pop();
    }
    return str1.equals(str2) ? "YES" : "NO";
  }

  public String solution2(String str) {
    String str1 = "";
    for (int i = 0; i < str.length(); i++) {
      if (Character.isAlphabetic(str.charAt(i))) {
        str1 += str.charAt(i);
      }
    }
    String str2 = new StringBuilder(str1).reverse().toString();
    return str1.equalsIgnoreCase(str2) ? "YES" : "NO";
  }

  public String solution3(String str) {
    str = str.toLowerCase().replaceAll("[^A-Z]", "");
    String tmp = new StringBuilder(str).reverse().toString();
    return str.equals(tmp) ? "YES" : "NO";
  }

  public static void main(String[] args) {
    _08_유효한팰린드롬 t = new _08_유효한팰린드롬();
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    System.out.println(t.solution1(str.toLowerCase()));
    System.out.println(t.solution2(str));
    System.out.println(t.solution3(str));

  }
}
