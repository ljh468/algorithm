package 해쉬;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 현수의 아빠는 제과점을 운영합니다.
 * 현수아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 매출액의 종류를 각 구간별로 구하라고 했습니다.
 * 만약 N=7이고 7일 간의 매출기록이 아래와 같고, 이때 K=4이면
 * 20 12 20 10 23 17 10
 * 각 연속 4일간의 구간의 매출종류는
 * 첫 번째 구간은 [20, 12, 20, 10]는 매출액의 종류가 20, 12, 10으로 3이다.
 * 두 번째 구간은 [12, 20, 10, 23]는 매출액의 종류가 4이다.
 * 세 번째 구간은 [20, 10, 23, 17]는 매출액의 종류가 4이다.
 * 네 번째 구간은 [10, 23, 17, 10]는 매출액의 종류가 3이다.
 *
 * N일간의 매출기록과 연속구간의 길이 K가 주어지면 첫 번째 구간부터 각 구간별
 * 매출액의 종류를 출력하는 프로그램을 작성하세요.
 *
 * 입력
 * 7 4
 * 20 12 20 10 23 17 10
 *
 * 출력
 * 3 4 4 3
 *
 */
public class _03_매출액의_종류 {

  // 해쉬맵과 슬라이딩 윈도우를 활용해서 풀이
  public ArrayList<Integer> solution1(int n, int k, int[] arr) {
    ArrayList<Integer> answer = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();

    // 슬라이딩 윈도우 k-1개 만큼 초기값 세팅
    for (int i = 0; i < k - 1; i++) {
      map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
    }

    // 슬라이딩 윈도우를 k칸으로 만들기위해 rt를 이동
    int lt = 0;
    for (int rt = k - 1; rt < n; rt++) {
      // rt를 이동하여 슬라이딩 윈도우 완성
      map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
      answer.add(map.size());

      // 슬라이딩 윈도우를 이동하기 위해 lt를 제거
      map.put(arr[lt], map.get(arr[lt]) - 1);

      // 만약 map의 vlaue가 0이면 key값 제거
      if (map.get(arr[lt]) == 0) {
        map.remove(arr[lt]);
      }
      // lt 이동
      lt++;
    }

    return answer;
  }

  public static void main(String[] args) {
    _03_매출액의_종류 t = new _03_매출액의_종류();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();
    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    for (int x : t.solution1(n, k, arr)) {
      System.out.print(x + " ");
    }
  }
}
