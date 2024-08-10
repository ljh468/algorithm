package _01주차_배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Lv01_가장가까운같은글자 {

  // 시간복잡도 O(N^2)
  public int[] solution(String s) {
    // 1. 결과물을 저장할 배열을 만듬
    int[] answer = new int[s.length()];

    // 2. 문자열 순회
    for (int i = 0; i < s.length(); i++) {
      // 2-1. 결과물 배열이 0이 아니면 무시 (계산됨)
      if (answer[i] != 0) continue;

      // 2-2. 처음 나온 글자 -1로 선언
      answer[i] = -1;
      int count = 0;
      for (int j = i + 1; j < s.length(); j++) {
        count++;
        if (s.charAt(i) == s.charAt(j)) {
          answer[j] = count;
          count = 0;
        }
      }
    }
    return answer;
  }

  // 시간복잡도 O(N)
  public int[] solution2(String s) {
    int[] answer = new int[s.length()];
    HashMap<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      answer[i] = i - map.getOrDefault(ch, i + 1);
      map.put(ch, i);
    }
    return answer;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    // 입력 예시:
    // banana
    Lv01_가장가까운같은글자 main = new Lv01_가장가까운같은글자();
    System.out.println("result = " + Arrays.toString(main.solution(str)));
    // [-1, -1, -1, 2, 2, 2]
  }
}
