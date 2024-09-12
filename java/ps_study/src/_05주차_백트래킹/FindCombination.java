package _05주차_백트래킹;

import java.util.ArrayList;
import java.util.List;

public class FindCombination {
  // 사용할 숫자들
  static List<Integer> nums = List.of(1, 2, 3, 4);

  // 목표 합
  static int target = 5;

  // 현재 조합
  static List<Integer> current = new ArrayList<>();

  // 현재 조합으로 합이 target이 되면 결과를 출력하고 더 탐색하지 않음
  public static void findCombinations(int index) {
    int sum = 0;
    // 현재 조합의 합을 계산
    for (int num : current) {
      sum += num;
    }

    // 조건 1: 합이 목표 값과 같으면 출력하고 재귀 종료
    if (sum == target) {
      System.out.println(current);
      return;
    }

    // 2. 합이 목표 값을 넘으면 더 이상 탐색하지 않음
    if (sum > target) {
      return;
    }

    // 유망한 경우에만 다음 숫자를 추가하여 탐색을 계속함
    for (int i = index; i < nums.size(); ++i) {
      current.add(nums.get(i));
      findCombinations(i + 1);
      current.remove(current.size() - 1); // 백트래킹: 마지막 추가된 숫자를 제거
    }
  }

  public static void main(String[] args) {
    findCombinations(0);
  }
  
}
