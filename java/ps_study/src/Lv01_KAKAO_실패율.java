import java.util.*;
import java.io.*;

/**
 * 실패율 : https://school.programmers.co.kr/learn/courses/30/lessons/42889
 */
public class Lv01_KAKAO_실패율 {

  public int[] solution(int n, int[] stages) {
    // 1. 스테이지별 도전자 수를 구함 (index:0 사용X, index:n+1 모두 클리어)
    int[] challenger = new int[n + 2];
    for (int stage : stages) {
      challenger[stage] += 1; // 해당 스테이지에 있는 인원 수 추가
    }

    // 2. 스테이지별 실패율을 저장할 맵 선언, 총 인원수 구함
    Map<Integer, Double> failMap = new HashMap<>();
    double total = stages.length;

    // 3. 도전자가 머물고있는 각 스테이지를 순회하며 실패율 저장
    for (int i = 1; i <= n; i++) {
      // 3-1. 실패한 사람이 없으면 0
      if (challenger[i] == 0) {
        failMap.put(i, 0.);
      }
      // 3-2. 실패율 저장 (스테이지에 도달했으나 아직 클리어하지 못한 플레이어 수 / 스테이지에 도달한 플레이어 수)
      else {
        failMap.put(i, challenger[i] / total);
        total -= challenger[i]; // 총인원수에서 현재 스테이지의 인원을 뺌
      }
    }

    // 4. 실패율이 높은 스테이지부터 내림차순 정렬
    return failMap.entrySet()
                  .stream()
                  .sorted((o1, o2) -> {
                    int cmp = Double.compare(o2.getValue(), o1.getValue());
                    if (cmp == 0) {
                      return Integer.compare(o1.getKey(), o2.getKey()); // 실패율이 같으면 스테이지 번호 비교
                    }
                    return cmp;
                  })
                  .mapToInt(HashMap.Entry::getKey).toArray();
  }

  public static void main(String[] args) throws IOException {
    Lv01_KAKAO_실패율 lv01Kakao_실패율 = new Lv01_KAKAO_실패율();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // 예시 :
    // 5
    // 2, 1, 2, 6, 2, 4, 3, 3
    int n = Integer.parseInt(br.readLine());
    int[] arr = Arrays.stream(br.readLine().split(", ")).mapToInt(Integer::valueOf).toArray();
    System.out.println("result = " + Arrays.toString(lv01Kakao_실패율.solution(n, arr)));
  }
}