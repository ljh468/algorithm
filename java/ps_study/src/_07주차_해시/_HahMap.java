package _07주차_해시;

import java.util.HashMap;
import java.util.Map;

public class _HahMap {

  public static void main(String[] args) {

    // V getOrDefault(Object Key, Object defaultValue)
    // - key의 값을 가져오고 만약 값이 없거나 null이면 default값을 가져온다.
    Map<String, Integer> map = new HashMap<>();
    map.put("A", 5);
    map.put("B", 6);

    System.out.println("### getOrDefault ###");
    System.out.println(map.getOrDefault("A", 77)); // result 5
    System.out.println(map.getOrDefault("C", 77)); // result 77
    System.out.println("map = " + map);
    System.out.println();

    // V putIfAbsent(Object Key, Object Value)
    // - key의 값이 없거나 null면 값을 추가한다. (key값이 존재하면 무시)
    System.out.println("### putIfAbsent ###");
    System.out.println(map.putIfAbsent("A", 77)); // result 5
    System.out.println(map.putIfAbsent("C", 77)); // result null
    System.out.println("map = " + map);
    System.out.println();

    // V compute(K key,BiFunction<? super K, ? super V, ? extends V> remappingFunction)
    // - Key의 값에 대해서 어떻게 연산할지 정의한다.
    // - 기존의 키에 대한 값이 없는 경우 V는 null, (NullPointerException 주의)
    // - 연산을 통해 null이 되면 제거된다.
    System.out.println("### compute ###");
    map.put("D", 1);
    System.out.println(map.compute("D", (k, v) -> v == 1 ? null : v - 1)); // "D"는 제거됨
    System.out.println(map.compute("C", (k, v) -> v == 1 ? null : v - 1)); // result 76
    System.out.println("map = " + map);
    System.out.println();

    // V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction)
    // - compute와 동일하다. 다만 key의 값이 없을 경우에만 Function이 실행
    System.out.println("### computeIfAbsent ###");
    map.computeIfAbsent("A", key -> 10);
    map.computeIfAbsent("D", key -> 10);
    map.computeIfAbsent("D", key -> 10);
    System.out.println("map = " + map);
    System.out.println();

    // V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction)
    // computeIfAbsent와 반대로 key의 값이 존재할 경우에만 Function이 실행
    // - 연산을 통해 null이 되면 제거된다.
    System.out.println("### computeIfPresent ###");
    System.out.println(map.computeIfPresent("A", (s, number) -> number * number)); // result : 25
    System.out.println(map.computeIfPresent("B", (s, number) -> null)); // result : null
    System.out.println(map.computeIfPresent("F", (s, number) -> 10)); // result : null
    System.out.println("map = " + map);
  }
}
