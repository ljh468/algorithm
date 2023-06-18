package 문자열;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class _04_단어뒤집기 {
  public String solution1(String str) {
    String answer = "";
    Stack<String> stack = new Stack();
    for (int i = 0; i < str.length(); i++) {
      stack.add(Character.toString(str.charAt(i)));
    }
    while (!stack.isEmpty()) {
      answer += stack.pop();
    }
    return answer;
  }

  public ArrayList<String> solution2(int count, String[] arr) {
    ArrayList<String> answer = new ArrayList<>();
    for (String x : arr) {
      String tmp = new StringBuilder(x).reverse().toString();
      answer.add(tmp);
    }
    return answer;
  }

  public ArrayList<String> solution3(int count, String[] arr) {
    ArrayList<String> answer = new ArrayList<>();
    for (String x : arr) {
      char[] ch = x.toCharArray();
      int lt = 0;
      int rt = x.length()-1;
      while (lt < rt) {
        char tmp = ch[lt];
        ch[lt] = ch[rt];
        ch[rt] = tmp;
        lt++;
        rt--;
      }
      String tmp = String.valueOf(ch);
      answer.add(tmp);
    }
    return answer;
  }

  public static void main(String[] args) {
    _04_단어뒤집기 t = new _04_단어뒤집기();
    Scanner sc = new Scanner(System.in);
    int count = sc.nextInt();
    String[] arr = new String[count];
    // solution1
    for (int i = 0; i < count; i++) {
      arr[i] = sc.next();
      System.out.println(t.solution1(arr[i]));
    }
    // solution2
    for (String s : t.solution2(count, arr)) {
      System.out.println(s);
    }
    // solution3
    for (String s : t.solution3(count, arr)) {
      System.out.println(s);
    }
  }
}
