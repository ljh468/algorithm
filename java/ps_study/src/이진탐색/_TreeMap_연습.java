package 이진탐색;

import java.util.TreeMap;

public class _TreeMap_연습 {

  public static void main(String[] args) {
    TreeMap<Integer, Integer> map = new TreeMap<>();

    // put : O(logN)
    map.put(10, 50);
    map.put(5, 50);
    map.put(15, 50);

    System.out.println("#### 원하는 key값 조회 - O(logN) ####");
    System.out.println("map.get(15) = " + map.get(15));
    System.out.println();

    System.out.println("#### 가장 작은 key값 조회 - O(logN) ####");
    System.out.println("map.firstEntry().getKey() = " + map.firstEntry().getKey());
    System.out.println("map.firstEntry().getValue() = " + map.firstEntry().getValue());
    System.out.println();

    System.out.println("#### 가장 큰 key값 조회 - O(logN) ####");
    System.out.println("map.lastEntry().getKey() = " + map.lastEntry().getKey());
    System.out.println("map.lastEntry().getValue() = " + map.lastEntry().getValue());
    System.out.println();

    System.out.println("#### 찾는 값이 없을때, map에 있는 값 중에 찾는 값보다 큰 값 조회 - O(logN) ####");
    System.out.println("map.ceilingEntry(13).getKey() = " + map.ceilingEntry(13).getKey());
    System.out.println("map.ceilingEntry(13).getValue() = " + map.ceilingEntry(13).getValue());
    System.out.println();

    System.out.println("#### 찾는 값이 없을때, map에 있는 값 중에 찾는 값보다 작은 값 조회 - O(logN) ####");
    System.out.println("map.floorEntry(13).getKey() = " + map.floorEntry(13).getKey());
    System.out.println("map.floorEntry(13).getValue() = " + map.floorEntry(13).getValue());
  }
}
