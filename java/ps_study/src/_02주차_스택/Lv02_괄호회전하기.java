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

    // StringBuilder를 사용하여 문자열 회전 처리
    StringBuilder sb = new StringBuilder(str);
    for (int i = 0; i < n; i++) {
      if (isCorrectParentheses(sb.toString())) {
        answer++;
      }
      // 문자열 회전: 첫 문자 제거하고 마지막에 추가
      sb.append(sb.charAt(0));
      sb.deleteCharAt(0);
    }

    return answer;
  }

  public boolean isCorrectParentheses(String str) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < str.length(); i++) {
      char current = str.charAt(i);
      if (current == '(' || current == '{' || current == '[') {
        stack.push(current);
      } else {
        // 짝이 맞지 않으면, false를 리턴
        if (stack.isEmpty()) return false;
        char top = stack.pop();
        if ((current == ')' && top != '(') ||
            (current == '}' && top != '{') ||
            (current == ']' && top != '[')) {
          return false;
        }
      }
    }
    return stack.isEmpty();
  }

  // 저자의 풀이
  public int solution2(String s) {
    // 1. 괄호 정보를 저장함. 코드를 간결하게 할 수 있음
    HashMap<Character, Character> map = new HashMap<>();
    map.put(')', '(');
    map.put('}', '{');
    map.put(']', '[');

    int n = s.length(); // 원본 문자열의 길이 저장
    s += s; // 원본 문자열 뒤에 원본 문자열을 이어 붙여서 2번 나오도록 만들어줌

    int answer = 0;

    // 2. 확인할 문자열의 시작 인덱스를 0 부터 n 까지 이동
    A:for (int i = 0; i < n; i++) {
      ArrayDeque<Character> stack = new ArrayDeque<>();

      // 3. i(시작 위치)부터 원본 문자열의 길이인 n개까지 올바른 괄호 문자열인지 확인
      for (int j = i; j < i + n; j++) {
        char c = s.charAt(j);
        // HashMap 안에 해당 key 가 없다면 열리는 괄호임
        if (!map.containsKey(c)) {
          stack.push(c);
        }
        else {
          // 4. 짝이 맞지 않으면 내부 for문은 종료하고 for문 A로 이동
          if(stack.isEmpty() || !stack.pop().equals(map.get(c)))
            continue A;
        }
      }

      // 5. 3에서 continue 되지 않았고, 스택이 비어있으면 올바른 괄호 문자열임
      if (stack.isEmpty())
        answer++;
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
