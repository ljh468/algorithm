package _10주차_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11650
public class BOJ_11650_좌표_정렬하기 {

  public static void main(String[] args) throws IOException {
// 입력예시
// 5
// 3 4
// 1 1
// 1 -1
// 2 2
// 3 3
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    // 좌표를 x좌표가 증가하는 순으로, x좌표가 같으면 y좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성
    Point[] points = new Point[n];
    StringTokenizer st;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }

    // 레퍼런스 타입은 Tim Sort로 동작하고, Stable Sort (직전 순서 보장) 임.
    Arrays.sort(points, (o1, o2) -> {
      if (o1.x == o2.x) {
        return Integer.compare(o1.y, o2.y);
      }
      return Integer.compare(o1.x, o2.x);
    });

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      sb.append(points[i].x).append(" ").append(points[i].y).append("\n");
    }

    System.out.println(sb);
    // 출력예시
    // 1 -1
    // 1 1
    // 2 2
    // 3 3
    // 3 4
  }

  public static class Point {
    int x;
    int y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public String toString() {
      return "Point{" +
          "x=" + x +
          ", y=" + y +
          '}';
    }
  }
}
