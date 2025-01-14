package _12주차_그리디;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 큰돌은 도서관의 사서입니다.<p>
 * 그의 도서관에는 학생들이 자유롭게 사용할 수 있는 1개의 좌석이 있습니다.<p>
 * 학생들은 좌석에 앉아서 공부를 하기 위해 특정한 시간에 도착하여 특정한 시간에 떠납니다.<p>
 * 큰돌은 학생들의 스케줄을 조정해 가능한 한 많은 학생들이 좌석을 사용할 수 있도록 배정할 때의 최대 학생 수를 구하세요.
 */
public class _큰돌은_욕심많은_도서관_사서야 {
  // 입력예시:
  // 7
  // 1 4
  // 2 3
  // 3 5
  // 4 6
  // 5 7
  // 7 8
  // 8 9
  //
  // 출력예시:
  // 5

  /**
   * 풀이 방법:
   * 1. 무식하게! -> 경우의 수 2^N -> 안됨
   * 2. DP! -> 풀 수 있음
   * 3. 그리디! -> 정렬 or 우선순위큐
   * 3-1. start를 기준으로 정렬 -> 반례 생김
   * 3-2. end를 기준으로 정렬 -> 가능 -> 풀이 구현
   * 3-3. end - start (len)을 기준으로 정렬
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt(); // n 입력
    List<int[]> intervals = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      int from = scanner.nextInt();
      int to = scanner.nextInt();
      intervals.add(new int[] {to, from}); // 종료 시간 기준으로 저장
    }
    for (int[] interval : intervals) {
      System.out.println("interval = " + Arrays.toString(interval));
    }
    System.out.println();

    // 종료 시간을 기준으로 오름차순 정렬
    intervals.sort((a, b) -> {
      if (a[0] != b[0]) {
        return Integer.compare(a[0], b[0]);
      }
      return Integer.compare(a[1], b[1]);
    });

    for (int[] interval : intervals) {
      System.out.println("interval = " + Arrays.toString(interval));
    }

    int ret = 1;
    int to = intervals.get(0)[0]; // 첫 번째 작업의 종료 시간

    for (int i = 1; i < n; i++) {
      if (intervals.get(i)[1] < to) {
        continue; // 겹치는 경우 무시
      }
      to = intervals.get(i)[0]; // 새로운 작업의 종료 시간 업데이트
      ret++;
    }

    System.out.println(ret); // 결과 출력
  }
}
