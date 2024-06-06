package _재귀;

/**
 * 팩토리얼은 n이 주어질 때 1부터 n까지 모든 수의 곱을 말함
 */
public class Factorial {

  int factorial(int number) {
    if (number == 1 || number == 0) {
      return 1;
    }
    return number * factorial(number - 1);
  }

  public static void main(String[] args) {
    Factorial factorial = new Factorial();
    System.out.println("factorial.factorial(5) = " + factorial.factorial(5));
  }

}
