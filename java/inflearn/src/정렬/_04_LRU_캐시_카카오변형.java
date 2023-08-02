package 정렬;

import java.util.Scanner;

// LRU 알고리즘은 Least Recently Used 의 약자
public class _04_LRU_캐시_카카오변형 {

  // 마지막 작업 후 캐시메모리의 상태를 가장 최근 사용된 작업부터 차례로 출력
  public int[] solution1(int size, int n, int[] arr) {

    // 1. 캐시메모리 생성
    int[] cache = new int[size];

    // 2. 작업 처리 시작
    for (int x : arr) {

      // 3. cache hit인지 확인
      int idx = -1;
      for (int i = 0; i < size; i++) {
        // cache hit 이면 저장된 위치 저장
        if (cache[i] == x) {
          idx = i;
          break;
        }
      }

      // cache miss가 나면 모두 뒤로 한칸씩 이동하고 해당 값 맨 앞에 저장
      if (idx == -1) {
        for (int i = size - 1; i > 0; i--) {
          cache[i] = cache[i - 1];
        }
      } else {
        // cache hit가 나면 hit가 난 index부터 뒤로 한칸씩 이동하고 해당 값 맨앞으로 저장
        for (int i = idx; i > 0; i--) {
          cache[i] = cache[i - 1];
        }
      }
      cache[0] = x;
    }
    return cache;
  }

  public static void main(String[] args) {
    _04_LRU_캐시_카카오변형 t = new _04_LRU_캐시_카카오변형();
    Scanner sc = new Scanner(System.in);

    int s = sc.nextInt();
    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    for (int x : t.solution1(s, n, arr)) {
      System.out.print(x + " ");
    }
  }
}
