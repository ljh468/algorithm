package _우선순위큐;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

import static java.lang.Math.abs;

public class _우선순위큐_연습 {

  public static void main(String[] args) {
    // 오름차순
    // PriorityQueue<Integer> pq = new PriorityQueue<>();

    // 내림차순
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

    // 사용자정의 우선순위 큐
    PriorityQueue<Integer> pq3 = new PriorityQueue<>(Comparator.comparingInt(Math::abs));
    PriorityQueue<Integer> pq4 = new PriorityQueue<>(Comparator.comparingInt(v -> abs((Integer) v)).reversed());

    pq.add(10);
    pq.add(5);
    pq.add(20);
    pq.add(1);

    System.out.println(pq);
    System.out.println("pq.poll() = " + pq.poll());
    System.out.println("pq = " + pq);
  }
}
