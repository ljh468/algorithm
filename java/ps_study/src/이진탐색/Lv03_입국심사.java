package 이진탐색;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/43238
public class Lv03_입국심사 {

  public static void main(String[] args) {
    int n = 6;
    int[] times = {7, 10};
    System.out.println("result = " + solution(n, times));
  }

  public static long solution(int n, int[] times) {
    // 제약조건:
    // "1 <= [각 심사관이 한 명을 심사하는데 걸리는 시간] <= 10억"
    // "1 <= [기다리는 사람] <= 10억"
    // "1 <= [심사관 수] <= 10만"

    long left = 1;
    long right = (long) 1_000_000_000 * 1_000_000_000; // 최대로 걸릴 수 있는 시간 (2^60)

    // 1. 먼저 최대로 걸릴 수 있는 시간부터, 이진탐색을 하면서 답을 찾아 나감 (최소시간을 찾을 때까지 반복)
    while (left < right) { // 60번 * 10만 = 600만
      long mid = (left + right) / 2;

      // 1-1. mid 시간 안에 끝낼 수 있는지 확인
      if (isPossible(n, times, mid)) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    // 2. 최소로 걸리는 시간을 리턴
    return left;
  }

  private static boolean isPossible(long n, int[] times, long answer) {
    for (int time : times) {
      n -= answer / time;
    }
    return n <= 0;
  }
}
