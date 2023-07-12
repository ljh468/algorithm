package 투포인터;

import java.util.*;
import java.util.stream.IntStream;

/**
 * 오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성
 * (합쳐서 정렬하는게 아니고 투포인트로 풀라는 의미)
 * <p>
 * 입력
 * 3
 * 1 3 5
 * 5
 * 2 3 6 7 9
 * <p>
 * 출력
 * 1 2 3 3 5 6 7 9
 */
public class _01_두배열_합치기 {

  public List<Integer> solution1(int n, int m, int[] arr1, int[] arr2) {
    List<Integer> answer = new ArrayList<>();
    int p1 = 0, p2 = 0;
    while (p1 < n && p2 < m) {
      if (arr1[p1] < arr2[p2]) {
        answer.add(arr1[p1++]);
      } else {
        answer.add(arr2[p2++]);
      }
    }
    while (p1 < n) {
      answer.add(arr1[p1++]);
    }
    while (p2 < m) {
      answer.add(arr2[p2++]);
    }
    return answer;
  }

  public int[] solution2(int n, int m, int[] arr1, int[] arr2) {
    int[] answer = IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2))
                            .boxed()
                            .sorted()
                            .mapToInt(Integer::intValue)
                            .toArray();

    return answer;
  }

  public static void main(String[] args) {
    _01_두배열_합치기 t = new _01_두배열_합치기();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr1 = new int[n];
    for (int i = 0; i < n; i++) {
      arr1[i] = sc.nextInt();
    }

    int m = sc.nextInt();
    int[] arr2 = new int[m];
    for (int i = 0; i < m; i++) {
      arr2[i] = sc.nextInt();
    }

    for (int x : t.solution1(n, m, arr1, arr2)) {
      System.out.print(x + " ");
    }
    System.out.println();
    for (int x : t.solution2(n, m, arr1, arr2)) {
      System.out.print(x + " ");
    }
  }
}
