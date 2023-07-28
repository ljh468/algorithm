package 스택;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 현수는 1년 과정의 수업계획을 짜야 합니다.
 * 수업중에는 필수과목이 있습니다. 이 필수과목은 반드시 이수해야 하며, 그 순서도 정해져 있습니다.
 * 만약 총 과목이 A, B, C, D, E, F, G가 있고, 여기서 필수과목이 CBA로 주어지면 필수과목은 C, B, A과목이며 이 순서대로 꼭 수업계획을 짜야 합니다.
 * 여기서 순서란 B과목은 C과목을 이수한 후에 들어야 하고, A과목은 C와 B를 이수한 후에 들어야 한다는 것입니다.
 * 현수가 C, B, D, A, G, E로 수업계획을 짜면 제대로 된 설계이지만
 * C, G, E, A, D, B 순서로 짰다면 잘 못 설계된 수업계획이 됩니다.
 * 수업계획은 그 순서대로 앞에 수업이 이수되면 다음 수업을 시작하다는 것으로 해석합니다.
 * 수업계획서상의 각 과목은 무조건 이수된다고 가정합니다.
 * 필수과목순서가 주어지면 현수가 짠 N개의 수업설계가 잘된 것이면 “YES", 잘못된 것이면 ”NO“를 출력하는 프로그램을 작성하시오
 *
 * 입력
 * CBA
 * CBDAGE
 *
 * 출력
 * YES
 *
 */
public class _07_교육과정설계 {

  // queue 자료구조 사용
  public String solution1(String need, String plan) {
    String answer = "YES";
    // 1. 필수 과목 큐에 저장
    Queue<Character> queue = new LinkedList<>();
    for (char x : need.toCharArray()) {
      queue.offer(x);
    }

    // 2. 필수 과목 순서가 어긋났는지 확인
    for (char x : plan.toCharArray()) {
      // 필수 과목이라면...?
      if (queue.contains(x)) {
        // 듣는 순서가 맞지 않다면...?
        if (x != queue.poll()) {
          return "NO";
        }
      }
    }
    // 3. 필수 과목이 남아있으면 "NO"
    if (!queue.isEmpty()) {
      return "NO";
    }

    return answer;
  }

  public static void main(String[] args) {
    _07_교육과정설계 t = new _07_교육과정설계();
    Scanner sc = new Scanner(System.in);
    String str1 = sc.next();
    String str2 = sc.next();
    System.out.println(t.solution1(str1, str2));
  }
}
