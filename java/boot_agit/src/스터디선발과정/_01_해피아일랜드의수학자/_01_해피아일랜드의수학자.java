package 스터디선발과정._01_해피아일랜드의수학자;

import java.util.HashSet;
import java.util.Set;

public class _01_해피아일랜드의수학자 {

  // 자릿수의 제곱합을 계산하는 함수
  public int sumOfPlaceValue(int n) {
    int sum = 0;
    // 자릿수부터 계산하는 반복문을 수행
    while (n > 0) {
      int placeValue = n % 10; // 나머지 연산을 통해 자릿수를 구함
      sum += placeValue * placeValue; // 해당값의 제곱을 구함
      n /= 10; // 10을 나눈 몫을 다시 n에 저장
    }
    return sum;
  }

  // 재귀를 사용하여 행복한 수인지 판별하는 함수
  public int isHappyValue(int n, Set<Integer> set) {
    // 기저 조건 (결과가 1이면 행복한 수 O)
    if (n == 1) {
      return 1;
    }
    // 기존에 계산한 자릿수의 제곱합이 있는지 확인 (행복한 수 X)
    if (set.contains(n)) {
      return 0;
    }
    // 이전에 계산되었던 값이 아니라면 set자료형에 저장
    set.add(n);
    // 재귀 호출
    return isHappyValue(sumOfPlaceValue(n), set);
  }

  public static void main(String[] args) {
    int n = 19;
    _01_해피아일랜드의수학자 HappyIreland = new _01_해피아일랜드의수학자();
    Set<Integer> set = new HashSet<>();
    System.out.println(HappyIreland.isHappyValue(n, set));
  }

}
