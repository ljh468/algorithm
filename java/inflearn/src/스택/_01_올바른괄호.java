package 스택;

import java.util.Scanner;
import java.util.Stack;

public class _01_올바른괄호 {
  public String solution1(String str) {
    String answer = "YES";

    // 1. 스택 생성해서 앞괄호 저장
    Stack<Character> stack = new Stack<>();
    for (char x : str.toCharArray()) {
      if (x == '(') {
        stack.push(x);
      } else {
        // 2. 뒷괄호가 나오면 스택에서 앞괄호 제거, 스택에 없으면 NO출력
        if (stack.isEmpty()) {
          return "NO";
        }
        stack.pop();
      }
    }
    if (!stack.isEmpty()) {
      return "NO";
    }

    return answer;
  }

  public static void main(String[] args) {
    _01_올바른괄호 t = new _01_올바른괄호();
    Scanner sc = new Scanner(System.in);
    String str = sc.next();
    System.out.print(t.solution1(str));
  }
}
