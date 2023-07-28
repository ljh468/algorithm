package 스택;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _06_공주구하기 {

  // queue 자료구조 사용
  public int solution1(int n, int k) {
    int answer = 0;

    // 1. 큐 자료구조에 왕자들을 저장
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 1; i <= n; i++) {
      queue.offer(i);
    }

    // 2. k번째 왕자 제거
    while (!queue.isEmpty()) {
      // k - 1 번째 왕자는 다시 큐에 저장
      for (int i = 1; i < k; i++) {
        queue.offer(queue.poll());
      }
      // k번째 왕자 제거
      queue.poll();

      // 왕자 1명만 남으면 출력
      if (queue.size() == 1) {
        answer = queue.poll();
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    _06_공주구하기 t = new _06_공주구하기();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();
    System.out.println(t.solution1(n, k));
  }
}
