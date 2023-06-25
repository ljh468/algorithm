package 문자열;

import java.util.Scanner;

/**
 * 알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우
 * 반복되는 문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축하는 프로그램을 작성하시오.
 *
 * KSTTTSEEKFKKKDJJGG -> KST3SE2KFK3DJ2G2
 */
public class _11_문자열압축 {

  public String solution1(String str) {

    // 문자의 갯수를 셀 변수
    int count = 1;
    StringBuilder arr = new StringBuilder();
    char front = str.charAt(0);
    arr.append(front);

    for (int i = 1; i < str.length(); i++) {
      char next = str.charAt(i);
      if (front == next) {
        count++;
        front = next;
      } else {
        if (count > 1) {
          arr.append(count);
        }
        arr.append(str.charAt(i));
        count = 1;
        front = str.charAt(i);
      }
    }
    if (count > 1) {
      arr.append(count);
    }
    return arr.toString();
  }

  public String solution2(String str) {
    StringBuilder answer = new StringBuilder();
    str = str + " ";
    int count = 1;
    for (int i = 0; i < str.length() - 1; i++) {
      if (str.charAt(i) == str.charAt(i + 1)) {
        count++;
      } else {
        answer.append(str.charAt(i));

        if (count > 1) {
          answer.append(count);
          count = 1;
        }
      }
    }
    return answer.toString();
  }

  public static void main(String[] args) {
    _11_문자열압축 t = new _11_문자열압축();
    Scanner sc = new Scanner(System.in);
    String str = sc.next();
    System.out.println(t.solution1(str));
    System.out.println(t.solution2(str));
  }
}
