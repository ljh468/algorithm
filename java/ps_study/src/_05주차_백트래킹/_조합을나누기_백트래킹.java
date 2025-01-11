package _05주차_백트래킹;

public class _조합을나누기_백트래킹 {

  static int n;

  static int[] arr;

  // 답이 될 수 없는 범위로 초기값을 설정
  static int maxResult = 0;

  static int mod;

  static int count = 0;

  static void go(int idx, int sum) {
    // 유망함수
    // mod N으로 나올수 있는 숫자의 범위는 (0 ~ n-1)
    if (maxResult == (mod - 1)) {
      return;
    }
    // 기저조건 (탐색이 끝났으면 종료)
    if (idx == n) {
      // 11로 나눴을때 큰값이면 갱신
      maxResult = Math.max(maxResult, sum % mod);
      count++;
      return;
    }

    // 계속 탐색
    // 현재 상태를 포함하는 경우
    go(idx + 1, sum + arr[idx]);
    // 현재 상태를 포함하지 않는 경우
    go(idx + 1, sum);
  }

  public static void main(String[] args) {
    n = 10;
    mod = 11;
    arr = new int[]{24, 35, 38, 40, 49, 59, 60, 67, 83, 98};
    go(0, 0);
    System.out.println("result = " + maxResult);
    System.out.println("count = " + count);
  }
}
