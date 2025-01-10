package _07주차_해시;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://school.programmers.co.kr/learn/courses/30/lessons/132265
public class Lv02_롤케이크_자르기 {

  public static void main(String[] args) {
    int[] topping = {1, 2, 1, 3, 1, 4, 1, 2};
    System.out.println("result1 = " + solution1(topping));
    System.out.println("result2 = " + solution2(topping));
  }

  public static int solution1(int[] topping) {
    // 1. 동생이 먹는 토핑 개수를 map으로 관리
    Map<Integer, Integer> map = new HashMap<>();
    // 1-1. 처음은 동생이 모두 먹은 것으로 초기화
    for (int key : topping) {
      map.put(key, map.getOrDefault(key, 0) + 1);
    }

    // 2. 형이 먹는 토핑 개수는 set으로 관리 (중복 X)
    Set<Integer> set = new HashSet<>();

    // 3. 토핑을 순회하면서 초기화되어있는 동생의 토핑에서 제거하고 형의 토핑에 추가
    int count = 0;
    for (int key : topping) {
      set.add(key);
      // map.put(key, map.get(key) - 1);
      // if (map.get(key) == 0) {
      //   map.remove(key);
      // }

      // 값이 0이 되면 제거
      map.computeIfPresent(key, (k, v) -> (v == 1) ? null : v - 1);

      // 3-1. 동생과 형의 토핑의 개수가 같으면 count++
      if (map.size() == set.size()) {
        count++;
      }
    }

    return count;
  }

  private static int solution2(int[] topping) {
    int answer = 0;
    int[][] cnt = new int[2][topping.length];
    HashSet<Integer> set = new HashSet<>();

    // 1. 앞에서 부터 토핑의 가짓수를 저장
    for (int i = 0; i < topping.length; i++) {
      set.add(topping[i]);
      cnt[0][i] = set.size();
    }

    set.clear();

    // 2. 뒤에서 부터 토핑의 가짓수를 저장
    for (int i = topping.length - 1; i >= 0; i--) {
      set.add(topping[i]);
      cnt[1][i] = set.size();
    }

    // 3. 서로 대각선을 비교해서 같으면 경우의 수 증가 (롤케익이 잘린 경계)
    for (int i = 1; i < topping.length; i++) {
      if (cnt[0][i - 1] == cnt[1][i])
        answer++;
    }

    return answer;
  }
}
