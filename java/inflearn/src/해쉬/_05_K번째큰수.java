package 해쉬;

import java.util.*;

/**
 * 현수는 1부터 100사이의 자연수가 적힌 N장의 카드를 가지고 있습니다. 같은 숫자의 카드가 여러장 있을 수 있습니다.
 * 현수는 이 중 3장을 뽑아 각 카드에 적힌 수를 합한 값을 기록하려고 합니다. 3장을 뽑을 수 있는 모든 경우를 기록합니다.
 * 기록한 값 중 K번째로 큰 수를 출력하는 프로그램을 작성하세요.
 * 만약 큰 수부터 만들어진 수가 25 25 23 23 22 20 19......이고 K값이 3이라면 K번째 큰 값은 22입니다.
 * <p>
 * 입력
 * 10 3
 * 13 15 34 23 45 65 33 11 26 42
 * <p>
 * 출력
 * 143
 */
public class _05_K번째큰수 {

  public int solution1(int n, int k, int[] arr) {
    int answer = -1;
    // 1. 중복하지 않고 정렬된 자료구조 생성 (이진 검색 트리)
    TreeSet<Integer> treeSet = new TreeSet<>(Collections.reverseOrder()); // 내림차순

    // 2. 3중 for문으로 모든 조합의 수를 구해서 TreeSet에 저장
    for (int i = 0; i < n - 2; i++) {
      for (int j = i + 1; j < n - 1; j++) {
        for (int l = j + 1; l < n; l++) {
          treeSet.add(arr[i] + arr[j] + arr[l]);
        }
      }
    }
    // set.remove() - 제거
    System.out.println("set.remove(0) = " + treeSet.remove(0));
    // set.size() - 개수 확인
    System.out.println("set.size() = " + treeSet.size());
    // set.first() - 가장 위에 있는 값
    System.out.println("treeSet.first() = " + treeSet.first());
    // set.last() - 가장 밑에 있는 값
    System.out.println("treeSet.last() = " + treeSet.last());

    // 3. K번째 큰 수 출력
    int cnt = 0;
    for (int x : treeSet) {
      cnt++;
      if (cnt == k) {
        return x;
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    _05_K번째큰수 t = new _05_K번째큰수();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();

    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    System.out.println(t.solution1(n, k, arr));
  }
}
