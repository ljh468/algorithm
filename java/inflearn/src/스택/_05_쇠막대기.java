package 스택;

import java.util.Scanner;
import java.util.Stack;

public class _05_쇠막대기 {

  public int solution1(String str) {
    int answer = 0;
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < str.length(); i++) {
      // 여는 괄호 스택에 추가
      if (str.charAt(i) == '(') {
        stack.push(str.charAt(i));
      } else {
        // 닫는괄호이면 스택에서 여는괄호 제거
        stack.pop();
        // 레이져이면 잘린 파이프 개수 추가
        if (str.charAt(i - 1) == '(') {
          answer += stack.size();
        } else {
          // 레이져가 아니고 막대기의 끝이면 파이프 1개 추가
          answer++;
        }
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    _05_쇠막대기 t = new _05_쇠막대기();
    Scanner sc = new Scanner(System.in);
    String str = sc.next();
    System.out.println(t.solution1(str));
  }
}
