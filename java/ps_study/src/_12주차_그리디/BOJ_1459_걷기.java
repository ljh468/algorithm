package _12주차_그리디;

import java.util.Scanner;

/**
 * 핵심 아이디어: <p>
 * 이동 방식:<p>
 * 세준이는 한 블록을 가로나 세로로 이동하거나, 대각선으로 이동할 수 있음<p>
 * 각각의 이동 시간<p>
 * - 가로나 세로 이동: 한 블록당 W 시간<p>
 * - 대각선 이동: 한 블록당 S 시간<p>
 * 조건:<p>
 * 2W <= S : 대각선 이동이 더 비싸므로, 가로나 세로 이동만 하는 것이 더 유리.<p>
 * <br>
 * W > S : 대각선 이동이 항상 유리하므로, 대각선으로 가능한 만큼 이동 후, 나머지는 가로나 세로로 이동.<p>
 * - (X + Y)가 짝수라면 모든 이동을 대각선으로, 홀수라면 마지막에 직선 이동이 필요.
 * - 시간계산은 max(X, Y) * S
 * <br>
 * 나머지 경우 : 대각선 이동이 일부 유리할 경우, 가능한 만큼 대각선 이동 후 나머지는 직선 이동.<p>
 * - 시간계산은 (min(X, Y) * S) + (|X-Y| * W)<p>
 * - 대각선 으로 가능한 최대 거리 + 직선으로 이동해야할 거리<p>
 */
// https://www.acmicpc.net/problem/1459
public class BOJ_1459_걷기 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // 입력 처리
    long x = sc.nextLong(); // 집의 X 좌표
    long y = sc.nextLong(); // 집의 Y 좌표
    long w = sc.nextLong(); // 직선 이동 시간
    long s = sc.nextLong(); // 대각선 이동 시간

    // 최소 시간 계산 변수
    long time;

    // 대각선 이동이 비효율적일 경우, 모든 이동을 직선으로만 수행
    if (2 * w <= s) {
      time = (x + y) * w;
    }
    // 대각선 이동이 항상 직선 이동보다 효율적일 경우
    else if (w > s) {
      // x + y가 짝수일 경우, 대각선만으로 도달 가능
      if ((x + y) % 2 == 0) {
        time = Math.max(x, y) * s;
      }
      // x + y가 홀수일 경우, 대각선으로 이동 후 1칸 직선 이동 필요
      else {
        time = (Math.max(x, y) - 1) * s + w;
      }
    }
    // 대각선 이동이 직선보다 유리하긴 하지만 완전히 효율적이지는 않은 경우
    else {
      long minCoordinate = Math.min(x, y); // 대각선으로 이동 가능한 거리
      long remaining = Math.abs(x - y); // 나머지 직선 이동 거리
      time = minCoordinate * s + remaining * w;
    }

    // 결과 출력
    System.out.println(time);
  }
}
