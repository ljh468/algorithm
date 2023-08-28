package 해쉬;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 학급 회장을 뽑는데 후보로 기호 A, B, C, D, E 후보가 등록을 했습니다.
 * 투표용지에는 반 학생들이 자기가 선택한 후보의 기호(알파벳)가 쓰여져 있으며 선생님은 그 기호를 발표하고 있습니다.
 * 선생님의 발표가 끝난 후 어떤 기호의 후보가 학급 회장이 되었는지 출력하는 프로그램을 작성
 *
 * 입력
 * 15
 * BACBACCACCBDEDE
 *
 * 출력
 * C
 *
 */
public class _01_학급회장 {

  public char solution1(int n, String str) {
    char answer = ' ';
    HashMap<Character, Integer> map = new HashMap<>();
    for (char x : str.toCharArray()) {
      map.put(x, map.getOrDefault(x, 0) + 1);
    }

    // key가 있는지 확인
    System.out.println("map.containsKey('F') = " + map.containsKey('F'));

    // key의 갯수
    System.out.println("map.size() = " + map.size());

    // key 제거, 삭제한 value return
    System.out.println("map.remove('A') = " + map.remove('A'));
    System.out.println("map.size() = " + map.size());

    // Map에서 가장 큰값 저장
    int max = Integer.MIN_VALUE;
    for (char key : map.keySet()) {
      if (map.get(key) > max) {
        max = map.get(key);
        answer = key;
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    _01_학급회장 t = new _01_학급회장();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    String str = sc.next();

    System.out.println(t.solution1(n, str));
  }
}
