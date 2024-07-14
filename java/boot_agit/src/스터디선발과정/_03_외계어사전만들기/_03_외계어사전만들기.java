package 스터디선발과정._03_외계어사전만들기;

import java.util.*;

import static java.util.Objects.isNull;

public class _03_외계어사전만들기 {

  public void printEarliestAlienAlphabetChar(String input) {
    // 고유한 문자를 저장할 set
    Set<Character> uniqueCharsSet = new HashSet<>();
    // 처음 등장한 문자의 인덱스를 저장할 map
    Map<Character, Integer> charFirstIndexMap = new HashMap<>();

    // 각 문자 빈도 계산 및 첫 번째 등장 위치 저장
    for (int i = 0; i < input.length(); i++) {
      char c = input.charAt(i);
      // 중복된 문자라면, 무시
      if (uniqueCharsSet.contains(c)) {
        continue;
      }

      // 알파벳인 경우만 저장
      if (isAlphabetic(c)) {
        uniqueCharsSet.add(c);
        charFirstIndexMap.put(c, i);
      }
    }

    // 중복된 문자 제거 후 남은 문자가 없는 경우 함수 종료
    if (uniqueCharsSet.isEmpty()) {
      System.out.println("중복 제거 후 빈 문자열이 되었습니다.");
      return;
    }

    // 중복된 문자 제거 후 남은 문자 중 사전순으로 가장 앞서는 문자 찾기
    Character firstCharInTheDictionary = null;
    for (Character ch : uniqueCharsSet) {
      // 아스키 숫자가 작은게 사전순으로 작다고 판별
      if (isNull(firstCharInTheDictionary) || ch < firstCharInTheDictionary) {
        firstCharInTheDictionary = ch;
      }
    }
    // 결과 출력
    System.out.println(firstCharInTheDictionary + " (인덱스: " + charFirstIndexMap.get(firstCharInTheDictionary) + ")");
  }

  // 알파벳인지 판별하는 함수
  public boolean isAlphabetic(Character ch) {
    return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String str = scanner.nextLine();
    _03_외계어사전만들기 alienDictionary = new _03_외계어사전만들기();
    alienDictionary.printEarliestAlienAlphabetChar(str.toLowerCase());
  }

}
