package _10주차_정렬;

import java.util.Arrays;
import java.util.Collections;

// https://www.acmicpc.net/problem/2750
public class 수_정렬하기_연습01 {

  public static void main(String[] args) {
    int[] arr = {5, 2, 3, 4, 1};
    System.out.println("result = " + Arrays.toString(solution(arr)));
  }

  public static int[] solution(int[] arr) {
    Arrays.sort(arr);
    System.out.println("arr = " + Arrays.toString(arr));
    return arr;
  }

  public static int[] solution2(int[] arr) {
    Integer[] integerArr = Arrays.stream(arr).boxed().toArray(len -> new Integer[len]);
    Arrays.sort(integerArr, Collections.reverseOrder());
    return Arrays.stream(integerArr).mapToInt(i -> i.intValue()).toArray();
  }
}
