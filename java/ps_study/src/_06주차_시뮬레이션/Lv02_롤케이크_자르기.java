package _06주차_시뮬레이션;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://school.programmers.co.kr/learn/courses/30/lessons/132265
public class Lv02_롤케이크_자르기 {

  public static int solution(int[] topping) {
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
      // 형 토핑 추가
      set.add(key);
      // 동생 토핑 제거
      map.put(key, map.get(key) - 1);
      if (map.get(key) == 0) {
        map.remove(key);
      }
      /**
       * computeIfPresent로 대체가능 (null이면 map에서 제거됨)
       * map.computeIfPresent(key, (k, v) -> (v == 1) ? null : v - 1);
       */

      // 3-1. 동생과 형의 토핑의 개수가 같으면 count++
      if (map.size() == set.size()) {
        count++;
      }
      // 3-2. 형의 토핑이 동생의 토핑의 개수보다 많아지면 종료
      else if (set.size() > map.size()) {
        break;
      }
    }

    return count;
  }

  public static void main(String[] args) {
    int[] topping = {1, 2, 1, 3, 1, 4, 1, 2};
    int result = solution(topping);
    System.out.println("result = " + result);
  }
}
