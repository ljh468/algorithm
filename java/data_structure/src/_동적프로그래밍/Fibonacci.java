package _동적프로그래밍;

import java.util.HashMap;

public class Fibonacci {

  /**
   * 성능이 좋지 못한 피보나치 수열
   * - 재귀를 통해서 중복되는 호출이 많아짐
   * - 시간복잡도 : O(n^2)
   * */
  int fibonacci1(int n) {
    // 기저조건
    if (n == 0 || n == 1) {
      return n;
    }
    return fibonacci1(n - 2) + fibonacci1(n - 1);
  }

  /**
   * Memoization (메모이제이션을 이용한 피보나치 수열)
   * - 계산결과를 저장해두어 중복 호출이 되지 않도록함 (메모이제이션)
   * - 계산하려는 데이터가 있는지 "검색"하고 없다면 함수를 호출해 계산을하고 그 결과를 "저장"시키면 됨
   * - 데이터 검색, 삽입이 빠른 해쉬테이블 사용 (key, value)
   * - 재귀를 사용하기때문에 복잡한 문제를 쉽게 해결할 수 있음
   *
   * - 시간복잡도 : O(n)
   * - 그러나, 속도를 위해서 메모리 영역(공간)을 사용
   */
  int fibonacci2(int n, HashMap<Integer, Integer> memo) {
    // 기저조건은 동일
    if (n == 0 || n == 1) {
      return n;
    }
    // 해시테이블에 해당 값의 계산 결과가 있는지 "검색"하고 없으면 "저장"
    if (!memo.containsKey(n)) {
      memo.put(n, fibonacci2(n - 2, memo) + fibonacci2(n - 1, memo));
    }
    // 계산결과가 들어있다면 리턴
    return memo.get(n);
  }

  /**
   * Tabulation (타뷸레이션을 이용한 피보나치 수열)
   * - 상향식 계산 방식으로 계산에 필요한 모든 값을 전부 계산 후 테이블에 저장해둠
   * - 재귀가 직관적이지 않을수도 있는 문제의 경우, 상향식으로 메모리도 절약하고 속도도 빠르게 해결할 수 있음
   */
  int fibonacci3(int n) {
    // 기저조건
    if (n == 0 || n == 1) {
      return n;
    }
    int[] table = new int[n + 1];
    table[0] = 0;
    table[1] = 1;
    // 상향식으로 밑에서부터 계산해 테이블에 결과를 저장
    for (int i = 2; i <= n; i++) {
      table[i] = table[i - 2] + table[i - 1];
      // System.out.printf("i%d >> table%d = %d, table%d = %d, table%d = %d\n", i, i - 2, table[i - 2], i - 1, table[i - 1], i, table[i]);
    }
    return table[n];
  }

  public static void main(String[] args) {
    int n = 40;
    HashMap<Integer, Integer> memo = new HashMap<>();

    Fibonacci fibonacci = new Fibonacci();

    // 1 나노초는 0.000001 밀리초, 1m/s = 1,000,000 n/s
    // 1 밀리초는 0.001 초, 1s = 1,000 ms
    long startTime1 = System.nanoTime();
    int result1 = fibonacci.fibonacci1(n);
    long endTime1 = System.nanoTime();
    System.out.println("result 1 = " + result1);
    System.out.println("fibonacci1 함수 실행시간: " + (endTime1 - startTime1) + "ns\n");

    long startTime2 = System.nanoTime();
    int result2 = fibonacci.fibonacci2(n, memo);
    long endTime2 = System.nanoTime();
    System.out.println("result 2 = " + result2);
    System.out.println("fibonacci2 함수 실행시간: " + (endTime2 - startTime2) + "ns\n");

    long startTime3 = System.nanoTime();
    int result3 = fibonacci.fibonacci3(n);
    long endTime3 = System.nanoTime();
    System.out.println("result 3 = " + result3);
    System.out.println("fibonacci3 함수 실행시간: " + (endTime3 - startTime3) + "ns");
  }

}
