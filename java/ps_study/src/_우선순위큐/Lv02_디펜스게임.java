package _우선순위큐;

import java.util.Collections;
import java.util.PriorityQueue;

// https://school.programmers.co.kr/learn/courses/30/lessons/142085
public class Lv02_디펜스게임 {

  public static void main(String[] args) {
    int n = 7; // 병사
    int k = 3; // 무적권
    int[] enemy = {4, 2, 4, 5, 3, 3, 1};
    System.out.println("result = " + solution(n, k, enemy));
  }

  /**
   * 핵심 아이디어<p>
   * 모든 적군을 최대힙에 넣어주고, 만약 소모할 병사가 부족하다면<p>
   * 지나온 적군중에 가장 많은 적군을 무적권을 써서 제거하고 병사를 회복시켜줌<p>
   * 이렇게 하면 최대로 진행할 수 있는 라운드가 나옴
   */
  public static int solution(int n, int k, int[] enemy) {
    int round = 0;

    // 1. 최대힙 만들어줌
    PriorityQueue<Integer> pq  = new PriorityQueue<>(Collections.reverseOrder());
    // 2. 적군을 하나씩 뺀다.
    for (int e : enemy) {
      // 2-1. 최대힙에 넣어주고
      pq.add(e);
      // 2-2. 만약 무적권이 있고, 병사 수 보다 적군이 많으면 무적권 사용
      if (k > 0 && n < e) {
        n += pq.poll(); // 회복
        k--; // 무적권 사용
      }
      // 2-3. 병사 수 보다 적군이 적으면 병사 소모
      n -= e;
      // 2-4. 병사가 부족하면 라운드 진행 불가
      if (n < 0){
        break;
      }
      round++;
    }

    return round;
  }
}
