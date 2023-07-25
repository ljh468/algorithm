package 스택;

import java.util.Scanner;
import java.util.Stack;

public class _02_괄호문자제거 {
  public String solution1(String str) {
    String answer = "";
    Stack<Character> stack = new Stack<>();
    // 1. 여는괄호, 알파벳은 스택에 저장
    for (char x : str.toCharArray()) {
      // 2. 닫는괄호가 나오면 저장된 스택에서 여는괄호가 나올 때까지 pop
      if (x == ')') {
        while (stack.pop() != '(');
      } else {
        stack.push(x);
      }
    }
    for (int i = 0; i < stack.size(); i++) {
      answer += stack.get(i);
    }
    return answer;
  }

  public static void main(String[] args) {
    _02_괄호문자제거 t = new _02_괄호문자제거();
    Scanner sc = new Scanner(System.in);
    String str = sc.next();
    System.out.print(t.solution1(str));
  }
}
