package _01주차;

import java.util.ArrayDeque;

// https://school.programmers.co.kr/learn/courses/30/lessons/17680
public class Lv02_캐시 {

  private static final int HIT = 1;

  private static final int MISS = 5;

  public static int solution(int cacheSize, String[] cities) {
    // 캐시 크기가 0이면 모든 요청이 캐시 미스로 처리됨
    if (cacheSize == 0) {
      return cities.length * 5;
    }

    int time = 0;
    ArrayDeque<String> deque = new ArrayDeque<>();
    for (String c : cities) {
      String city = c.toLowerCase();
      if (deque.contains(city)) {
        time += HIT;
        deque.remove(city);
        deque.addLast(city);
      } else {
        time += MISS;
        deque.addLast(city);
        if (deque.size() > cacheSize) {
          deque.removeFirst();
        }
      }
    }
    return time;
  }

  public static void main(String[] args) {
    int cacheSize1 = 3;
    String[] cities1 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
    int result1 = solution(cacheSize1, cities1);
    System.out.println("result1 = " + result1);

    int cacheSize2 = 2;
    String[] cities2 = {"Jeju", "Pangyo", "NewYork", "newyork"};
    int result2 = solution(cacheSize2, cities2);
    System.out.println("result2 = " + result2);

    int cacheSize3 = 0;
    String[] cities3 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
    int result3 = solution(cacheSize3, cities3);
    System.out.println("result3 = " + result3);
  }
}
