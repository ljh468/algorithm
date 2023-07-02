package 배열;

import java.util.Scanner;

/**
 * 설명
 * 1) 피보나키 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.
 * 2) 입력은 피보나치 수열의 총 항의 수 이다. 만약 7이 입력되면 1 1 2 3 5 8 13을 출력하면 된다.
 * 입력 : 10
 * 출력 : 1 1 2 3 5 8 13 21 34 55
 */
public class _04_피보나치수열 {

  public int[] solution1(int n) {
    int[] answer = new int[n];
    answer[0] = 1;
    answer[1] = 1;
    for (int i = 2; i < n; i++) {
      answer[i] = answer[i - 2] + answer[i - 1];
    }
    return answer;
  }

  public void solution2(int n) {
    for (int i = 0; i < n; i++) {
      System.out.print(fibonacci(i) + " ");
    }
  }

  public int fibonacci(int n) {
    if (n <= 1) {
      return 1;
    } else {
      return fibonacci(n - 2) + fibonacci(n - 1);
    }
  }

  public static void main(String[] args) {
    _04_피보나치수열 t = new _04_피보나치수열();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    for (int result : t.solution1(n)) {
      System.out.print(result + " ");
    }
    System.out.println();
    t.solution2(n);
  }
}
