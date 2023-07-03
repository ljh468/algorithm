package 배열;

import java.util.Scanner;

public class _05_소수_에라토스테네스_체 {
  public int solution1(int n) {
    int answer = 0;
    for (int i = 2; i < n; i++) {
      if (isPrime(i)) {
        answer++;
      }
    }
    return answer;
  }

  public boolean isPrime(int n) {
    if (n < 2) {
      return false;
    }
    for (int i = 2; i <= Math.sqrt(n); i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

  public int solution2(int n) {
    int answer = 0;

    // 소수를 체크하기 위한 배열 (기본 false)
    boolean[] primeNumbers = new boolean[n + 1];

    // 범위에 지정되지 않는 기본 소수 체크
    primeNumbers[0] = true;
    primeNumbers[1] = true;

    // 2부터 소수 체크
    for (int i = 2; i <= Math.sqrt(n); i++) {

      // 해당 인덱스의 수가 소수라면
      if (!primeNumbers[i]) {

        // 해당 인덱스의 배수를 체크하여 소수가 아니라고 표시
        for (int j = i * i; j <= n; j += i) {
          // 여기서 초기 값을 i*i로 잡을 수 있는 이유는 i*i 이하의 값은 이미 이전 작업에서 처리되었기 때문
          primeNumbers[j] = true;
        }
      }
    }

    for (int i = 0; i < primeNumbers.length; i++) {
      if (!primeNumbers[i]) {
        answer++;
        // System.out.println(i);
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    _05_소수_에라토스테네스_체 t = new _05_소수_에라토스테네스_체();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    System.out.println(t.solution1(n));
    System.out.println(t.solution2(n));
  }
}
