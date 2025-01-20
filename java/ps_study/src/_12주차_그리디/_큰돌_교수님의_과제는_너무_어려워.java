package _12주차_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 큰돌 교수님은 데이터 분석 과목을 담당하고 있으며, 학생들의 성적 분석을 과제로 내주었습니다.<p>
 * 교수님은 과제에서 최하위 성적을 받은 5명의 학생에게 추가적인 지도를 해주기로 결정했습니다.<p>
 * 이들 중 성적이 좋지 않은 5명을 선발하여 따로 지도를 해주려 합니다.<p>
 * 교수님을 돕기 위해 학생들의 최종 성적이 주어질 때,<p>
 * 성적이 좋지 않은 5명의 학생을 선택하여 성적이 낮은 순서대로 출력하는 프로그램을 작성하세요.<p>
 * 첫째 줄에 학생의 수 N이 주어집니다.(6 ≤ N ≤ 50,000,000)<p>
 */
public class _큰돌_교수님의_과제는_너무_어려워 {

  // 입력예시:
  // 8
  // 95.6
  // 74.3
  // 88.2
  // 53.1
  // 45.5
  // 92.7
  // 67.9
  // 88.2
  //
  // 출력예시:
  // 45.5
  // 53.1
  // 67.9
  // 74.3
  // 88.2
  //

  /**
   * 아이디어:<p>
   * - 학생 수가 5000만까지 들어올 수 있기 때문에 배열에 넣으면, 공간복잡도에 문제가 생길 수 있음<p>
   * - 우선순위 큐를 이용해서 가장 작은 값 5개만 유지하게 하면 될 것<p>
   * <br>
   * 풀이법:<p>
   * - 우선순위 큐(최대힙)으로 생성<p>
   * - 학생의 점수를 우선순위 큐에 넣다가 5개까지 넣으면, 하나 더 넣고 가장 큰 값을 제거해줌<p>
   * - 모든 학생의 점수를 입력하고 나면, 우선순위 큐에는 가장 작은 점수 5개가 들어있을 것<p>
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    // 최대 힙 생성 (내림차순)
    PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
    for (int i = 0; i < N; i++) {
      double score = Double.parseDouble(br.readLine());

      // 5개면 1개더 넣고, 가장 큰 값 빼주기
      if (pq.size() == 5) {
        pq.add(score);
        pq.poll(); // 가장 큰 값 제거
      } else {
        pq.add(score);
      }
    }

    double[] result = new double[5];
    for (int i = 4; i >= 0 && !pq.isEmpty(); i--) {
      result[i] = pq.poll();
    }

    for (int i = 0; i < 5; i++) {
      System.out.println(result[i]);
    }
    br.close();
  }
}
