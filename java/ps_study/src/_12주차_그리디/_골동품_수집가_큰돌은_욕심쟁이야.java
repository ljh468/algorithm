package _12주차_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 골동품 수집가인 큰돌은 세계 여러 곳을 여행하며 희귀한 골동품을 수집해 왔습니다.<p>
 * 이번에 큰돌은 거대한 골동품 박람회에 참석하기로 했습니다.<p>
 * 박람회에서는 다양한 골동품들이 전시되어 있으며, 각각의 골동품은 무게 M[i]와 가치 V[i]를 가지고 있습니다.<p>
 * 큰돌은 자신이 수집한 골동품들을 보관할 수 있는 고급 가방 K개를 가지고 있습니다.<p>
 * 각 가방은 최대C[i] 무게까지 골동품을 담을 수 있으며, 가방 하나에는 최대 한 개의 골동품만 넣을 수 있습니다.<p>
 * 큰돌은 가능한 한 최대한 가치 있는 골동품들을 가방에 넣어 가져가고 싶습니다.<p>
 * 큰돌이 수집할 수 있는 골동품의 가치의 합의 최대값을 구하는 프로그램을 작성하세요.<p>
 */
public class _골동품_수집가_큰돌은_욕심쟁이야 {
  // 입력예시:
  // 4 2
  // 1 100
  // 2 200
  // 11 400
  // 10 500
  // 10
  // 11
  //
  // 출력예시:
  // 900

  /**
   * 아이디어:<p>
   * - 골동품은 무게가 클 수록 가치가 높을 수 있음<p>
   * - 그러면, 가방의 무게에서 담을 수 있는 골동품 중 가장 무거운것을 담으면? (가성비)<p>
   * <br>
   * 풀이법:<p>
   * - 가방을 오름차순으로 정렬<p>
   * - 우선순위 큐(골동품 가치로 정렬)를 활용해서 가방에 담을 수 있는 무게의 골동품은 모두 넣음<p>
   * - 그다음 하나만 빼서 가방에 담음 (골동품의 가치는 누적해서 저장)<p>
   * - 이전에 담은 골동품의 무게들은 신경쓸 필요가 없음
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // N: 골동품의 수, K: 가방의 수
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    // 골동품 정보 입력
    List<Antique> antiques = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int weight = Integer.parseInt(st.nextToken());
      int value = Integer.parseInt(st.nextToken());
      antiques.add(new Antique(weight, value));
    }
    // 골동품을 무게 오름차순으로 정렬
    antiques.sort(Comparator.comparingInt(a -> a.weight));

    // 가방 무게 정보 입력
    List<Integer> bags = new ArrayList<>();
    for (int i = 0; i < K; i++) {
      bags.add(Integer.parseInt(br.readLine().strip()));
    }

    // 가방을 무게 오름차순으로 정렬
    bags.sort(Comparator.naturalOrder());
    System.out.println("bags = " + bags);

    // 최대힙: 가치가 큰 순서대로 골동품 저장
    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

    int num = 0; // 골동품 인덱스
    long totalValue = 0; // 결과 값

    // 각 가방의 무게를 기준으로 골동품 선택
    for (int bagWeight : bags) {
      // 현재 가방이 담을 수 있는 골동품을 우선순위 큐에 추가
      while (num < N && antiques.get(num).weight <= bagWeight) {
        pq.add(antiques.get(num++).value);
      }

      // 큐에서 가장 높은 가치를 가진 골동품 선택
      if (!pq.isEmpty()) {
        totalValue += pq.poll();
      }
    }

    // 결과 출력
    System.out.println(totalValue);
    br.close();
  }

  private record Antique (
      int weight,
      int value
  ){}
}
