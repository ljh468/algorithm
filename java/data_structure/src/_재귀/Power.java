package _재귀;

public class Power {

  // 지수함수는 밑을 x로, 지수를 n으로 정의
  public int power(int x, int n) {
    if(n == 0) {
      return 1;
    }
    // 하위문제 * 현재문제
    return power(x, n - 1) * x;
  }

  public static void main(String[] args) {
    Power power = new Power();
    int result = power.power(2, 5);
    System.out.println("result = " + result);
  }

}
