package _05주차_백트래킹;

public class _2400이_포함된_숫자찾기 {

  static final int INF = 0x3f3f3f3f;

  // 입력값 예시:
  static int n = 200;

  static int count;

  public static void main(String[] args) {

    // for문 완전탐색
    count = 0;
    for (int i = 2400; i < INF; i++) {
      String str = String.valueOf(i);
      if (str.contains("2400")) {
        count++;
        if (count == n) {
          // 출력값 예시 : 492400
          System.out.println(str);
          break;
        }
      }
    }

    // while문 완전탐색
    count = 0;
    int num = 2400;
    while (true) {
      String str = String.valueOf(num);
      if (str.contains("2400")) {
        count++;
        if (count == n) {
          System.out.println(str);
          break;
        }
      }
      num++;
    }

  }
}
