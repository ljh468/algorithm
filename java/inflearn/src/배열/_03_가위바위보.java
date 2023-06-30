package 배열;

import java.util.Scanner;

// 1: 가위, 2: 바위, 3: 보
public class _03_가위바위보 {
  public String solution1(int n, int[] a, int[] b) {
    String answer = "";

    // 비기거나, A가 이기는 경우가 아니라면, 모두 B가 이기는 경우이다.
    for (int i = 0; i < n; i++) {
      if (a[i] == b[i]) {
        // 비김
        answer += "D";
      } else if (a[i] == 1 && b[i] == 3) {
        // A 이김 (가위 > 보)
        answer += "A";
      } else if (a[i] == 2 && b[i] == 1) {
        // A 이김 (바위 > 가위)
        answer += "A";
      } else if (a[i] == 3 && b[i] == 2) {
        // A 이김 (보 > 바위)
        answer += "A";
      } else {
        // 나머지는 모두 B가 이김
        answer += "B";
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    _03_가위바위보 t = new _03_가위바위보();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    int[] a = new int[n];
    int[] b = new int[n];

    for (int i = 0; i < n; i++) {
      a[i] = sc.nextInt();
    }
    for (int i = 0; i < n; i++) {
      b[i] = sc.nextInt();
    }

    for (char x : t.solution1(n, a, b).toCharArray()) {
      System.out.println(x);
    }
  }
}