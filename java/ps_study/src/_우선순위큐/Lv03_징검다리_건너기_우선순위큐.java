package _우선순위큐;

import java.util.PriorityQueue;

// https://school.programmers.co.kr/learn/courses/30/lessons/64062
// 우선순위 큐 풀이법
public class Lv03_징검다리_건너기_우선순위큐 {

  public static void main(String[] args) {
    int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
    int k = 3;
    System.out.println("result = " + solution(stones, k));
  }

  /**
   * k범위 안에 최대값을 찾고, k범위 만큼 구간을 이동하면서<p>
   * 모든 구간(k 범위)의 최대값을 찾음, 그 최대값중에 건널수 있는 최대 인원수 임<p>
   * 구간이 이동할 때마다 가장 앞에 있는 값을 제거해줘야 함 - 우선순위큐를 이용할 수 있음
   * <br>
   * 우선순위 큐에 (숫자, 인덱스) 쌍을 넣음, 구간을 이동할 때 마다<p>
   * (현재 인덱스 - K)값과 최고 큰값을 인덱스를 비교해서 최고 큰값의 인덱스가 작으면 제거(이미 지나온 데이터)<p>
   * - 이미 지나온 데이터라면? (인덱스 - K) > (큐에선 뺀 인덱스)
   * - 제거하고 다음 큐에서 가장 큰 값을 빼서 다시 비교
   */
  private static class Stone {
    int idx, val;

    public Stone(int idx, int val) {
      this.idx = idx;
      this.val = val;
    }
  }

  // 시간복잡도 : O(NlogN)
  public static int solution(int[] stones, int k) {
    PriorityQueue<Stone> pq = new PriorityQueue<>(
        (o1, o2) -> Integer.compare(o2.val, o1.val)); // val를 기준으로 오름차순

    // 1. 먼저 k만큼 최대힙에 넣어줌
    int i;
    for (i = 0; i < k; i++) {
      pq.add(new Stone(i, stones[i]));
    }

    // 2. 처음에는 최대힙에서 가장 큰 값을 정답으로 초기화
    int count = pq.peek().val;

    // 3. 현재 인덱스가 stones 길이보다 작을 때 순회, O(N)
    while (i < stones.length) {
      // 3-1. 다음 인덱스의 스톤을 넣고 (i가 k일 것), 현재 인덱스를 증가, O(NlogN)
      pq.add(new Stone(i, stones[i]));
      i++;

      // 3-2. (i-k)보다 작으면 이미 지나온 데이터이므로 제거, O(NlogN)
      while (pq.peek().idx < (i - k)) {
        pq.poll();
      }

      // 3-3. 해당 구간의 최대값 중 최소값을 찾아서 정답 갱신
      count = Math.min(count, pq.peek().val);
    }
    return count;
  }
}
