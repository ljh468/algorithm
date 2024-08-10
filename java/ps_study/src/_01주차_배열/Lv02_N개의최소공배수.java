package _01주차_배열;

public class Lv02_N개의최소공배수 {

  // 1. 최대공약수 함수생성 (유클리드 호제법)
  public int gcd(int a, int b) {
    if (b == 0) return a;
    return gcd(b, a % b);
  }

  public int solution(int[] arr) {
    int answer = arr[0];
    // 2. 순차적으로 배열을 순회하면서 최소공배수 구함
    // 2-1. lcm 공식 : (a * b) / gcd(a, b)
    for (int n : arr) {
      answer = (n * answer) / gcd(n, answer);
    }
    return answer;
  }

  public static void main(String[] args) {
    Lv02_N개의최소공배수 main = new Lv02_N개의최소공배수();
    int[] arr = {2, 6, 8, 14};
    System.out.println("result = " + main.solution(arr));
  }
}