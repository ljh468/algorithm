package 배열;

import java.util.Scanner;

public class _02_보이는학생 {
  public int solution1(int n, int[] ints) {
    int answer = 0;
    return answer;
  }

  public static void main(String[] args) {
    _02_보이는학생 t = new _02_보이는학생();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    System.out.println(t.solution1(n, arr));
  }
}
