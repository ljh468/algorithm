package 이진탐색;

// https://school.programmers.co.kr/learn/courses/30/lessons/64062
// 이분탐색 풀이법
public class Lv03_징검다리_건너기_이진탐색 {

  public static void main(String[] args) {
    int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
    int k = 3;
    System.out.println("result = " + solution(stones, k));
  }

  // 시간복잡도 : O(NlogN)
  public static int solution(int[] stones, int k) {
    int left = 1; // 최소 가능한 사람 수
    int right = 200_000_000; // 최대 가능한 사람 수 (stones 원소의 최대값)
    int answer = 0;

    while (left <= right) {
      int mid = (left + right) / 2;

      if (canCross(stones, k, mid)) {
        // 현재 인원(mid)로 건너갈 수 있다면 더 많은 사람이 건널 수 있는지 확인
        answer = mid;
        left = mid + 1;
      } else {
        // 현재 인원(mid)로는 건널 수 없으므로 인원 수를 줄임
        right = mid - 1;
      }
    }
    return answer;
  }

  private static boolean canCross(int[] stones, int k, int people) {
    int skip = 0; // 연속으로 밟을 수 없는 디딤돌 수

    for (int stone : stones) {
      if (stone - people < 0) {
        skip++; // 연속으로 밟을 수 없는 디딤돌 증가
        if (skip >= k) {
          return false; // 건널 수 없는 경우 즉시 반환
        }
      } else {
        skip = 0; // 밟을 수 있는 경우 skip 초기화
      }
    }

    return true; // 모든 디딤돌을 건널 수 있음
  }
}