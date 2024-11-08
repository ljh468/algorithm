package _10주차_정렬;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/42747
public class Lv02_H_Index {

  // 시간복잡도 N^2
  public static int solution1(int[] citations) {
    int hIndex = 0;

    // 1. 논문 순회 (큰 수부터 검색)
    // 발표한 논문중 인용된 논문이 하나 이상인 횟수를 기준점으로 잡아서 하나씩 줄여가면서 조건을 찾기
    int start = 0;
    for (int citation : citations) {
      if (citation > 0) start++;
    }

    // 2. 가능한 H-index를 큰 수부터 감소시키면서 찾기
    // H-index 후보 값(candidateH)을 하나씩 줄여가며 조건을 만족하는지 확인
    for (int candidateH = start; candidateH > 0; candidateH--) {
      int citationCount = 0;
      // 각 논문이 i 번 이상 인용되었는지 확인
      for (int citation : citations) {
        if (citation >= candidateH) citationCount++;
      }
      // 인용된 논문의 개수(h)가 i번 이상인 경우, H-index로 설정하고 종료
      if (citationCount >= candidateH) {
        hIndex = candidateH;
        break;  // 최댓값을 찾으면 바로 종료
      }
    }

    return hIndex;
  }


  // 시간복잡도 NlogN
  public static int solution2(int[] citations) {
    int answer = 0;
    // 1. 인용횟수 배열을 오름차순 정렬
    Arrays.sort(citations);

    // 2. 논문의 수 만큼 반복 (0부터 N까지)
    for (int i = 0; i < citations.length; i++) {
      // 2-1. 논문의 인용횟수와 남은 논문의 개수중 작은값을 계산 (h번 이상 인용된 논문이 h편 이상 조건 찾기)

      // 해당 논문을 포함한 남은 논문의 개수는 정렬되어 있기때문에 h번 이상 인용된 논문보다 인용된 횟수가 h번 이상의 논문들임
      // ex: 0, 1, 3, 5, 6 일때 i가 2일 때
      //     citations[i]는 3, (citations.length - i)는 3
      //     h번 이상 인용된 논문, h편 이상
      int h = Math.min(citations[i], citations.length - i);

      // 2-2. 현재까지의 최대 h-index값을 저장
      answer = Math.max(answer, h);
    }
    return answer;
  }

  public static void main(String[] args) {
    int[] citations1 = {3, 0, 6, 1, 5};
    int[] citations2 = {3, 3, 3, 4};
    int result1 = solution1(citations1);
    int result2 = solution1(citations2);
    System.out.println("result1 = " + result1);
    System.out.println("result2 = " + result2);
    System.out.println();

    int result3 = solution2(citations1);
    int result4 = solution2(citations2);
    System.out.println("result3 = " + result3);
    System.out.println("result4 = " + result4);
  }

}
