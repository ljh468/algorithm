package 해쉬;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Anagram이란 두 문자열이 알파벳의 나열 순서를 다르지만 그 구성이 일치하면 두 단어는 아나그램이라고 합니다.
 * 예를 들면 AbaAeCe 와 baeeACA 는 알파벳을 나열 순서는 다르지만 그 구성을 살펴보면 A(2), a(1), b(1), C(1), e(2)로
 * 알파벳과 그 개수가 모두 일치합니다. 즉 어느 한 단어를 재 배열하면 상대편 단어가 될 수 있는 것을 아나그램이라 합니다.
 * 길이가 같은 두 개의 단어가 주어지면 두 단어가 아나그램인지 판별하는 프로그램을 작성
 * 아나그램 판별시 대소문자가 구분됩니다.
 * 두 단어가 아나그램이면 “YES"를 출력하고, 아니면 ”NO"를 출력
 *
 * 입력
 * AbaAeCe
 * baeeACA
 *
 * 출력
 * YES
 *
 */
public class _02_아나그램 {

  public String solution1(String str1, String str2) {
    String answer = "YES";
    Map<Character, Integer> map = new HashMap<>();
    for (char x : str1.toCharArray()) {
      map.put(x, map.getOrDefault(x, 0) + 1);
    }

    for (char x : str2.toCharArray()) {
      if (!map.containsKey(x) || (map.get(x) == 0)) {
        return "NO";
      } else {
        map.put(x, map.get(x) - 1);
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    _02_아나그램 t = new _02_아나그램();
    Scanner sc = new Scanner(System.in);
    String str1 = sc.next();
    String str2 = sc.next();

    System.out.println(t.solution1(str1, str2));
  }
}
