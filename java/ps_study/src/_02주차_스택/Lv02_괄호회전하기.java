package _02주차_스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Stack;

public class Lv02_괄호회전하기 {

  // 내 풀이
  public int solution(String str) {
    int answer = 0;
    int n = str.length();

    // 1. StringBuilder를 사용하여 문자열 회전 처리
    StringBuilder sb = new StringBuilder(str);
    for (int i = 0; i < n; i++) {
      // 1-1. 올바른괄호 문자열이면 경우의 수 증가
      if (isCorrectParentheses(sb.toString())) {
        answer++;
      }
      // 1-2. 문자열 회전: 첫 문자 제거하고 마지막에 추가
      sb.append(sb.charAt(0));
      sb.deleteCharAt(0);
    }

    return answer;
  }

  // 올바른 괄호인지 확인하는 메서드
  public boolean isCorrectParentheses(String str) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < str.length(); i++) {
      char current = str.charAt(i);
      // 여는괄호면 스택에 추가
      if (current == '(' || current == '{' || current == '[') {
        stack.push(current);
      } else {
        // 닫는괄호인데, 스택이 비어있거나, 짝이 맞지 않으면 false를 리턴
        if (stack.isEmpty()) return false;
        char top = stack.pop();
        if ((current == ')' && top != '(') ||
            (current == '}' && top != '{') ||
            (current == ']' && top != '[')) {
          return false;
        }
      }
    }
    // 모든 문자열을 순회했는데, 스택이 비어있으면 올바른 괄호
    return stack.isEmpty();
  }

  // 저자의 정답풀이
  public int solution2(String s) {

    // 1. 괄호짝 해시맵에 저장 (닫는괄호를 key값으로)
    HashMap<Character, Character> map = new HashMap<>();
    map.put(')', '(');
    map.put('}', '{');
    map.put(']', '[');

    int len = s.length(); // 원본 문자열길이 저장
    s += s; // 문자열을 회전하기위해 문자열을 중복으로 이어붙임

    // 2. 회전된 문자열이 올바른괄호인지 확인
    int answer = 0;
    A:
    for (int i = 0; i < len; i++) {
      // 2-1. 여는 괄호를 저장할 스택 선언
      ArrayDeque<Character> stack = new ArrayDeque<>();
      // 3. i(시작 위치)부터 i + 원본 문자열의 길이(len)까지의 문자열이 올바른 괄호인지 확인
      for (int j = i; j < i + len; j++) {
        char ch = s.charAt(j);
        // 3-1. 해시맵안에 해당 키가 없으면 열린괄호 임
        if (!map.containsKey(ch)) {
          stack.push(ch); // 열린괄호는 스택에 추가
        }
        // 3-2. 닫힌괄호일때, 짝이 맞지않으면 내부for문 종료하고, A 반복문으로 이동
        else {
          if (stack.isEmpty() || !stack.pop().equals(map.get(ch))) {
            continue A;
          }
        }
      }
      // 2-2. 문자열을 모두 순회하고, stack이 비어있으면 올바른 괄호이므로 answer 증가
      if (stack.isEmpty()) answer++;
    }

    return answer;
  }

  public static void main(String[] args) throws IOException {
    Lv02_괄호회전하기 main = new Lv02_괄호회전하기();

    // 입력값 예시
    // "}]()[{"
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();

    // 2
    System.out.println(main.solution(str));
    System.out.println(main.solution2(str));
  }
}
