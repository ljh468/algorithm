package _11주차_동적프로그래밍;

public class Fibonacci {

  public static long fibonacci(int n) {
    // 기저조건
    if (n <= 2) return 1;
    return fibonacci(n - 1) + fibonacci(n - 2);
  }

  public static void main(String[] args) {
    // 피보나치 수열 : 1, 1, 2, 3, 5, 8, 13, 21
    System.out.println("fibonacci(8) = " + fibonacci(8));
  }
}
