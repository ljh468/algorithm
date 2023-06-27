package 배열;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _01_큰수출력하기 {
  public List<Integer> solution1(int n, int[] ints) {
    List<Integer> answer = new ArrayList<>();
    answer.add(ints[0]);
    for (int i = 1; i < n; i++) {
      if (ints[i] > ints[i-1]) {
        answer.add(ints[i]);
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    _01_큰수출력하기 t = new _01_큰수출력하기();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    for (int x : t.solution1(n, arr)) {
      System.out.print(x + " ");
    }
  }
}
