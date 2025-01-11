package _05주차_백트래킹;

public class _승철이의_문단속 {

  // 요석의 숫자가 저장된 배열
  private static int[] arr;

  // 요석의 개수
  private static int n;

  // 소수인지 판별하는 함수
  public static boolean isPrime(int n) {
    if (n <= 1) return false; // 소수는 1보다 큰 자연수
    if (n == 2) return true; // 2는 소수임
    if (n % 2 == 0) return false; // 짝수는 소수가 아님

    // 3부터 n제곱근까지만 검사 (n제곱근이 넘어가면 약수가 대칭됨)
    for (int i = 3; i * i <= n; i++) {
      if (n % i == 0) return false;
    }
    return true;
  }

  // 재귀 함수: idx는 현재 인덱스, sum은 현재까지의 합
  public static int go(int idx, int sum) {
    // 기저조건 (요석을 모두 확인하면 종료)
    // 모든 인덱스의 탐색이 마무리되면 소수판별
    if (idx == n) {
      return isPrime(sum) ? 1 : 0;  // 현재 합이 소수이면 1을 반환
    }
    // 현재 상태의 숫자를 포함하는 경우와 포함하지 않는 경우로 계속 탐색
    // 탐색을 통해 누적된 경우의 수를 더해서 리턴
    return go(idx + 1, sum + arr[idx]) + go(idx + 1, sum);
  }

  public static void main(String[] args) {
    n = 3;
    arr = new int[]{24, 35, 38, 40, 49, 59, 60, 67, 83, 98};

    // 재귀적으로 소수의 합을 구하는 함수 호출
    System.out.println(go(0, 0));
  }
}

