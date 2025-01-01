package 연습;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Lv02_귤고르기 {

  public static void main(String[] args) {
    int k1 = 6;
    int[] tangerine1 = {1, 3, 2, 5, 4, 5, 2, 3};
    System.out.println("result = " + solution(k1, tangerine1));

    int k2 = 2;
    int[] tangerine2 = {1, 1, 1, 1, 2, 2, 2, 3};
    System.out.println("result = " + solution(k2, tangerine2));
  }

  public static int solution(int k, int[] tangerine) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int t : tangerine) {
      map.put(t, map.getOrDefault(t, 0) + 1);
    }

    ArrayList<Integer> list = new ArrayList<>(map.values());
    list.sort((v1, v2) -> v2 - v1);
    int count = 0;
    while (k > 0) {
      k -= list.get(count);
      count++;
    }
    return count;
  }
}
