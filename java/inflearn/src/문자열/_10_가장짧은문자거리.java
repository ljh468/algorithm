package 문자열;

import java.util.Scanner;

/**
 * 한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성
 *
 * teachermode e -> 1 0 1 2 1 0 1 2 2 1 0
 */
public class _10_가장짧은문자거리 {
  public int[] solution1(String str, char target) {
    // 거리를 담을 char 배열 생성
    int[] address = new int[str.length()];

    // 문자열 길이는 100을 넘지 않기 때문에 거리를 확인할 변수 지정
    int position = 1000;

    // 왼쪽 부터 확인
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == target) {
        position = 0;
        address[i] = position;
      } else{
        position++;
        address[i] = position;
      }
    }
    // 오른쪽 확인
    position = 1000;
    for (int j = str.length()-1; j >= 0; j--) {
      if (str.charAt(j) == target) {
        position = 0;
      } else {
        position++;
        address[j] = Math.min(address[j], position);
      }
    }
    return address;
  }

  public static void main(String[] args) {
    _10_가장짧은문자거리 t = new _10_가장짧은문자거리();
    Scanner sc = new Scanner(System.in);
    String str = sc.next();
    char c = sc.next().charAt(0);
    for (int x : t.solution1(str, c)) {
      System.out.print(x + " ");
    }
  }
}
