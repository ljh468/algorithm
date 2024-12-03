package _01주차;

// https://school.programmers.co.kr/learn/courses/30/lessons/43165
public class Lv02_타겟넘버 {

  static int total = 0;

  public static void main(String[] args) {
    int[] numbers = {4, 1, 2, 1};
    int target = 4;
    int result = solution(numbers, target);
    System.out.println("result = " + result);
  }

  public static int solution(int[] numbers, int target) {
    recursive(numbers, target, 0, 0);
    return total;
  }

  private static void recursive(int[] numbers, int target, int curLevel, int sum) {
    // 기저조건: 만약 그래프의 레벨이 끝까지 가면 종료
    if (curLevel == numbers.length) {
      // target과 값이 같으면 경우의 수 증가
      if (sum == target) {
        total++;
      }
      return;
    }
    recursive(numbers, target, curLevel + 1, sum + numbers[curLevel]);
    recursive(numbers, target, curLevel + 1, sum - numbers[curLevel]);
  }

}
